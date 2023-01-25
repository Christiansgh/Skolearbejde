package assets.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import src.DataAccesLayer.DAL;

public class LoginController {
    private DAL dal;

    @FXML 
    private Label welcomeLabel, errorLabel;

    @FXML
    private PasswordField passwordField;

    @FXML
    private TextField userNameField;

    public void initialize() {
        errorLabel.setVisible(false);
    }

    public void onEnter() {
        authenticate();
    }

    //authenticates the login, switches the scene to home on correct credentials, throws error message on wrongful login.
    private void authenticate() {
        //instaniate the connection
        dal = new DAL("resono");

        //check if the login credentials match
        System.out.println("Attempting Authentication");
        
        int result = dal.checkAuthentication(userNameField.getText(), passwordField.getText());
        
        //switch based on results
        switch(result) {
            // failed: use the login controller to set the invalid login to visible, and hide welcome.
            case -1:
                System.out.println("Authentication failed");
                errorLabel.setVisible(true);
                welcomeLabel.setVisible(false);
                break;
            // found student: set the scene to student homepage.
            case 0:
                System.out.println("Student Authentication Successful");
                SceneController.changeScene(src.MainMain.stage, "/assets/fxml/home.fxml");
                System.out.println("Switching to home/landing page.");
                break;
            // found teacher: set the scene to teacher homepage.
            case 1:
                System.out.println("Teacher Authentication Successful");
                SceneController.changeScene(src.MainMain.stage, "/assets/fxml/teacher.fxml");
                System.out.println("Switching to home/landing page.");
                break;
        }
    }
}
