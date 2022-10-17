package Entity;

import inputboundary.Searchable;
import inputboundary.Timeable;

import java.sql.Timestamp;
/**
 * Author: Kevin WU
 * Modified by: Yufei Chen
 */
public class User implements Searchable, Timeable {
    private int id;

    private String userType;
    private String userName;
    private String userPassword;
    private final String timestamp;

    public User(int id, String userType, String userName, String userPassword, String timestamp) {
        this.id = id;
        this.userName = userName;
        this.userPassword = userPassword;
        this.userType = userType;
        this.timestamp = timestamp;
    }

    public int getId() {
        return this.id;
    }

    public String getUserType(){return userType;}

    public void setUserType(String type){
        userType = type;
    }

    public void setUserId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return this.userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getTime() {
        return timestamp;
    }

}
