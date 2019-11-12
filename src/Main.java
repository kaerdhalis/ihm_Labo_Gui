import controller.LabelListController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import model.Label;

public class Main extends Application {
    LabelListController lbc;

        @Override
        public void start(Stage primaryStage) throws Exception{
            Parent root = FXMLLoader.load(getClass().getResource("view/sample.fxml"));
            primaryStage.setTitle("Image Annotator");
            primaryStage.setScene(new Scene(root, 1820, 1080));
            AnchorPane labelListPane= (AnchorPane) root.lookup("#LabelListPane");

            lbc= LabelListController.getInstance();
            lbc.hookTo(labelListPane);

                primaryStage.show();
        }


    public static void main(String[] args) {
        launch(args);
    }
}
