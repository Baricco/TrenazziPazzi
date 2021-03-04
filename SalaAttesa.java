import java.util.LinkedList;
import java.util.Queue;

public class SalaAttesa {
    
    private Queue<Persona> codaBlu = new LinkedList<Persona>(),
                           codaRossa = new LinkedList<Persona>(),
                           codaVerde = new LinkedList<Persona>();
    public SalaAttesa() {}

    public void aggiungiPersona(String colore)
    {
        switch(colore)
        {
            case "rosso":
                codaRossa.add(new Persona(colore));
                break;
            case "verde":
                codaVerde.add(new Persona(colore));
                break;
            case "blu":
                codaBlu.add(new Persona(colore));
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
