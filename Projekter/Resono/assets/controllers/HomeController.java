package assets.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import src.MainMain;

public class HomeController implements Initializable {
    @FXML
    private WebView embed1, embed2, embed3, embed4;

    private WebEngine engine;

    @FXML
    private AnchorPane assigment1, assignment2, assignment3, assignment4;

    @FXML
    private Label label1, label2, label3, label4;

    @FXML
    private TextField textField1, textField2, textField3, textField4;

    @FXML
    private AnchorPane anchorPane4;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        loadVideo(embed1, "https://www.youtube.com/embed/-1kj837fWpo");
        loadVideo(embed2, "https://www.youtube.com/embed/ZXsQAXx_ao0");
        loadVideo(embed3, "https://www.youtube.com/embed/tzoARMwZ2Vs");
        loadVideo(embed4, "https://www.youtube.com/embed/IfFIY1-eXpM");
    }

    public void onAssignment1Clicked() {
        System.out.println("Clicked assignment");
        TaskController.setVideoURL("https://www.youtube.com/embed/-1kj837fWpo");
        SceneController.changeScene(MainMain.stage, "/assets/fxml/task.fxml");
    }

    public void onAssignment2Clicked() {
        System.out.println("Clicked assignment");
        TaskController.setVideoURL("https://www.youtube.com/embed/ZXsQAXx_ao0");
        SceneController.changeScene(MainMain.stage, "/assets/fxml/task.fxml");
    }

    public void onAssignment3Clicked() {
        System.out.println("Clicked assignment");
        TaskController.setVideoURL("https://www.youtube.com/embed/tzoARMwZ2Vs");
        SceneController.changeScene(MainMain.stage, "/assets/fxml/task.fxml");
    }

    public void onAssignment4Clicked() {
        System.out.println("Clicked assignment");
        TaskController.setVideoURL("https://www.youtube.com/embed/IfFIY1-eXpM");
        SceneController.changeScene(MainMain.stage, "/assets/fxml/task.fxml");
    }

    //Service method to load videos
    private void loadVideo(WebView embed, String URL) {
        engine = embed.getEngine();
        engine.load(URL);
    }
}
