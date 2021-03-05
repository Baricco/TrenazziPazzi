import javafx.scene.layout.*;

public class GestoreTreni extends Thread {
    private String treno;
    private Pane trenoB, trenoA;

    public GestoreTreni(String treno, Pane trenoB, Pane trenoA)
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
                Thread.sleep(10000);
            } catch (Exception e) {}
    
            if(treno.equals("a"))
            {
                trenoA.setStyle("-fx-background-color: green;");
                trenoB.setStyle("-fx-background-color: black;");
                treno = "b";
            }
            else if(treno.equals("b"))
            {
                trenoA.setStyle("-fx-background-color: black;");
                trenoB.setStyle("-fx-background-color: green;");
                treno = "a";
            }
        }
        


    }
}