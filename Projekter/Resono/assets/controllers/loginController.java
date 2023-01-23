package assets.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import src.MainMain;

public class LoginController {
    private String studentUN = "CorrectStudentUsername";
    private String studentPW = "CorrectStudentPassword";
    private String teacherUN = "CorrectTeacherUsername";
    private String teacherPW = "CorrectTeacherPassword";

    @FXML
    private PasswordField passwordField;

    @FXML
    private TextField userNameField;

    public void onEnter() {
        authenticate();
    }

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
            
        }
        //use the login controller to set the invalid login to visible, and hide welcome.


    }
}
