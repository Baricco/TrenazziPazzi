public class ModificaLSTV {

    public static void aggiungiPersona(Persona p)
    {
        switch(p.getColore())
        {
            case "rosso":
                fxmlController.OBSL_trenoA.add(p.getId());
                break;
            case "verde":
                fxmlController.OBSL_trenoAB.add(p.getId());
                break;
            case "blu":
                fxmlController.OBSL_trenoB.add(p.getId());
                break;
                
        }

        
    }

    public static void rimuoviPersona(String colore1)
    {
        switch(colore1)
        {
            case "rosso":
                fxmlController.OBSL_trenoA.remove(0);
                break;
            case "verde":
                fxmlController.OBSL_trenoAB.remove(0);
                break;
            case "blu":
                fxmlController.OBSL_trenoB.remove(0);
                break;
                
        }
    }

}
