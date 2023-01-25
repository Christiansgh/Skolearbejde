package assets.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;
import src.MainMain;

public class BaseController { 
    //keeping track of notifications togglestate
    private boolean showNotifications = true;
    
    @FXML
    private AnchorPane main;

    //notifications
    @FXML
    private Circle notificationBtn;

    @FXML
    private VBox notificationsBox;

    @FXML
    private Circle closeNotificationsBtn;

    @FXML Label x;

    public void initialize() {
        main.setPickOnBounds(false); // To only click on visible parts (this allows notifications to be on top)
        toggleNotifications();
    }
    
    public void toggleNotifications() {
        System.out.println("Clicked notifications");
        showNotifications = !showNotifications;
        this.notificationsBox.setVisible(showNotifications);
        this.closeNotificationsBtn.setVisible(showNotifications);
        this.x.setVisible(showNotifications);
    }
    
    //placeholder for now. Can implement settings here.
    //if implementing these, then add the components to the data core, and set the notification components to invisible, when this gets activated, and vice versa.
    //for now, this will be used a logout button.
    public void onUserBtnClicked() {
        System.out.println("Clicked user");
        SceneController.changeScene(MainMain.stage, "/assets/fxml/login.fxml");
    }

    //Home button handlers
    public void onHomeBtnClicked() {
        System.out.println("Clicked home");
        SceneController.changeScene(MainMain.stage, "/assets/fxml/home.fxml");
    }
}