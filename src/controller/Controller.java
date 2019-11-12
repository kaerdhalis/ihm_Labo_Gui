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
import javafx.scene.shape.Rectangle;



import javafx.event.ActionEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.awt.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML private Pane imagePane;
    @FXML private ImageView imageView;
    @FXML private ColorPicker colorPicker;

    private Rectangle rectangle;
    private double originX;
    private double originY;
    private boolean imageLoaded= false;

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
        fileChooser.setTitle("Open Resource File");
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
            originX = mouseEvent.getX();
            originY = mouseEvent.getY();
            rectangle = new Rectangle();
            rectangle.setX(mouseEvent.getX());
            rectangle.setY(mouseEvent.getY());
            rectangle.setFill(null);
            rectangle.setStroke(colorPicker.getValue());

            imagePane.getChildren().addAll(rectangle);
        }
    }

    public void onMouseDragged(MouseEvent mouseEvent) {

        if(imageLoaded) {
            rectangle.setWidth(Math.abs(mouseEvent.getX() >= imageView.getFitWidth() ? imageView.getFitWidth() - originX : mouseEvent.getX() - originX));
            rectangle.setHeight(Math.abs(mouseEvent.getY() >= imageView.getFitHeight() ? imageView.getFitHeight() - originY : mouseEvent.getY() - originY));
            rectangle.setX(Math.min(originX, mouseEvent.getX() >= 0 ? mouseEvent.getX() : 0));
            rectangle.setY(Math.min(originY, mouseEvent.getY() >= 0 ? mouseEvent.getY() : 0));
        }
    }

    public void onMouseReleased(MouseEvent mouseEvent) {

        if (imageLoaded) {


        Label label1 = new Label("Search");
        label1.setTextFill(colorPicker.getValue());
        label1.setLayoutX(Math.min(originX, mouseEvent.getX()));
        label1.setLayoutY(Math.min(originY, mouseEvent.getY()) - 20);
        imagePane.getChildren().add(label1);
    }
    }

    public void onKeyReleased(KeyEvent keyEvent) {

        if(keyEvent.getCode() == KeyCode.D&& imageLoaded){

                imagePane.getChildren().remove(1,imagePane.getChildren().size());


        }

        if(keyEvent.getCode() == KeyCode.Z&&imageLoaded){
            if (imagePane.getChildren().size()>=3)
                imagePane.getChildren().remove(imagePane.getChildren().size()-2,imagePane.getChildren().size());


        }
    }
}
