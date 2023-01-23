package assets.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import src.Main;

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
        setNotificationsInvisible(false, false, false);
    }

    public void onCloseNotificationsBtnClicked() {
        setNotificationsInvisible(true, true, true);
    }  

    //placeholder for now. Can implement settings here.
    //if implementing these, then add the components to the data core, and set the notification components to invisible, when this gets activated, and vice versa.
    public void onUserBtnClicked() {
        System.out.println("Clicked user!!");
    }

    //Home button handlers
    public void onHomeBtnClicked() throws Exception {
        System.out.println("Primary stage" + Main.newStage);
    }

    //Invisible setters
    private void setNotificationsInvisible(boolean notificationsBox, boolean closeNotificationsBtn, boolean x) {
        this.notificationsBox.setVisible(!notificationsBox);
        this.closeNotificationsBtn.setVisible(!closeNotificationsBtn);
        this.x.setVisible(!x);
    }
}
