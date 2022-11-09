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

    /**
     * <p>Constructor for the user object</p>
     *
     * @param id the id of the user
     * @param userType the type of the user
     * @param userName the username of the user
     * @param userPassword the password of the user
     * @param timestamp the time of user creation
     */
    public User(int id, String userType, String userName, String userPassword, String timestamp) {
        this.id = id;
        this.userName = userName;
        this.userPassword = userPassword;
        this.userType = userType;
        this.timestamp = timestamp;
    }

    /**
     * <p>Getter for the id of the user</p>
     *
     * @return the id of the user
     */
    public int getId() {
        return this.id;
    }

    /**
     * <p>Getter for the type of the user</p>
     *
     * @return the type of the user
     */
    public String getUserType(){return userType;}

    /**
     * <p>Setter for the userType of the user</p>
     *
     * @param type the type of the user
     */
    public void setUserType(String type){
        userType = type;
    }

    /**
     * <p>Setter for the userId of the user</p>
     *
     * @param id the id of the user
     */
    public void setUserId(int id) {
        this.id = id;
    }

    /**
     * <p>Getter for the username of the user</p>
     *
     * @return the username of the user
     */
    public String getUserName() {
        return this.userName;
    }

    /**
     * <p>Setter for the username of the user</p>
     *
     * @param userName the username of the user
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * <p>Getter for the password of the user</p>
     *
     * @return the password of the user
     */
    public String getUserPassword() {
        return userPassword;
    }

    /**
     * <p>Setter for the password of the user</p>
     *
     * @param userPassword the password of the user
     */
    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    /**
     * <p>Getter for the time of user creation</p>
     *
     * @return the time of user creation
     */
    public String getTime() {
        return timestamp;
    }

}
