import java.util.LinkedList;
import java.util.Queue;


public class SalaAttesa {
    
    private Queue<Persona> codaBlu = new LinkedList<Persona>(),
                           codaRossa = new LinkedList<Persona>(),
                           codaVerde = new LinkedList<Persona>();
    
    public SalaAttesa(){}

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
        Persona gianni = new Persona();
        switch(colore)
        {
            case "rosso":
                gianni = codaRossa.poll();
                break;
            case "verde":
                gianni = codaVerde.poll();
                break;
            case "blu":
                gianni = codaBlu.poll();
                break;
        }
        return gianni;

    }


}
