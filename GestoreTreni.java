import javafx.scene.layout.*;

public class GestoreTreni extends Thread {
    private Treno treno;
    private Pane trenoB, trenoA;

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
            try {
                Thread.sleep(10);
            } catch (InterruptedException e1) {}
            if(treno.isPartito())
                if(treno.getTipo() == 'a' )
                {
                    trenoA.setStyle("-fx-background-color: green;");
                    trenoB.setStyle("-fx-background-color: black;");
                    treno.cambiaTreno('b');
                }
                else if(treno.getTipo() == 'b')
                {
                    trenoA.setStyle("-fx-background-color: black;");
                    trenoB.setStyle("-fx-background-color: green;");
                    treno.cambiaTreno('a');
                }

            
        }
        


    }

    public Treno getTreno()
    {
        return treno;
    }
}