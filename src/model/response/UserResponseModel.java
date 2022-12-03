package model.response;

import java.util.ArrayList;

/**
 * <p>This class is responsible for creating a response model for a user.</p>
 *
 * @author: yufeichen
 */

public class UserResponseModel {
    private final int id;

    private final String userType;
    private final String userName;
    private final String userPassword;
    private final String timestamp;

    public UserResponseModel(int id, String userType, String userName, String userPassword, String timestamp) {
        this.id = id;
        this.userName = userName;
        this.userPassword = userPassword;
        this.userType = userType;
        this.timestamp = timestamp;
    }

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
