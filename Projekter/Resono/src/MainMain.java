package src;

import assets.controllers.SceneController;
import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/*
 * TODO:
 * button hover => scale.
 * 
 * popout sidebar = pane.setVisible(false);
 * 
 * Improvement opportunities:
 *  - Make the notification Stackpanes not be based on a set amount, but flexible, and with a scrollbar.
 * 
 * Add queries to check if theres unread notifications.
 *  - if there is, add a red circle to the bell icon.
 * 
 * Fix the stage not being null for some reason?
 * - Use singleton pattern for the scenecontroller then use its methods inside the individual controllers.
 */
public class MainMain extends Application {
    public static Stage stage;
    public static SceneController sceneController;
    
   public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        MainMain.stage = stage;
    
        //Change the name of the app
        stage.setTitle("Resono");

        //Set the icon of the app
        stage.getIcons().add(new Image("/assets/images/ResonoLogo.png"));

        //load the Scene
        SceneController.changeScene(stage, "/assets/fxml/home.fxml");
    }
}