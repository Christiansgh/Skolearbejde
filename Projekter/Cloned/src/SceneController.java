package src;
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class SceneController {
    private Stage stage;
    private Scene scene;
    private Parent root;

    public void switchToSceneLogin(ActionEvent event) {
        
    }
    /* 
    //Service Method
    private void switchToScene(String scenePath) throws IOException {
        Parent root = new FXMLLoader(getClass().getResource(scenePath));
        stage = (Stage)((Node)event.getSource().getScene.getWindow());
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        
    }*/
}
