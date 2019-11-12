package controller;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;


import java.net.URL;
import java.util.ResourceBundle;

import javafx.scene.paint.Color;
import model.Label;
public class LabelPanelController implements Initializable {
   Label label;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        label= new Label("label",Color.GAINSBORO);

    }

    public LabelPanelController() {

    }

    public void Test(ActionEvent actionEvent) {
        System.out.println("clicked");
    }
}
