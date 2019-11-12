package controller;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;


import java.net.URL;
import java.util.ResourceBundle;

import javafx.scene.control.ColorPicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import model.Label;
public class LabelPanelController implements Initializable {
    ColorPicker colorPicker;
    TextField text;
    private Label label;
    private AnchorPane myRoot;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        System.out.println(location);
    }

    public void setMyRoot(AnchorPane myRoot) {
        this.myRoot = myRoot;
        text= (TextField) myRoot.lookup("#labelText");
        text.setText(label.getName());
        text.textProperty().addListener((observable, oldValue, newValue) -> {
            label.setName(newValue);
        });

        colorPicker= (ColorPicker) myRoot.lookup("#colorPicker");
        colorPicker.setValue(label.getColor());
    }

    public void setLabel(Label label) {
        this.label = label;
    }

    public LabelPanelController() {

    }

    public void NewAnnotation(ActionEvent actionEvent) {

        LabelListController.getInstance().setCurrentLabel(label);
    }

    public  void changeColor(ActionEvent actionEvent){
        label.setColor(colorPicker.getValue());
    }
    public  void updateText(ActionEvent actionEvent){
        label.setName(text.getText());
    }
}
