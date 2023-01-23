package assets.controllers;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class SceneController {
    public static void changeScene(Stage stage, String fxmlFilePath) {
        try {
            Parent root = FXMLLoader.load(SceneController.class.getResource(fxmlFilePath));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
            System.out.println(root);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
