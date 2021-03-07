import javafx.application.Platform;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.*;

public class GestoreTreni extends Thread {
    private Treno treno;
    private Pane trenoB, trenoA;
    private int aNumber=0, bNumber=0;

    public GestoreTreni(Treno treno, Pane trenoB, Pane trenoA)
    {
        this.treno = treno;
        this.trenoB = trenoB;
        this.trenoA = trenoA;
    }



    @Override
    public void run() {
        while(true)
        {
        Platform.runLater(new Runnable() {
        
            @Override
		    public void run() {
                
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e1) {}

                    if(treno.isPartito())
                    
                        if(treno.getTipo() == 'a' )
                        {
                            try {
                                fxmlController.seriesA.getData().add(new XYChart.Data<String, Number>("A" + aNumber, treno.getCapienza()));
                                aNumber++;
                            } catch (Exception e1) {System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");}
                        
                            trenoA.setStyle("-fx-background-color: green;");
                            trenoB.setStyle("-fx-background-color: black;");
                            treno.cambiaTreno('b');
                        }
                        else if(treno.getTipo() == 'b')
                        {
                            try {
                                fxmlController.seriesA.getData().add(new XYChart.Data<String, Number>("B" + bNumber, treno.getCapienza()));
                                bNumber++;
                        } catch (Exception e1) {System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");}
                            trenoA.setStyle("-fx-background-color: black;");
                            trenoB.setStyle("-fx-background-color: green;");
                            treno.cambiaTreno('a');
                        }

                    
                
            }
        });
        }


    }

    public Treno getTreno()
    {
        return treno;
    }
}