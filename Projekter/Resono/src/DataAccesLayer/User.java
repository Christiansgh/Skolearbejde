package src.DataAccesLayer;
/*
 * Databearing object
 */
public class User {
    private Integer userID, userUserType;
    private String userUsername, userPassword;
    
    public User(Integer userID, Integer userUserType, String userUsername, String userPassword) {
        this.userID = userID;
        this.userUserType = userUserType;
        this.userUsername = userUsername;
        this.userPassword = userPassword;
    }

    public Integer getUserID() {
        return userID;
    }

    public void setUserID(Integer userID) {
        this.userID = userID;
    }

    public Integer getUserUserType() {
        return userUserType;
    }

    public void setUserUserType(Integer userUserType) {
        this.userUserType = userUserType;
    }

    public String getUserUsername() {
        return userUsername;
    }

    public void setUserUsername(String userUsername) {
        this.userUsername = userUsername;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }
}
