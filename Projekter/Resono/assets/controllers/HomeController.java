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

    private WebEngine engine1, engine2, engine3, engine4;

    @FXML
    private AnchorPane assigment1, assignment2, assignment3, assignment4;

    @FXML
    private Label label4;

    @FXML
    private TextField textField4;

    @FXML
    private AnchorPane anchorPane4;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //loadVideo(embed1, engine1, "https://www.youtube.com/embed/-1kj837fWpo?autoplay=1");
        //loadVideo(embed2, engine2, "https://www.youtube.com/embed/ZXsQAXx_ao0?autoplay=1");
        //loadVideo(embed3, engine3, "https://www.youtube.com/embed/tzoARMwZ2Vs?autoplay=1");
        //loadVideo(embed4, engine4, "https://www.youtube.com/embed/IfFIY1-eXpM?autoplay=1");
    }

    public void onAssignmentClicked() {
        System.out.println("Clicked assignment");
        SceneController.changeScene(MainMain.stage, "/assets/fxml/task.fxml");
    }

    public void setAssigmentFourinvisible() {
        setAssigmentFour(true, true, true, true);
    }

    public void setAssigmentFourVisible() {
        setAssigmentFour(false, false, false, false);
    }

    //Service method to hide Assignment 4, when oppening the notifications.
    private void setAssigmentFour(boolean anchorPane4, boolean textField4, boolean label4, boolean embed4) {
        this.embed4.setVisible(embed4);
        this.label4.setVisible(label4);
        this.textField4.setVisible(textField4);
        this.anchorPane4.setVisible(anchorPane4);
    }

    //Service method to load videos
    private void loadVideo(WebView embed, WebEngine engine, String URL) {
        engine = embed.getEngine();
        engine.load(URL);
    }
}
