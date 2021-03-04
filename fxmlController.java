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

    private String treno = "a";

    @FXML
    void initialize() {
        GestoreTreni gs = new GestoreTreni(treno);

        gs.start();

    }
    
    private class GestoreTreni extends Thread {
            private String treno;
        
            public GestoreTreni(String treno)
            {
                this.treno = treno;
            }
        
            @Override
            public void run() {
                while(true)
                {
                    try {
                        Thread.sleep(1000);
                    } catch (Exception e) {}
            
                    if(treno.equals("a"))
                    {
                        PANE_trenoA.setStyle("-fx-background-color: green;");
                        PANE_trenoB.setStyle("-fx-background-color: black;");
                        treno = "b";
                    }
                    else if(treno.equals("b"))
                    {
                        PANE_trenoA.setStyle("-fx-background-color: black;");
                        PANE_trenoB.setStyle("-fx-background-color: green;");
                        treno = "a";
                    }
                }
                
        
        
            }
        }
}
