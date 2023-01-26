package assets.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.SVGPath;
import src.DataAccesLayer.DAL;

public class TeacherController {
    private boolean showWindow = true;
    private DAL dal;

    @FXML
    private AnchorPane popOutWindow;

    @FXML
    private TextField tfUsername, tfPassword, tfUserType;

    @FXML
    private SVGPath confirmLogo, declineLogo;

    @FXML
    private Rectangle confirmBox, declineBox;

    public void initialize() {
        toggleWindow();
    }

    
    public void createUser() {
        System.out.println("Create User");
        toggleWindow();
        //add eventlisteners for accept or decline.

        //if accept => service method to check that all 3 boxes has text & that user_type is only 1 or 2.

    }

    //accepts and queries
    public void accept() {
        System.out.println("Accepted");
        toggleWindow();
    }
    
    //declines
    public void decline() {
        System.out.println("Declined");
        toggleWindow();
    }

    public void toggleWindow() {
        showWindow = !showWindow;
        popOutWindow.setVisible(showWindow);
    }
} 
