package controller;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuItem;
import javafx.scene.image.ImageView;


import javafx.event.ActionEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.awt.*;
import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML private VBox app;
    @FXML private Canvas canvas;
    @FXML private StackPane stac;

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
    private void open(ActionEvent event)
    {

        Stage stage = (Stage) app.getScene().getWindow();

        final FileChooser fileChooser = new FileChooser();
        File file = fileChooser.showOpenDialog(stage);
        ImageView image = new ImageView(file.toURI().toString());
        image.fitWidthProperty().bind(stac.widthProperty());
        stac.getChildren().add(image);
    }
}
