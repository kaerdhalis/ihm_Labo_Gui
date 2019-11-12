package controller;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import model.Label;

import javax.swing.text.LabelView;
import java.io.IOException;
import java.util.ArrayList;

public class LabelListController {
    private static  LabelListController instance;
    public static LabelListController getInstance(){
        if(instance==null){
            instance =new LabelListController();
            return instance;
        }else{
            return instance;
        }
    }
    private AnchorPane listRoot;
    private ArrayList<Label> labels;
    private ArrayList<AnchorPane> labelPanels;
    private AnchorPane addingPanel;

    private Label currentLabel;
    private LabelListController() {

        labels= new ArrayList<>();
        labelPanels=new ArrayList<>();
    }
    public void hookTo(AnchorPane listRoot){
        this.listRoot = listRoot;

        addingPanel= (AnchorPane) listRoot.lookup("#newLabelPanel");
    }



    public void newLabel() throws IOException {
        LabelPanelController controller= new LabelPanelController();
        FXMLLoader loader= new FXMLLoader(getClass().getResource("../view/LabelPanel.fxml"));
        loader.setController(controller);
        Label newLabel=new Label("label "+ (labels.size()+1), Color.HONEYDEW);
        labels.add(newLabel);
        controller.setLabel(newLabel);
        AnchorPane newLabelPanel=loader.load();
        controller.setMyRoot(newLabelPanel);

        double topAnchor= 0;
        for (AnchorPane a:labelPanels ) {
            topAnchor+=74;
        }

       // Text text= (Text) newLabelPanel.lookup("#labelText");
       // text.setText("label");
        AnchorPane.setTopAnchor(newLabelPanel,topAnchor);

        listRoot.getChildren().add(newLabelPanel);
        topAnchor+= 74;
        AnchorPane.setTopAnchor(addingPanel,topAnchor);

        labelPanels.add(newLabelPanel);
    }


    public Label getCurrentLabel() {
        return currentLabel;
    }

    public void setCurrentLabel(Label currentLabel) {

        this.currentLabel = currentLabel;
    }
}
