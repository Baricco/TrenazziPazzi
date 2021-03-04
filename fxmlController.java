import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.control.ListView;
import javafx.scene.layout.Pane;

public class fxmlController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Pane PANE_trenoB;

    @FXML
    private Pane PANE_trenoA;

    @FXML
    private ListView<Integer> LSTV_perTrenoA;

    @FXML
    private ListView<Integer> LSTV_perTrenoAB;

    @FXML
    private ListView<Integer> LSTV_perTrenoB;

    @FXML
    private BarChart<?, ?> GRAPH_grafico;

    @FXML
    private CategoryAxis GRAPHY_asseY;

    @FXML
    private NumberAxis GRAPHX_asseX;

    @FXML
    void initialize() {
        assert PANE_trenoB != null : "fx:id=\"PANE_trenoB\" was not injected: check your FXML file 'fxml.fxml'.";
        assert PANE_trenoA != null : "fx:id=\"PANE_trenoA\" was not injected: check your FXML file 'fxml.fxml'.";
        assert LSTV_perTrenoA != null : "fx:id=\"LSTV_perTrenoA\" was not injected: check your FXML file 'fxml.fxml'.";
        assert LSTV_perTrenoAB != null : "fx:id=\"LSTV_perTrenoAB\" was not injected: check your FXML file 'fxml.fxml'.";
        assert LSTV_perTrenoB != null : "fx:id=\"LSTV_perTrenoB\" was not injected: check your FXML file 'fxml.fxml'.";
        assert GRAPH_grafico != null : "fx:id=\"GRAPH_grafico\" was not injected: check your FXML file 'fxml.fxml'.";
        assert GRAPHY_asseY != null : "fx:id=\"GRAPHY_asseY\" was not injected: check your FXML file 'fxml.fxml'.";
        assert GRAPHX_asseX != null : "fx:id=\"GRAPHX_asseX\" was not injected: check your FXML file 'fxml.fxml'.";

    }
}
