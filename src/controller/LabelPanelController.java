package controller;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;


import java.net.URL;
import java.util.ResourceBundle;

import javafx.scene.control.ColorPicker;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import model.Label;
public class LabelPanelController implements Initializable {
    ColorPicker colorPicker;
    Text text;
    private Label label;
    private AnchorPane myRoot;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        System.out.println(location);
    }

    public void setMyRoot(AnchorPane myRoot) {
        this.myRoot = myRoot;
        Text text= (Text) myRoot.lookup("#labelText");
        text.setText(label.getName());
    }

    public void setLabel(Label label) {
        this.label = label;
    }

    public LabelPanelController() {

    }

    public void Test(ActionEvent actionEvent) {
        System.out.println("clicked");
    }
}
