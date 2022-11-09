package Layer1.Entity.factories;

import Layer1.Entity.User;

public class UserFactory {
    /**
     * <p>Constructor for the {@link User User} object using a User model</p>
     *
     * @param id the id of the user
     * @param userType the type of the user
     * @param userName the username of the user
     * @param userPassword the password of the user
     * @param timestamp the time of user creation
     */
    public User create(int id,String userType, String userName, String userPassword, String timestamp){
        return new User(id,userType , userName, userPassword, timestamp);
    }
}
