public class main {
    
    public static void main(String args[])
    {
        SalaAttesa salaAttesa = new SalaAttesa();

        for(int i = 0;i<10;i++)
            salaAttesa.aggiungiPersona("rosso");
        for(int i = 0;i<10;i++)
            salaAttesa.aggiungiPersona("verde");

        System.out.println(salaAttesa.prelevaPersona("rosso").getColore());
    }
}
