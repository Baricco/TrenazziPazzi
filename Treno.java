

public class Treno {
    
    private char tipo;
    private boolean arrivato = false, partito = false;
    private int capienza = 0;
    public static final int MAX_POSTI = 150, TEMP_ARRIVO = 20000;
    public Treno(char tipo)
    {
        capienza = 0;
        arrivato = false; partito = false;
        this.tipo = tipo;
        arrivaInStazione();
    }

    private void arrivaInStazione()
    {
        arrivato = true;
        partito = false;
        new Partenza(TEMP_ARRIVO).start();
    }

    public char getTipo()
    {
        return tipo;
    }
    public boolean isPieno()
    {
        if(capienza < MAX_POSTI)
            return false;
        return true;
    }

    public void aumentaPostiOccupati()
    {
        capienza++;
        
    }

    public int getCapienza()
    {
        return capienza;
    }

    public void cambiaTreno(char tipo)
    {
        arrivato = false; 
        partito = false;
        capienza = 0;
        this.tipo = tipo;
        arrivaInStazione();
    }

    public boolean isArrivato() {
        return arrivato;
    }

    public boolean isPartito() {
        return partito;
    }

    private class Partenza extends Thread
    {
        private int millis = 0;

        public Partenza(int millis)
        {
            this.millis = millis;
        }
        @Override
        public void run()
        {
            System.out.println("treno: " + tipo + " arrivato");
            try {
                Thread.sleep(millis);
            } catch (InterruptedException e) {}
            partito = true;
            System.out.println("treno: " + tipo + " partito");
        }


    }

    
}
