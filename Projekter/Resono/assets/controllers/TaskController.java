package assets.controllers;

import javafx.fxml.FXML;
import javafx.scene.layout.VBox;
import javafx.scene.layout.AnchorPane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

public class TaskController {
    private static String url; // Video url if any
    private boolean showSidebar = false;

    @FXML
    private AnchorPane popInSidepane, popOutSidepane;

    @FXML
    private VBox sideBarPoppedOut;

    @FXML
    private WebView taskVideoEmbed;
    private WebEngine engine;

    public void initialize() {
        toggleSidepane();
        
        engine = taskVideoEmbed.getEngine();
        engine.load(url);
    }

    public void toggleSidepane() {
        showSidebar = !showSidebar;
        this.popInSidepane.setVisible(showSidebar);
        this.sideBarPoppedOut.setVisible(showSidebar);
        this.popOutSidepane.setVisible(!showSidebar);
    }

    public static void setVideoURL(String videoURL) {
        url = videoURL;
    }
}
