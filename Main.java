

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.Pane;
import javafx.application.Application;


public class Main extends Application {

	@Override
	public void start (Stage stage) throws Exception {

		Pane root = FXMLLoader.load(getClass().getResource("fxml.fxml"));
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
		
	}



	public static void main ( String [] args ) { 
		launch(args); 
	}
		
}