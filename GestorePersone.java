import java.util.Random;

import javafx.scene.control.ListView;

public class GestorePersone extends Thread {
        
    private Random rnd = new Random();
    private int second = 0;
    private String color[] = {"rosso", "blu", "verde"};
    SalaAttesa sa;

    public GestorePersone(SalaAttesa sa)
    {
        this.sa = sa;
    }

    @Override
    public void run() {
        while(true)
        {
            if(!ModificaLSTV.modifica)
            {
                second = rnd.nextInt(9) + 1;
                try {
                    Thread.sleep(second*1000);
                } catch (Exception e) {}
        
                sa.aggiungiPersona(color[rnd.nextInt(3)]);
            }
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) { }
        }
        


    }
}