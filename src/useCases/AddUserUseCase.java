package useCases;

import entity.User;

import java.time.LocalDate;
import java.util.Map;
import java.util.Objects;

/**
 * <p>This class is responsible for adding a new user to the user list.</p>
 *
 * @author: DominicGu
 */

public class AddUserUseCase {
    public int addUser(String userName, String userPassword, Map<Integer, User> users) {
        if (existsName(userName, users)) {
            return -1;
        }else {
            User user = new User(users.size() + 1, "normal", userPassword, userName,
                    LocalDate.now().toString());
            users.put(user.getId(), user);
            return user.getId();
        }
    }
    public boolean existsName(String userName, Map<Integer, User> users) {
        for (User user:
                users.values()) {
            if (Objects.equals(user.getUserName(), userName)){
                return true;
            }
        }
        return false;
    }
}
