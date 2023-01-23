package assets.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

public class HomeController implements Initializable {
    @FXML
    private WebView embed1, embed2, embed3, embed4;

    private WebEngine engine1, engine2, engine3, engine4;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        executeJS(embed1, engine1);
        executeJS(embed2, engine2);
        executeJS(embed3, engine3);
        executeJS(embed4, engine4);
    }

    public void executeJS(WebView embed, WebEngine engine) {
        engine = embed.getEngine();
        engine.executeScript("window.location = \"https://www.youtube.com/watch?v=96r3olimdkA&ab_channel=BroCode\";");
    }
}
