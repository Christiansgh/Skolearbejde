import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
	
	@Override
	public void start(Stage stage) throws IOException {
		
		FXMLLoader loader = new FXMLLoader(getClass().getResource("Scene.fxml"));
		Parent root = loader.load();	
		Controller controller = loader.getController();
		Scene scene = new Scene(root);		
		
		//stage.getIcons().add(new Image("icon.png"));
		//stage.setTitle("Bro web browser");
		stage.setScene(scene);
		stage.show();
	}	

	public static void main(String[] args) {
		
		launch(args);
	}
}