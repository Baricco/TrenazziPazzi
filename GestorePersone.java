import java.util.Random;


public class GestorePersone extends Thread {
        
    private Random rnd = new Random();
    private int second = 0, R_int;

    private String color[] = {"rosso", "blu", "verde"};
    private SalaAttesa sa;

    public GestorePersone(SalaAttesa sa)
    {
        this.sa = sa;
    }

    @Override
    public void run() {
        new GestioneSalitePersone().start();
        while(true)
        {
            if(ModificaLSTV.modifica == 'n')
            {
                second = rnd.nextInt(3) + 1;
                try {
                    Thread.sleep(second*1000);
                } catch (Exception e) {}

                applicaRandom();
            }
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) { }
        }
        
        

    }

    private void applicaRandom()
    {
        R_int = rnd.nextInt(1000);

        if(R_int >= 600)
            sa.aggiungiPersona(color[1]);
        else if(R_int >= 300)
            sa.aggiungiPersona(color[0]);
        else
            sa.aggiungiPersona(color[2]);
    }
    private class GestioneSalitePersone extends Thread
    {
        @Override
        public void run()
        {
            try {
                Thread.sleep(20000);
            } catch (InterruptedException e1) {}

            while(true)
            {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e1) {}
                
                if(sa.getTreno().isArrivato() && !sa.getTreno().isPieno())
                {
                    try
                    {
                        if(sa.getTreno().getTipo() == 'a')
                        {
                            if(!(sa.getCodaRossa().size() > 0)) sa.prelevaPersona("verde");
                            else if(!(sa.getCodaVerde().size() > 0)) sa.prelevaPersona("rosso");

                            else if(sa.getCodaRossa().peek().getId() < sa.getCodaVerde().peek().getId())
                                sa.prelevaPersona("rosso");
                            else sa.prelevaPersona("verde");   
                            sa.getTreno().aumentaPostiOccupati();                         
                            
                        }

                        else if(sa.getTreno().getTipo() == 'b')
                        {
                            if(!(sa.getCodaBlu().size() > 0)) sa.prelevaPersona("verde");

                            else if(!(sa.getCodaVerde().size() > 0)) sa.prelevaPersona("blu");
                            else if(sa.getCodaBlu().peek().getId() < sa.getCodaVerde().peek().getId()) 
                            sa.prelevaPersona("blu");
                            else sa.prelevaPersona("verde");    
                            sa.getTreno().aumentaPostiOccupati();                       
                            
                        }                                 
                        
                        
                    }catch(Exception e){}
                }
            }
        }
    }
}