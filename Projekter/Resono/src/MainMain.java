package src;

import assets.controllers.SceneController;
import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/*
 * TODO:
 * 
 * Improvement opportunities:
 *  - Make the notification Stackpanes not be based on a set amount, but flexible, and with a scrollbar. Listview?
 * 
 * button hover => change background color?
 * - CSS Pseudoclasses
 * Add pseudoclasses to css, to improve imersion. Hover, focus etc.
 * 
 * Add queries to check if theres unread notifications.
 *  - if there is, add a red circle to the bell icon.
 * 
 * Fix the stage not being null for some reason?
 * - Use singleton pattern for the scenecontroller then use its methods inside the individual controllers.
 * 
 * When the teacher controller & FXML is done, set the login controller => changeScene to teacherHome.fxml
 * 
 * add multiline mode for descriptions. https://stackoverflow.com/questions/28093508/javafx-fxml-file-textarea-line-break-and-tab-in-text
 * - If doing this, copy the taskdescription from teams and parse it in.
 * - Also make the login error multi-line.
 * 
 * set the stylesheet in the root node, unless you need to use the style from another sheet.
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

        //set the previous dimensions to the previous ones on scene swaps.
        double prevWidth = stage.getWidth();
        double prevHeight = stage.getHeight();

        //during scene swaps uses previous values
        stage.setWidth(prevWidth);
        stage.setHeight(prevHeight);

        //load the Scene
        SceneController.changeScene(stage, "/assets/fxml/teacher.fxml");
    }
}