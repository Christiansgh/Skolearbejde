package src;

import assets.controllers.SceneController;
import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/*
 * TODO:
 * button hover => change background color?
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
 * 
 * Add pseudoclasses to css, to improve imersion. Hover, focus etc.
 * 
 * use the login controller to set the invalid login to visible, and hide welcome.
 * 
 * maybe setup some buttons to control the video. Allowing for pausing, replay, playback speed, quality etc.
 * - this probably requires javascript, and might be out of the scope.
 * 
 * Swap the rounded off textfields w/ stackpanes --> rectangle(arcWidth + arcHeight for rounded corners + stroke) --> textfields on top
 * 
 * Figure out how to fit the application to the screensize on launch.
 * 
 * TextFields allow input. This is not good. Make stackpane --> shape --> Label
 * 
 * Make SVG path drawing arrows for dropdown menu
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
        SceneController.changeScene(stage, "/assets/fxml/task.fxml");
    }
}