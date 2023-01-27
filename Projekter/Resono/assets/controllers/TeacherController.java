package assets.controllers;

import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.SVGPath;
import src.DataAccesLayer.Assignment;
import src.DataAccesLayer.DAL;
import src.DataAccesLayer.Tag;
import src.DataAccesLayer.User;

/*
 * In this version its only possible for textfield one to insert data into column 1. tf2 => column 2 etc.
 */

public class TeacherController {
    private boolean showWindow = true;
    private int inputFieldsNeeded;
    private enum CRUD {
        INSERT,
        UPDATE,
        DELETE;
    }
    @FXML TableColumn<User, Integer> userID;
    @FXML TableColumn<User, String> userUsername;
    @FXML TableColumn<User, String> userPassword;
    @FXML TableColumn<User, Integer> userUserType;
    @FXML TableColumn<Tag, Integer> tagID;
    @FXML TableColumn<Tag, String> tagText;
    @FXML TableColumn<Tag, String> tagColor;
    @FXML TableColumn<Tag, String> tagStrokeColor;
    @FXML TableColumn<Assignment, Integer> assignmentID;
    @FXML TableColumn<Assignment, String> assignmentTitle; 
    @FXML TableColumn<Assignment, String> assignmentCreatorFN;
    @FXML TableColumn<Assignment, String> assignmentCreatorLN;
    @FXML TableColumn<Assignment, String> assignmentDescription;

    @FXML private AnchorPane popOutWindow;

    @FXML private TextField tfOne, tfTwo, tfThree, tfFour, tfFive;

    @FXML private Label tfOneUsername, tfTwoPassword, tfThreeUserType, tfOneTagText, tfTwoTagColor, tfThreeTagStrokeColor;
    @FXML private Label tfOneTitle, tfTwoCreatorFN, tfThreeCreatorLN, tfFourAssignmentDescription, tfOneDeleteUser, tfFiveDescription;

    @FXML private SVGPath confirmLogo, declineLogo;

    @FXML 
    private TableView<User> userTable;

    @FXML
    private TableView<Tag> tagTable;

    @FXML
    private TableView<Assignment> assignmentTable;

    @FXML private Rectangle confirmBox, declineBox;

    public void initialize() {
        toggleWindow();
    }
    
    //same structure for the other CREATE functions
    public void createUser() {
        System.out.println("Create User");
        toggleWindow(); //set the window visible
        hideAll(); //hide all textprompts
        
        DAL dal = new DAL("resono"); //instantiate new connection
        inputFieldsNeeded = dal.getColumnAmount("Logins"); //fetch amount of columns in the table.
        inputFieldsNeeded--; //deduct the ID / Identity, cus no manual input needed

        showInputFields(inputFieldsNeeded); //set visible based on amount of input
        showCreateUserText(); //display only "Create User Text prompts"

        //listen for accept, check that no boxes are empty then execute the statement
        listenForAccept(confirmLogo, confirmBox, inputFieldsNeeded, CRUD.INSERT, "Logins", "username", "password", "user_type");   
    }

    public void createTag() {
        System.out.println("Create Tag");
        toggleWindow(); 
        hideAll();
        
        DAL dal = new DAL("resono");
        inputFieldsNeeded = dal.getColumnAmount("Tags");
        inputFieldsNeeded--;

        showInputFields(inputFieldsNeeded);
        showCreateTagText();

        listenForAccept(confirmLogo, confirmBox, inputFieldsNeeded, CRUD.INSERT, "Tags", "text", "color", "stroke_color");
    }

    public void createAssignment() {
        System.out.println("Create Assignment");
        toggleWindow(); 
        hideAll();
        
        DAL dal = new DAL("resono");
        inputFieldsNeeded = dal.getColumnAmount("Assignments");
        inputFieldsNeeded--;

        showInputFields(inputFieldsNeeded);
        showCreateAssignmentText();

        listenForAccept(confirmLogo, confirmBox, inputFieldsNeeded, CRUD.INSERT, "Assignments", "title", "creator_fn", "creator_ln", "description");
    }

    //same structure for the other READ functions
    public void readUser() {
        System.out.println("Read User");
        toggleWindow();
        hideAll(); //hide all
        hideConfirmDecline();
        userTable.setVisible(true); //but the tableview
        DAL dal = new DAL("resono"); //connect to DB
        try {
            ResultSet resultSet = dal.read("SELECT * FROM Logins"); //query
            ObservableList<User> userSearchModel = FXCollections.observableArrayList();
            while (resultSet.next()) {
                Integer queryUserID = resultSet.getInt("id");
                Integer queryUserUserType = resultSet.getInt("user_type");
                String queryUserUsername = resultSet.getString("username");
                String queryUserPassword = resultSet.getString("password");

                userSearchModel.add(new User(queryUserID, queryUserUserType, queryUserUsername, queryUserPassword));
            }
            userID.setCellValueFactory(new PropertyValueFactory<>("userID"));
            userUsername.setCellValueFactory(new PropertyValueFactory<>("userUsername"));
            userPassword.setCellValueFactory(new PropertyValueFactory<>("userPassword"));
            userUserType.setCellValueFactory(new PropertyValueFactory<>("userUserType"));
            
            userTable.setItems(userSearchModel);
            
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void readTag() {
        System.out.println("Read Tag");
        toggleWindow();
        hideAll();
        hideConfirmDecline();
        tagTable.setVisible(true);
        DAL dal = new DAL("resono");
        try {
            ResultSet resultSet = dal.read("SELECT * FROM Tags");
            ObservableList<Tag> userSearchModel = FXCollections.observableArrayList();
            while(resultSet.next()) {
                Integer queryTagID = resultSet.getInt("id");
                String queryTagText = resultSet.getString("text");
                String queryTagColor = resultSet.getString("color");
                String queryStrokeColor = resultSet.getString("stroke_color");

                userSearchModel.add(new Tag(queryTagID, queryTagText, queryTagColor, queryStrokeColor));
            } 
            tagID.setCellValueFactory(new PropertyValueFactory<>("tagID"));
            tagText.setCellValueFactory(new PropertyValueFactory<>("tagText"));
            tagColor.setCellValueFactory(new PropertyValueFactory<>("tagColor"));
            tagStrokeColor.setCellValueFactory(new PropertyValueFactory<>("tagStrokeColor"));

            tagTable.setItems(userSearchModel);
        }
        catch(SQLException e) {
            System.out.println(e);
        }
    }

    public void readAssignment() {
        System.out.println("Read Assignment");
        toggleWindow();
        hideAll();
        hideConfirmDecline();
        assignmentTable.setVisible(true);
        DAL dal = new DAL("resono");
        try {
            ResultSet resultSet = dal.read("SELECT * FROM Assignments");
            ObservableList<Assignment> userSearchModel = FXCollections.observableArrayList();
            while(resultSet.next()) {
                Integer queryAssignmentID = resultSet.getInt("id");
                String queryAssignmentTitle = resultSet.getString("title");
                String queryAssignmentCreatorFN = resultSet.getString("creator_fn");
                String queryAssignmentCreatorLN = resultSet.getString("creator_ln");
                String queryAssignmentDescription = resultSet.getString("description");

                userSearchModel.add(new Assignment(queryAssignmentID, queryAssignmentTitle, queryAssignmentCreatorFN, queryAssignmentCreatorLN, queryAssignmentDescription));
            } 
            assignmentID.setCellValueFactory(new PropertyValueFactory<>("assignmentID"));
            assignmentTitle.setCellValueFactory(new PropertyValueFactory<>("assignmentTitle"));
            assignmentCreatorFN.setCellValueFactory(new PropertyValueFactory<>("assignmentCreatorFN"));
            assignmentCreatorLN.setCellValueFactory(new PropertyValueFactory<>("assignmentCreatorLN"));
            assignmentDescription.setCellValueFactory(new PropertyValueFactory<>("assignmentDescription"));

            assignmentTable.setItems(userSearchModel);
        }
        catch(SQLException e) {
            System.out.println(e);
        }
    }

    //updates a user. 
    //the other UPDATE functions follow a similar structure.
    public void updateUser() {
        System.out.println("Update User");
        toggleWindow(); //set the window visible
        hideAll(); //hide all textprompts
    }

    public void updateAssignment() {
        System.out.println("Update User");
        toggleWindow(); //set the window visible
        hideAll(); //hide all textprompts

        DAL dal = new DAL("resono");
        inputFieldsNeeded = dal.getColumnAmount("assignments");
        showInputFields(inputFieldsNeeded); // -1 for "IDENTITY", + for the ID to update, so no change.
        showUpdateAssignmentText();

        listenForAccept(confirmLogo, confirmBox, inputFieldsNeeded, CRUD.UPDATE, "Assignments");

    }

    //deletes a user. 
    //the other DELETE functions follow a similar structure.
    public void deleteUser() {
        System.out.println("Delete User");
        toggleWindow(); //set the window visible
        hideAll(); //hide all textprompts
        tfOne.setVisible(true); //set delete input field visible
        tfOneDeleteUser.setVisible(true); //display GUI prompt

        //listens for click of accpet button. On accept, check that there are no empty boxes, then executes the statement.
        listenForAccept(confirmLogo, confirmBox, 1, CRUD.DELETE, "Logins");
    }

    public void deleteTag() {
        System.out.println("Delete Tag");
        toggleWindow(); 
        hideAll(); 
        tfOne.setVisible(true); 
        tfOneDeleteUser.setVisible(true); 

        //listens for click of accpet button. On accept, check that there are no empty boxes, then executes the statement.
        listenForAccept(confirmLogo, confirmBox, 1, CRUD.DELETE, "Tags");
    }

    public void deleteAssignment() {
        System.out.println("Delete Assignment");
        toggleWindow();
        hideAll(); 
        tfOne.setVisible(true); 
        tfOneDeleteUser.setVisible(true); 

        //listens for click of accpet button. On accept, check that there are no empty boxes, then executes the statement.
        listenForAccept(confirmLogo, confirmBox, 1, CRUD.DELETE, "Assignments");
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

    //Delete FROM
    public void listenForAccept(SVGPath confirmLogo, Rectangle confirmBox, int checkFields, CRUD crudEnum, String tableName) {
        confirmBox.setOnMouseClicked(new EventHandler<Event>() {
            @Override
            public void handle(Event arg0) {
                selectCRUD(checkFields, crudEnum, tableName);
            }       
        });
        confirmLogo.setOnMouseClicked(new EventHandler<Event>() {
            @Override
            public void handle(Event arg0) {
                selectCRUD(checkFields, crudEnum, tableName);
            }   
        });
    }

    private void showUpdateAssignmentText() {
        showCreateAssignmentText();
        tfFiveDescription.setVisible(true);
    }

    private void showCreateAssignmentText() {
        tfOneTitle.setVisible(true);
        tfTwoCreatorFN.setVisible(true);
        tfThreeCreatorLN.setVisible(true);
        tfFourAssignmentDescription.setVisible(true);
    }

    private void showCreateUserText() {
        tfOneUsername.setVisible(true);
        tfTwoPassword.setVisible(true);
        tfThreeUserType.setVisible(true);
    }

    private void showCreateTagText() {
        tfOneTagText.setVisible(true);
        tfTwoTagColor.setVisible(true);
        tfThreeTagStrokeColor.setVisible(true);
    }

    //Service method: displays N input fields based on the amount of column input needed.
    private void showInputFields(int amount) {
        switch(amount) {
            case 1:
                tfOne.setVisible(true);
                break;
            case 2:
                tfOne.setVisible(true);
                tfTwo.setVisible(true);
                break;
            case 3:
                tfOne.setVisible(true);
                tfTwo.setVisible(true);
                tfThree.setVisible(true);
                break;
            case 4:
                tfOne.setVisible(true);
                tfTwo.setVisible(true);
                tfThree.setVisible(true);
                tfFour.setVisible(true);
                break;
            case 5:
                tfOne.setVisible(true);
                tfTwo.setVisible(true);
                tfThree.setVisible(true);
                tfFour.setVisible(true);
                tfFive.setVisible(true);
                break;
        }
    }

    //Service method returns boolean if theres text in all fields from 1 to 4 based on the parameter.
    private boolean isEmpty(int fields) {
        switch(fields) {
            case 1:
                return tfOne.getText().isEmpty();
            case 2:
                return (
                tfOne.getText().isEmpty() &&
                tfTwo.getText().isEmpty()
                );
            case 3:
            return (
                tfOne.getText().isEmpty() &&
                tfTwo.getText().isEmpty() &&
                tfThree.getText().isEmpty()
                );
            case 4: 
            return (
                tfOne.getText().isEmpty() &&
                tfTwo.getText().isEmpty() &&
                tfThree.getText().isEmpty() &&
                tfFour.getText().isEmpty()
                );
            default:
            return false;
        }
    }

    private void hideConfirmDecline() {
        confirmBox.setVisible(false);
        confirmLogo.setVisible(false);
        declineBox.setVisible(false);
        declineLogo.setVisible(false);
    }

    //Service method: Hides all TextFields / PromptText
    private void hideAll() {
        tfOneTagText.setVisible(false);
        tfOneUsername.setVisible(false);
        tfTwoTagColor.setVisible(false);
        tfTwoPassword.setVisible(false);
        tfThreeTagStrokeColor.setVisible(false);
        tfThreeUserType.setVisible(false);
        tfOne.setVisible(false);
        tfTwo.setVisible(false);
        tfThree.setVisible(false);
        tfFour.setVisible(false);
        tfOneTitle.setVisible(false);
        tfTwoCreatorFN.setVisible(false);
        tfThreeCreatorLN.setVisible(false);
        tfFourAssignmentDescription.setVisible(false);
        tagTable.setVisible(false);
        userTable.setVisible(false);
        assignmentTable.setVisible(false);
        tfOneDeleteUser.setVisible(false);
        tfFive.setVisible(false);
        tfFiveDescription.setVisible(false);
    }

    //DELETE
    //Service methods overloaded methods decide the CRUD function. Overloaded to accomodate 1-4 columns.
    private void selectCRUD(int checkFields, CRUD crudEnum, String tableName) {
        if(!isEmpty(checkFields)) {
            System.out.println("Accepted");
            DAL dal = new DAL("resono");
            switch(crudEnum) {
                case INSERT:
                break;
                case UPDATE:
                break;
                case DELETE:
                dal.deleteFrom(tableName, Integer.valueOf(tfOne.getText()));
                break;
            }
            toggleWindow();
        }
        else {
            System.out.println("One or more required textfield(s) are empty.");
            //TODO: Put some visual notifier in the GUI.
        }
    }

    //1 column
    private void selectCRUD(int checkFields, CRUD crudEnum, String tableName, String column1, String value1) {
        if(!isEmpty(checkFields)) {
            System.out.println("Accepted");
            DAL dal = new DAL("resono");
            switch(crudEnum) {
                case INSERT:
                dal.insertInto(tableName, column1, value1);
                break;
                case UPDATE:
                dal.updateSet(tableName, column1, value1, Integer.valueOf(tfFive.getText()));
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
                case UPDATE:
                dal.updateSet(tableName, column1, column2, value1, value2, Integer.valueOf(tfFive.getText()));
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
                case UPDATE:
                dal.updateSet(tableName, column1, column2, column3, value1, value2, value3, Integer.valueOf(tfFive.getText()));
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
                case UPDATE:
                dal.updateSet(tableName, column1, column2, column3, column4, value1, value2, value3, value4, Integer.valueOf(tfFive.getText()));
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
