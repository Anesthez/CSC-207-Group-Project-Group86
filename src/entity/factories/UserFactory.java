package entity.factories;

import entity.User;
import model.request.UserRequestModel;

import java.util.ArrayList;

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
     * @param userModel the model for the user
     * @return the user object
     */
    public User create(UserRequestModel userModel){
        ArrayList<Object> userContents = userModel.get();
        return new User((int)userContents.get(0),
                (String)userContents.get(1),
                (String)userContents.get(2),
                (String)userContents.get(3),
                (String)userContents.get(4));
    }
}
