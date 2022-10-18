package repositories;

import Entity.User;

import java.time.LocalDate;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;

/**
 * Author:Kevin Wu
 * Modified by: Yufei Chen
 */
public class UserManager {
    private final Map<Integer, User> users;

    public UserManager(Map<Integer, User> users){
        this.users = users;
    }
    public int addUser(String userName, String userPassword) {
        User user = new User(users.size() + 1,"normal", userPassword, userName, LocalDate.now().toString());
        users.put(user.getId(), user);
        return user.getId();
    }

    public void deleteUser(int userId) {
        users.remove(userId);
    }

    public void changePassword(int userId, String password) {
        users.get(userId).setUserPassword(password);
    }

    public void changeUsername(int userId, String name) {
        users.get(userId).setUserName(name);
    }

    /**
     * TODO
     * get userId with userName
     * see whether the password is match or not
     * return result
     */
    public int verifyUser(String userName, String userPassword) {
        boolean verified = false;
        for (User user:
             users.values()) {
            verified = (Objects.equals(user.getUserName(), userName) &&
                    Objects.equals(user.getUserPassword(), userPassword));

            if (verified){
                return user.getId();
            }
        }

        return -1;
    }

}
