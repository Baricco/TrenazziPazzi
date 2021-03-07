import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.ListView;

import javafx.scene.control.ProgressIndicator;
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
    private ListView<String> LSTV_perTrenoA;
    public static ObservableList<String> OBSL_trenoA = FXCollections.observableArrayList();
    
    
    @FXML
    private ListView<String> LSTV_perTrenoAB;
    public static ObservableList<String> OBSL_trenoAB = FXCollections.observableArrayList();

    @FXML
    private ListView<String> LSTV_perTrenoB;
    public static ObservableList<String> OBSL_trenoB = FXCollections.observableArrayList();

    @FXML
    private BarChart<String, Number> GRAPH_grafico;

    @FXML
    private CategoryAxis GRAPHY_asseY;

    @FXML
    private ProgressIndicator PB_progressBar;

    @FXML
    private NumberAxis GRAPHX_asseX;


    private Treno treno = new Treno('a');
    private SalaAttesa sa = new SalaAttesa(treno);
    public static XYChart.Series<String, Number> seriesA = new XYChart.Series<String, Number>();
    public static XYChart.Series<String, Number> seriesB = new XYChart.Series<String, Number>();
    
    @FXML
    void initialize() {
        LSTV_perTrenoA.setItems(OBSL_trenoA);
        LSTV_perTrenoAB.setItems(OBSL_trenoAB);
        LSTV_perTrenoB.setItems(OBSL_trenoB);

        GestoreTreni gs = new GestoreTreni(treno, PANE_trenoB, PANE_trenoA);
        GestorePersone sp = new GestorePersone(sa);
        GestoreController gc = new GestoreController();

        gs.start();
        sp.start();
        gc.start();

        GRAPH_grafico.getData().addAll(seriesA, seriesB);

        
    }


    private void aggiornaLabel()
    {
        PB_progressBar.setProgress( (double)treno.getCapienza()/Treno.MAX_POSTI);
    }
    
    public class GestoreController extends Thread
    {
        @Override
        public void run()
        {
            while(true)
            {  
                aggiornaLabel();
                try {
                    Thread.sleep(10);
                } catch (Exception e) { }

            }
        }
    }      
        
}



    
   

        

