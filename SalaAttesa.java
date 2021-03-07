import java.util.LinkedList;
import java.util.Queue;


public class SalaAttesa {
    
    private Queue<Persona> codaBlu = new LinkedList<Persona>(),
                           codaRossa = new LinkedList<Persona>(),
                           codaVerde = new LinkedList<Persona>();
    private Treno treno;
    public SalaAttesa(Treno treno)
    {
        this.treno = treno;
    }

    public void aggiungiPersona(String colore)
    {
        Persona p = new Persona(colore);
        switch(colore)
        {
            case "rosso":
                codaRossa.add(p);
                ModificaLSTV.aggiungiPersona(p);
                break;
            case "verde":
                codaVerde.add(p);
                ModificaLSTV.aggiungiPersona(p);
                break;
            case "blu":
                codaBlu.add(p);
                ModificaLSTV.aggiungiPersona(p);
                break;
                
        }
            

    }

    public Persona prelevaPersona(String colore)
    {
        Persona p = new Persona();
        switch(colore)
        {
            case "rosso":
                p = codaRossa.poll();
                ModificaLSTV.rimuoviPersona(colore);
                break;
            case "verde":
                    p = codaVerde.poll();
                ModificaLSTV.rimuoviPersona(colore);
                break;
            case "blu":
                p = codaBlu.poll();
                ModificaLSTV.rimuoviPersona(colore);
                break;
        }
        return p;

    }

    public Treno getTreno()
    {
        return treno;
    }

    public Queue<Persona> getCodaBlu() {
        return codaBlu;
    }


    public Queue<Persona> getCodaRossa() {
        return codaRossa;
    }


    public Queue<Persona> getCodaVerde() {
        return codaVerde;
    }

    
}


