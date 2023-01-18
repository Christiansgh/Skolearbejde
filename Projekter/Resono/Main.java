

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Main extends Application {
    
    @Override
    public void start(Stage window) throws Exception {
        //Create the window
        BorderPane root = new BorderPane();
        Scene scene = new Scene(root, 1920, 1080);
        root.getStylesheets().add("stylesheet.css");

        window.setScene(scene);
        scene.getStylesheets().add("stylesheet.css");

        window.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}