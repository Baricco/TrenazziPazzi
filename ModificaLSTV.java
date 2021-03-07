import javafx.application.Platform;

public class ModificaLSTV {

    public static void aggiungiPersona(Persona p)
    {
        Platform.runLater(new Runnable() {

            @Override
		    public void run() {
                switch(p.getColore())
                {
                    case "rosso":
                        fxmlController.OBSL_trenoA.add(String.valueOf(p.getId()));
                        break;
                    case "verde":
                        fxmlController.OBSL_trenoAB.add(String.valueOf(p.getId()));
                        break;
                    case "blu":
                        fxmlController.OBSL_trenoB.add(String.valueOf(p.getId()));
                        break;
                        
                }
            }
        });

        
    }

    public static void rimuoviPersona(String colore1)
    {
        Platform.runLater(new Runnable() {

            @Override
		    public void run() {
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
        });
    }

}
