import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ProgressBar;
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
    private ProgressBar PB_progressBar;

    @FXML
    private NumberAxis GRAPHX_asseX;


    private Treno treno = new Treno('a');
    private SalaAttesa sa = new SalaAttesa(treno);
    
    @FXML
    void initialize() {
        GestoreTreni gs = new GestoreTreni(treno, PANE_trenoB, PANE_trenoA);
        GestorePersone sp = new GestorePersone(sa);
        GestoreController gc = new GestoreController();
        gs.start();
        sp.start();
        gc.start();
        PB_progressBar.setProgress( 3);
    }


    private void aggiornaLabel()
    {
        PB_progressBar.setProgress( treno.getCapienza()/Treno.MAX_POSTI);
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
                    
                        if (ModificaLSTV.modifica == 'a')
                        {
                            try{
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
                            }catch(Exception e){}

                            ModificaLSTV.cambiaModifica('n');
                        }

                        if (ModificaLSTV.modifica == 'r')
                        {
                            switch(ModificaLSTV.getColore())
                            {
                                case "rosso":
                                    LSTV_perTrenoA.getItems().remove(0);
                                    break;
                                case "verde":
                                    LSTV_perTrenoAB.getItems().remove(0);
                                    break;
                                case "blu":
                                    LSTV_perTrenoB.getItems().remove(0);
                                    break;
                                    
                            }

                            ModificaLSTV.cambiaModifica('n');
                        }
                } catch (Exception e) { }

            }
        }
    }      
        
}



    
   

        

