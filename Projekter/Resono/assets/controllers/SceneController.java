package assets.controllers;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class SceneController {
    private static Stage scStage;

    //singleton pattern to ensure that theres only 1 instance of the scene being loaded.
    //also provides global access to the instance through the getInstance().
    private static SceneController instance;

    //singleton constructor
    private SceneController(){} 

    //calls the constructor if theres not an instance of the scenecontroller.
    public static SceneController getInstance(){
        if(instance == null) {
            scStage = new Stage();
            instance = new SceneController();
        }
        return instance;
    }

    public void changeScene(String fxmlFilePath) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/assets/fxml/task.fxml"));
            Scene scene = new Scene(root);
            scStage.setScene(scene);
            scStage.show();
            System.out.println(root);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
     
}

