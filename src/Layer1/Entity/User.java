package Layer1.Entity;

import Layer1.Entity.inputboundary.Searchable;
import Layer1.Entity.inputboundary.Timeable;

/**
 * <p>The user object is the profile for each user. The object implements the interfaces of Searchable and Timeable</p>
 *
 * <p>To initialize a user object, we need the id for the user, type of user,
 * username, password, and the time of user creation</p>
 *
 * @implNote the time of user creation for the class is not to be altered, thus set as final.
 * @Author: Kevin WU
 * @Modifiedby: Yufei Chen
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
