import controller.Controller;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Main extends Application {
    LabelListController lbc;
    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("view/sample.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 1820, 1080));
        AnchorPane labelListPane= (AnchorPane) root.lookup("#LabelListPane");
        lbc= new LabelListController(labelListPane);
        lbc.add(new Label("test2",new Color(0.3,0.2,0.5,1)));

        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
