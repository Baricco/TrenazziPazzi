import java.net.URL;
import java.util.Random;
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
    private SalaAttesa sa = new SalaAttesa();
    
    @FXML
    void initialize() {
        GestoreTreni gs = new GestoreTreni(treno, PANE_trenoB, PANE_trenoA);
        GestorePersone sp = new GestorePersone(sa);
        GestoreController gc = new GestoreController();
        gs.start();
        sp.start();
        gc.start();

    }
    
    public class GestoreController extends Thread
    {
        @Override
        public void run()
        {
            while(true)
            {

                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) { }

                    if (ModificaLSTV.modifica)
                    {
                        switch(ModificaLSTV.p.getColore())
                        {
                            case "rosso":
                                LSTV_perTrenoA.getItems().add(ModificaLSTV.p.getId());
                                break;
                            case "verde":
                                LSTV_perTrenoAB.getItems().add(ModificaLSTV.p.getId());
                                break;
                            case "blu":
                                LSTV_perTrenoB.getItems().add(ModificaLSTV.p.getId());
                                break;
                                
                        }

                        ModificaLSTV.cambiaModifica(false);
                    }

            }
        }
    }      
        
}



    
   

        

