package model.request;

import entity.User;

import java.util.ArrayList;

/**
 * <p>The Request model for {@link User User}</p>
 *
 * @Author: Yufei Chen
 */
public class UserRequestModel {
    private final int id;

    private final String userType;
    private final String userName;
    private final String userPassword;
    private final String timestamp;

    /**
     * <p>Constructor for the user model</p>
     *
     * @param id the id of the user
     * @param userType the type of the user
     * @param userName the username of the user
     * @param userPassword the password of the user
     * @param timestamp the time of user creation
     */
    public UserRequestModel(int id, String userType, String userName, String userPassword, String timestamp) {
        this.id = id;
        this.userName = userName;
        this.userPassword = userPassword;
        this.userType = userType;
        this.timestamp = timestamp;
    }

    /**
     * <p>Getter for all the User objects</p>
     *
     * @return an ArrayList of all the User objects
     */
    public ArrayList<Object> get() {
        ArrayList<Object> contents = new ArrayList<>();
        contents.add(id);
        contents.add(userType);
        contents.add(userName);
        contents.add(userPassword);
        contents.add(timestamp);
        return contents;
    }
}
