import controller.Controller;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("view/sample.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 1820, 1080));
        AnchorPane labelListPane= (AnchorPane) root.lookup("#LabelListPane");
        AnchorPane label1= FXMLLoader.load(getClass().getResource("view/LabelPanel.fxml"));
        labelListPane.getChildren().add(label1);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
