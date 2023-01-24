package assets.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.shape.SVGPath;
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
    private SVGPath inUL, inLL, inUR, inLR, outUL, outUR, outLL, outLR;

    @FXML
    private Label inLabel, outLabel;

    @FXML
    private WebView taskVideoEmbed;
    private WebEngine engine;

    public void initialize() {
        toggleSidepaneToIn();
        toggleSVGandTextToIn();
        loadVideo(taskVideoEmbed, engine, "https://www.youtube.com/embed/tzoARMwZ2Vs?autoplay=1");
    }

    //Collapses the sidebar.
    public void onPopInSidepaneBtn() {
        System.out.println("Closing Sidepane");
        toggleSidepaneToIn();
        toggleSVGandTextToIn();
    }

    //Drops the sidebar down.
    public void onPopOutSidepaneBtn() {
        System.out.println("Oppening Sidepane");
        toggleSidepaneToOut();
        toggleSVGandTextToOut();
    }

    private void loadVideo(WebView embed, WebEngine engine, String URL) {
        engine = embed.getEngine();
        engine.load(URL);
    }

    //Service method to toggle the sidepane, based on the other service method "toggleSidepane".
    private void toggleSidepaneToIn() {
        toggleSidepane(false, false, true);
    }

    //Service method to toggle the sidepane, based on the other service method "toggleSidepane".
    private void toggleSidepaneToOut() {
        toggleSidepane(true, true, false);
    }

    //Service method to help toggling SVG arrows and "Episode" label, based on the other service method "toggleSVGandText".
    private void toggleSVGandTextToIn() {
        toggleSVGandText(false, true, false, false, false, false, true, true, true, true);
    }

    //Service method to help toggling SVG arrows and "Episode" label, based on the other service method "toggleSVGandText".
    private void toggleSVGandTextToOut() {
        toggleSVGandText(true, false, true, true, true, true, false, false, false, false);
    }

    //Service method to toggle the sidebar.
    private void toggleSidepane(boolean sideBarPoppedOut, boolean popInSidepaneBtn, boolean popOutSidepaneBtn) {
        this.sideBarPoppedOut.setVisible(sideBarPoppedOut);
        this.popInSidepaneBtn.setVisible(popInSidepaneBtn);
        this.popOutSidepaneBtn.setVisible(popOutSidepaneBtn);
    }

    //Service method to hide all the SVG arrows and the "Episode" label.
    private void toggleSVGandText(boolean inLabel, boolean outLabel, boolean inUL, boolean inUR, boolean inLL, boolean inLR, boolean outUL, boolean outUR, boolean outLL, boolean outLR) {
        this.inLabel.setVisible(inLabel);
        this.outLabel.setVisible(outLabel);
        this.inUL.setVisible(inUL);
        this.inUR.setVisible(inUR);
        this.inLL.setVisible(inLL);
        this.inLR.setVisible(inLR);
        this.outUL.setVisible(outUL);
        this.outUR.setVisible(outUR);
        this.outLL.setVisible(outLL);
        this.outLR.setVisible(outUR);
    }
}
