package controller;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image ;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;



import javafx.event.ActionEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import model.Annotation;


import java.io.*;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML private Pane imagePane;
    @FXML private ImageView imageView;
    @FXML private ColorPicker colorPicker;

    private Rectangle rectangle;
    private double originX;
    private double originY;
    private boolean imageLoaded= false;


    private ArrayList <Annotation> annotationList = new ArrayList<>();


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
    }





    @FXML
    private void exit(ActionEvent event)
    {
        Platform.exit();
        System.exit(0);
    }
    @FXML
    private void open(ActionEvent event) throws FileNotFoundException {


        imageView.setDisable(false);
        imageLoaded = false;

        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Image File");
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.gif"));
        File selectedFile = fileChooser.showOpenDialog(null);
        if (selectedFile != null) {
            imagePane.getChildren().clear();
            imagePane.getChildren().add(imageView);
            imageView.setImage(new Image(selectedFile.toURI().toString()));
            imageLoaded = true;
        }
    }

    @FXML
    public void onMousePressed(MouseEvent mouseEvent) {
        if(imageLoaded) {
            if(LabelListController.getInstance().getCurrentLabel()!=null){
                originX = mouseEvent.getX();
                originY = mouseEvent.getY();
                rectangle = new Rectangle();
                rectangle.setX(mouseEvent.getX());
                rectangle.setY(mouseEvent.getY());
                rectangle.setFill(null);
                rectangle.setStroke(LabelListController.getInstance().getCurrentLabel().getColor());
                rectangle.setStrokeWidth(4);
                imagePane.getChildren().addAll(rectangle);
            }

        }
    }

    public void onMouseDragged(MouseEvent mouseEvent) {

        if(imageLoaded) {
            if(LabelListController.getInstance().getCurrentLabel()!=null) {
                rectangle.setWidth(Math.abs(mouseEvent.getX() >= imageView.getFitWidth() ? imageView.getFitWidth() - originX : mouseEvent.getX() - originX));
                rectangle.setHeight(Math.abs(mouseEvent.getY() >= imageView.getFitHeight() ? imageView.getFitHeight() - originY : mouseEvent.getY() - originY));
                rectangle.setX(Math.min(originX, mouseEvent.getX() >= 0 ? mouseEvent.getX() : 0));
                rectangle.setY(Math.min(originY, mouseEvent.getY() >= 0 ? mouseEvent.getY() : 0));
            }
        }
    }

    public void onMouseReleased(MouseEvent mouseEvent) {

        if (imageLoaded) {
            if(LabelListController.getInstance().getCurrentLabel()!=null) {
                double clickedX = mouseEvent.getX();
                double clickedY = mouseEvent.getY();
                double endX = Math.min(originX, clickedX);
                double endY = Math.min(originY, clickedY);
                Label label1 = new Label(LabelListController.getInstance().getCurrentLabel().getName());
                label1.setTextFill(LabelListController.getInstance().getCurrentLabel().getColor());
                label1.setLayoutX(endX);
                label1.setLayoutY(endY - 20);


                annotationList.add(new Annotation(Math.min(originX, clickedX), Math.min(originY, clickedY), rectangle.getWidth(), rectangle.getHeight(), LabelListController.getInstance().getCurrentLabel()));
                imagePane.getChildren().add(label1);
                LabelListController.getInstance().setCurrentLabel(null);
            }
        }
    }

    public void onKeyReleased(KeyEvent keyEvent) {

        if(keyEvent.getCode() == KeyCode.D&& imageLoaded){

                imagePane.getChildren().remove(1,imagePane.getChildren().size());
                annotationList.clear();


        }

        if(keyEvent.getCode() == KeyCode.Z&&imageLoaded){
            if (imagePane.getChildren().size()>=3)
                imagePane.getChildren().remove(imagePane.getChildren().size()-2,imagePane.getChildren().size());
           
            if(!annotationList.isEmpty())
            annotationList.remove(annotationList.size()-1);

        }
    }

    public void export(ActionEvent actionEvent) {


        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Export");
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("CSV files (*.csv)", "*.csv"));
        File selectedFile = fileChooser.showSaveDialog(null);

        if (selectedFile != null) {
            try {
                PrintWriter writer;
                writer = new PrintWriter(selectedFile);
                writer.println("name,color,startX,startY,width,height");

                for (Annotation annotation : annotationList) {
                    writer.println(annotation.toString());
                }
                writer.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

    }

    public void NewLabel(ActionEvent actionEvent) throws IOException {
        LabelListController.getInstance().newLabel();
    }
}
