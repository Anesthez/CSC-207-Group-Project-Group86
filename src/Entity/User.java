package Entity;

import inputboundary.Searchable;

import java.sql.Timestamp;

public class User implements Searchable {
    private int userId;
    private String userName;
    private String userPassword;
    private Timestamp timestamp;

    public User(int userId, String userName, String userPassword) {
        this.userId = userId;
        this.userName = userName;
        this.userPassword = userPassword;
        this.timestamp = new Timestamp(System.currentTimeMillis());
    }

    public int getUserId() {
        return this.userId;
    }

    public void setUserId(int id) {
        this.userId = id;
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

    public Timestamp getTimestamp() {
        return timestamp;
    }

    @Override
    public void searchByID() {
        //TODO to be implemented
    }

    @Override
    public void searchByUsername() {
        //TODO to be implemented

    }

    @Override
    public void searchByTime() {
        //TODO to be implemented

    }
}
