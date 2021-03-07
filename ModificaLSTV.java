public class ModificaLSTV {

    public static Persona p ;
    public static String colore;
    public static char modifica = 'n';

    public static void aggiungiPersona(Persona p1)
    {
        p = p1;
        ModificaLSTV.cambiaModifica('a');
    }

    public static void rimuoviPersona(String colore1)
    {
        colore = colore1;
        ModificaLSTV.cambiaModifica('r');
    }

    public synchronized static void cambiaModifica(char b)
    {
        modifica = b;
    }

    public static String getColore()
    {
        return colore;
    }
}
