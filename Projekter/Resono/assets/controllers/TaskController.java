package assets.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

public class TaskController {
    @FXML
    private VBox sideBarPoppedOut;

    @FXML
    private Button popInSidepaneBtn;

    @FXML
    private Button popOutSidepaneBtn;

    @FXML
    private WebView taskVideoEmbed;
    private WebEngine engine;

    public void initialize() {
        toggleSidepane(false, false, true);
        loadVideo(taskVideoEmbed, engine, "https://www.youtube.com/embed/tzoARMwZ2Vs?autoplay=1");
    }

    //Collapses the sidebar.
    public void onPopInSidepaneBtn() {
        toggleSidepane(false, false, true);
    }

    //Drops the sidebar down.
    public void onPopOutSidepaneBtn() {
        toggleSidepane(true, true, false);
    }

    private void loadVideo(WebView embed, WebEngine engine, String URL) {
        engine = embed.getEngine();
        engine.load(URL);
    }
    
    //Service method to toggle the sidebar.
    private void toggleSidepane(boolean sideBarPoppedOut, boolean popInSidepaneBtn, boolean popOutSidepaneBtn) {
        this.sideBarPoppedOut.setVisible(sideBarPoppedOut);
        this.popInSidepaneBtn.setVisible(popInSidepaneBtn);
        this.popOutSidepaneBtn.setVisible(popOutSidepaneBtn);
    }
}
