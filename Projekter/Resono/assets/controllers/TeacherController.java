package assets.controllers;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.SVGPath;
import src.DataAccesLayer.DAL;

/*
 * In this version its only possible for textfield one to insert data into column 1. tf2 => column 2 etc.
 */

public class TeacherController {
    private boolean showWindow = true;
    private int inputFieldsNeeded;
    private enum CRUD {
        INSERT,
        READ,
        UPDATE,
        DELETE;
    }

    @FXML
    private AnchorPane popOutWindow;

    @FXML
    private TextField tfOne, tfTwo, tfThree, tfFour;

    @FXML
    private Label tfOneUsername, tfTwoPassword, tfThreeUserType;

    @FXML
    private SVGPath confirmLogo, declineLogo;

    @FXML
    private Rectangle confirmBox, declineBox;

    public void initialize() {
        toggleWindow();
    }
    
    public void createUser() {
        System.out.println("Create User");
        toggleWindow(); //set the window visible
        hideAllText(); //hide all textprompts
        
        DAL dal = new DAL("resono"); //instantiate new connection
        inputFieldsNeeded = dal.getColumnAmount("Logins"); //fetch amount of columns in the table.
        inputFieldsNeeded--; //deduct the ID / Identity, cus no manual input needed

        showInputFields(inputFieldsNeeded); //set visible based on amount of input
        showCreateUserText(); //display only "Create User Text prompts"

        //listen for accept, check that no boxes are empty then execute the statement
        listenForAccept(confirmLogo, confirmBox, inputFieldsNeeded, CRUD.INSERT, "Logins", "username", "password", "user_type");   
    }
    
    //declines & closes the popup window for teacher CRUD.
    public void decline() {
        System.out.println("Declined");
        toggleWindow();
    }

    //toggles crud window
    public void toggleWindow() {
        showWindow = !showWindow;
        popOutWindow.setVisible(showWindow);
    }

    
    //listen for click on the accept button, then executes query based on the CRUD enum selected. Overloaded this as well, to accomodate for the fact that theres 1-4 columns.
    // 1 column
    public void listenForAccept(SVGPath confirmLogo, Rectangle confirmBox, int checkFields, CRUD crudEnum, String tableName, String column1) {
        confirmBox.setOnMouseClicked(new EventHandler<Event>() {
            @Override
            public void handle(Event arg0) {
                selectCRUD(checkFields, crudEnum, tableName, column1, tfOne.getText());
            }       
        });
        confirmLogo.setOnMouseClicked(new EventHandler<Event>() {
            @Override
            public void handle(Event arg0) {
                selectCRUD(checkFields, crudEnum, tableName, column1, tfOne.getText());
            }   
        });
    }

    // 2 columns
    public void listenForAccept(SVGPath confirmLogo, Rectangle confirmBox, int checkFields, CRUD crudEnum, String tableName, String column1, String column2) {
        confirmBox.setOnMouseClicked(new EventHandler<Event>() {
            @Override
            public void handle(Event arg0) {
                selectCRUD(checkFields, crudEnum, tableName, column1, column2, tfOne.getText(), tfTwo.getText());
            }     
        });
        confirmLogo.setOnMouseClicked(new EventHandler<Event>() {
            @Override
            public void handle(Event arg0) {
                selectCRUD(checkFields, crudEnum, tableName, column1, column2, tfOne.getText(), tfTwo.getText());
            }   
        });
    }

    // 3 columns
    public void listenForAccept(SVGPath confirmLogo, Rectangle confirmBox, int checkFields, CRUD crudEnum, String tableName, String column1, String column2, String column3) {
        confirmBox.setOnMouseClicked(new EventHandler<Event>() {
            @Override
            public void handle(Event arg0) {
                selectCRUD(checkFields, crudEnum, tableName, column1, column2, column3, tfOne.getText(), tfTwo.getText(), tfThree.getText());
            }    
        });
        confirmLogo.setOnMouseClicked(new EventHandler<Event>() {
            @Override
            public void handle(Event arg0) {
                selectCRUD(checkFields, crudEnum, tableName, column1, column2, column3, tfOne.getText(), tfTwo.getText(), tfThree.getText());
            } 
        });
    }

    // 4 columns
    public void listenForAccept(SVGPath confirmLogo, Rectangle confirmBox, int checkFields, CRUD crudEnum, String tableName, String column1, String column2, String column3, String column4) {
        confirmBox.setOnMouseClicked(new EventHandler<Event>() {
            @Override
            public void handle(Event arg0) {
                selectCRUD(checkFields, crudEnum, tableName, column1, column2, column3, column4, tfOne.getText(), tfTwo.getText(), tfThree.getText(), tfFour.getText());
            }    
        });
        confirmLogo.setOnMouseClicked(new EventHandler<Event>() {
            @Override
            public void handle(Event arg0) {
                selectCRUD(checkFields, crudEnum, tableName, column1, column2, column3, column4, tfOne.getText(), tfTwo.getText(), tfThree.getText(), tfFour.getText());
            } 
        });
    }

    //Service method
    private void showCreateUserText() {
        this.tfOneUsername.setVisible(true);
        this.tfTwoPassword.setVisible(true);
        this.tfThreeUserType.setVisible(true);
    }

    //Service method: displays N input fields based on the amount of column input needed.
    private void showInputFields(int amount) {
        switch(amount) {
            case 1:
                this.tfOne.setVisible(true);
                break;
            case 2:
                this.tfOne.setVisible(true);
                this.tfTwo.setVisible(true);
                break;
            case 3:
                this.tfOne.setVisible(true);
                this.tfTwo.setVisible(true);
                this.tfThree.setVisible(true);
                break;
            case 4:
                this.tfOne.setVisible(true);
                this.tfTwo.setVisible(true);
                this.tfThree.setVisible(true);
                this.tfFour.setVisible(true);
                break;
        }
    }

    //Service method returns boolean if theres text in all fields from 1 to 4 based on the parameter.
    private boolean isEmpty(int fields) {
        switch(fields) {
            case 1:
                return this.tfOne.getText().isEmpty();
            case 2:
                return (
                this.tfOne.getText().isEmpty() &&
                this.tfTwo.getText().isEmpty()
                );
            case 3:
            return (
                this.tfOne.getText().isEmpty() &&
                this.tfTwo.getText().isEmpty() &&
                this.tfThree.getText().isEmpty()
                );
            case 4: 
            return (
                this.tfOne.getText().isEmpty() &&
                this.tfTwo.getText().isEmpty() &&
                this.tfThree.getText().isEmpty() &&
                this.tfFour.getText().isEmpty()
                );
            default:
            return false;
        }
    }

    //Service method: Hides all TextFields / PromptText
    private void hideAllText() {
        this.tfOne.setVisible(false);
        this.tfTwo.setVisible(false);
        this.tfThree.setVisible(false);
        this.tfFour.setVisible(false);
        this.tfOne.setVisible(false);
        this.tfTwo.setVisible(false);
        this.tfThree.setVisible(false);
    }

    //Service methods overloaded methods decide the CRUD function. Overloaded to accomodate 1-4 columns.
    //1 column
    private void selectCRUD(int checkFields, CRUD crudEnum, String tableName, String column1, String value1) {
        if(!isEmpty(checkFields)) {
            System.out.println("Accepted");
            DAL dal = new DAL("resono");
            switch(crudEnum) {
                case INSERT:
                dal.insertInto(tableName, column1, value1);
                break;
                case READ:
                //READ QUERY
                break;
                case UPDATE:
                //UPDATE QUERY
                break;
                case DELETE:
                //DELETE QUERY
                break;
            }
            toggleWindow();
        }
        else {
            System.out.println("One or more required textfield(s) are empty.");
            //TODO: Put some visual notifier in the GUI.
        }
    }

    //2 columns
    private void selectCRUD(int checkFields, CRUD crudEnum, String tableName, String column1, String column2, String value1, String value2) {
        if(!isEmpty(checkFields)) {
            System.out.println("Accepted");
            DAL dal = new DAL("resono");
            switch(crudEnum) {
                case INSERT:
                dal.insertInto(tableName, column1, column2, value1, value2);
                break;
                case READ:
                //READ QUERY
                break;
                case UPDATE:
                //UPDATE QUERY
                break;
                case DELETE:
                //DELETE QUERY
                break;
            }
            toggleWindow();
        }
        else {
            System.out.println("One or more required textfield(s) are empty.");
            //TODO: Put some visual notifier in the GUI.
        }
    }

    //3 columns
    private void selectCRUD(int checkFields, CRUD crudEnum, String tableName, String column1, String column2, String column3, String value1, String value2, String value3) {
        if(!isEmpty(checkFields)) {
            System.out.println("Accepted");
            DAL dal = new DAL("resono");
            switch(crudEnum) {
                case INSERT:
                dal.insertInto(tableName, column1, column2, column3, value1, value2, value3);
                break;
                case READ:
                //READ QUERY
                break;
                case UPDATE:
                //UPDATE QUERY
                break;
                case DELETE:
                //DELETE QUERY
                break;
            }
            toggleWindow();
        }
        else {
            System.out.println("One or more required textfield(s) are empty.");
            //TODO: Put some visual notifier in the GUI.
        }
    }

    //4 columns
    private void selectCRUD(int checkFields, CRUD crudEnum, String tableName, String column1, String column2, String column3, String column4, String value1, String value2, String value3, String value4) {
        if(!isEmpty(checkFields)) {
            System.out.println("Accepted");
            DAL dal = new DAL("resono");
            switch(crudEnum) {
                case INSERT:
                dal.insertInto(tableName, column1, column2, column3, column4, value1, value2, value3, value4);
                break;
                case READ:
                //READ QUERY
                break;
                case UPDATE:
                //UPDATE QUERY
                break;
                case DELETE:
                //DELETE QUERY
                break;
            }
            toggleWindow();
        }
        else {
            System.out.println("One or more required textfield(s) are empty.");
            //TODO: Put some visual notifier in the GUI.
        }
    }
} 
