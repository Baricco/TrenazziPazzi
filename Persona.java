
public class Persona
{
    private String colore;
    private int id;

    private static int generalID = 0;

    public Persona(String colore)
    {
        this.colore = colore;

        this.id = generalID;
        
        generalID++;
    }

    public Persona(){}

    public String getColore()
    {
        return colore;
    }

    public int getId()
    {
        return id;
    }

}