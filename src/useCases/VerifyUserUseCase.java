package useCases;

import entity.User;
import model.response.UserResponseModel;

import java.util.Map;
import java.util.Objects;

/**
 * <p>This class is responsible for verifying a user.</p>
 *
 * @author: DominicGu
 */

public class VerifyUserUseCase {
    public UserResponseModel verifyUser(String userName, String userPassword, Map<Integer, User> users) {
        boolean verified;
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
