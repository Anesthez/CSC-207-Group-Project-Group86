package Layer1.Entity.factories;

import Layer1.Entity.User;

public class UserFactory {
    /**
     * <p>
     *     This method is used to create a User object.
     * </p>
     * <p>
     *     This method takes in String username, String password, String email, String phone, String ID and push those
     *     parameters onto the User Object.
     * </p>
     *
     * @param username the username of the user
     * @param password the password of the user
     * @param email the email of the user
     * @param phone the phone of the user
     * @param ID the ID of the user
     * @return the user object
     */
    public User create(int id,String userType, String userName, String userPassword, String timestamp){
        return new User(id,userType , userName, userPassword, timestamp);
    }
}
