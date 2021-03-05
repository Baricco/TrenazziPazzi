public class ModificaLSTV {

    public static Persona p ;
    public static boolean modifica;

    public static void aggiungiPersona(Persona p1)
    {
        p = p1;
        ModificaLSTV.cambiaModifica(true);
    }

    public synchronized static void cambiaModifica(boolean b)
    {
        modifica = b;
    }
}
