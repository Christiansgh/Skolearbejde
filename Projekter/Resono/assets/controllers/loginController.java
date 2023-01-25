package assets.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginController {
    private String studentUN = "CorrectStudentUsername";
    private String studentPW = "CorrectStudentPassword";
    private String teacherUN = "CorrectTeacherUsername";
    private String teacherPW = "CorrectTeacherPassword";

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
        System.out.println("Attempting Authentication");
        //check if the login credentials match a student
        if(userNameField.getText().equals(studentUN) && passwordField.getText().equals(studentPW)) {
            System.out.println("Student Authentication Successful");
            //set the scene to student homepage.
            SceneController.changeScene(src.MainMain.stage, "/assets/fxml/home.fxml");
            System.out.println("Switching to home/landing page.");
        }

        //check if the login credentials match a teacher
        else if(userNameField.getText().equals(teacherUN) && passwordField.getText().equals(teacherPW)) {
            System.out.println("Teacher Authentication Successful");
            //set the scene to teacher homepage.
            SceneController.changeScene(src.MainMain.stage, "/assets/fxml/home.fxml");
            System.out.println("Switching to home/landing page.");
        }
        
        //use the login controller to set the invalid login to visible, and hide welcome.
        else {
            errorLabel.setVisible(true);
            welcomeLabel.setVisible(false);
        }

    }
}
