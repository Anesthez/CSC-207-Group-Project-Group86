package useCases;

import entity.User;
import model.response.UserResponseModel;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>This class is responsible for getting a user from the user list.</p>
 *
 * @author: DominicGu
 */

public class GetUsersUseCase {
    public Map<Integer, UserResponseModel> getUsers(Map<Integer, User> users) {
        Map<Integer, UserResponseModel> userResponseModels = new HashMap<>();
        for (User user:
                users.values()) {
            userResponseModels.put(user.getId(), user.responseModel());
        }
        return userResponseModels;
    }
}
