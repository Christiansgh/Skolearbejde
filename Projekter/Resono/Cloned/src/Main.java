package src;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
/*
 * TODO:
 * Fix imageview in RootLayout.FXML
 *      - Hereunder each scene.
 *      - alternativt kan det måske embeddes med CSS?
 * Change the app icon.Users
 * Insert Ulrikkes Vector Logo on the login page, and sort the anchorpane anchors out, 
 * so that it's in the middle, and have a decent size.
 */
public class Main extends Application {
   public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        //Change the name of the app
        stage.setTitle("Resono");

        //Set the icon of the app
        stage.getIcons().add(new Image("/assets/images/ResonoLogo.png"));

        //setScene(stage, "Test.fxml");
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/assets/Scenes/Student/HomeScene/home.FXML"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    } 
}