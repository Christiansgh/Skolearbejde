package assets.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;
import src.MainMain;

public class BaseController { 
    //notifications
    @FXML
    private Circle notificationBtn;

    @FXML
    private VBox notificationsBox;

    @FXML
    private Circle closeNotificationsBtn;

    @FXML Label x;

    public void initialize() throws Exception {
        setNotificationsInvisible(true, true, true);
    }

    //Notification button handlers
    public void onNotificationsBtnClicked() {
        System.out.println("Clicked notifications");
        setNotificationsInvisible(false, false, false);
        HomeController hc = new HomeController();
        hc.setAssigmentFourinvisible();
    }

    public void onCloseNotificationsBtnClicked() {
        System.out.println("Closed notifications");
        setNotificationsInvisible(true, true, true);
    } 
    
    //Invisible setters
    private void setNotificationsInvisible(boolean notificationsBox, boolean closeNotificationsBtn, boolean x) {
        this.notificationsBox.setVisible(!notificationsBox);
        this.closeNotificationsBtn.setVisible(!closeNotificationsBtn);
        this.x.setVisible(!x);
    }
    
    //placeholder for now. Can implement settings here.
    //if implementing these, then add the components to the data core, and set the notification components to invisible, when this gets activated, and vice versa.
    //for now, this will be used a logout button.
    public void onUserBtnClicked() {
        System.out.println("Clicked user");
        SceneController.changeScene(MainMain.stage, "/assets/fxml/login.fxml");
    }

    //Home button handlers
    public void onHomeBtnClicked() throws Exception {
        System.out.println("Clicked home");
        SceneController.changeScene(MainMain.stage, "/assets/fxml/home.fxml");
    }
}