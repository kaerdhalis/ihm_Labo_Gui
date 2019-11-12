import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

import java.io.IOException;
import java.util.ArrayList;

public class LabelListController {
    private AnchorPane listRoot;
    private ArrayList<Label> labels;
    private ArrayList<AnchorPane> labelPanels;
    private AnchorPane addingPanel;
    public LabelListController(AnchorPane listRoot) {
        this.listRoot = listRoot;

        addingPanel= (AnchorPane) listRoot.lookup("#newLabelPanel");
        labels= new ArrayList<>();
        labelPanels=new ArrayList<>();
    }
    public void add(Label l) throws IOException {
        AnchorPane newLabelPanel= FXMLLoader.load(getClass().getResource("view/LabelPanel.fxml"));
        double topAnchor= 0;
        for (AnchorPane a:labelPanels ) {
            topAnchor+=74;
        }
        Text text= (Text) newLabelPanel.lookup("#labelText");
        text.setText(l.getName());
        AnchorPane.setTopAnchor(newLabelPanel,topAnchor);

        listRoot.getChildren().add(newLabelPanel);
        topAnchor+= 74;
        AnchorPane.setTopAnchor(addingPanel,topAnchor);
        labels.add(l);
        labelPanels.add(newLabelPanel);
    }
}
