package Layer2.UseCases;

import Layer1.Entity.User;
import Layer1.Entity.factories.UserFactory;
import Model.Request.UserRequestModel;
import Model.Response.UserResponseModel;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * <p>The UserUseCases contains a hash map mapping the id of the user with the corresponding {@link User User} object.
 * to initialize it, we need the hash map.</p>
 *
 * @Author: Kevin Wu
 * @Modifiedby: Yufei Chen
 */
public class UserUsesCases {

    private final Map<Integer, User> users = new HashMap<>();

    /**
     * <p>Constructor for the UserUseCases object</p>
     *
     * @param users the hash map the id of the user with the corresponding {@link User User} object
     */
    public UserUsesCases(Map<Integer, UserRequestModel> users){
        UserFactory userFactory = new UserFactory();
        for (UserRequestModel userRequestModel : users.values()) {
            User user = userFactory.create(userRequestModel);
            this.users.put(user.getId(), user);
        }
    }

    /**
     * <p>Add a new {@link User User} object</p>
     *
     * @return user id, -1 if the user already exists
     */
    public int addUser(String userName, String userPassword) {
        User user = new User(users.size() + 1,"normal", userPassword, userName, LocalDate.now().toString());
        users.put(user.getId(), user);
        return user.getId();
    }

    /**
     * <p>Delete a user from the hashmap</p>
     *
     * @param id the id of the user
     */
    public void deleteUser(int userId) {
        users.remove(userId);
    }

    /**
     * <p>Change the password for the user</p>
     *
     * @param userId the id of the user
     * @param password the password of the user
     */
    public void changePassword(int userId, String password) {
        users.get(userId).setUserPassword(password);
    }

    /**
     * <p>Change the username for the user</p>
     *
     * @param userId the id of the user
     * @param name the username of the user
     */
    public void changeUsername(int userId, String name) {
        users.get(userId).setUserName(name);
    }

    /**
     * <p>Verify whether if the user's password is correct</p>
     *
     * @param userName the username of the user
     * @param userPassword the password of the user
     */
    public UserResponseModel verifyUser(String userName, String userPassword) {
        boolean verified = false;
        for (User user:
             users.values()) {
            verified = (Objects.equals(user.getUserName(), userName) &&
                    Objects.equals(user.getUserPassword(), userPassword));

            if (verified){
                return user.responseModel();
            }
        }

        return null;
    }

}
