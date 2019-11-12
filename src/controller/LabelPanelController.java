package controller;

import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
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

    }

    public void setMyRoot(AnchorPane myRoot) {
        this.myRoot = myRoot;
        text= (TextField) myRoot.lookup("#labelText");
        text.focusedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue ov, Boolean t, Boolean t1) {

                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        if (text.isFocused() && !text.getText().isEmpty()) {
                            text.selectAll();
                        }
                    }
                });
            }


        });


        text.textProperty().addListener((observable, oldValue, newValue) -> {
            label.setName(newValue);
        });
        text.requestFocus();
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
