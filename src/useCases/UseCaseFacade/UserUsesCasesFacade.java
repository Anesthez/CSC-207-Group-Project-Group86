package useCases.UseCaseFacade;

import entity.User;
import entity.factories.UserFactory;
import model.request.UserRequestModel;
import model.response.UserResponseModel;
import useCases.AddUserUseCase;
import useCases.GetUsersUseCase;
import useCases.VerifyUserUseCase;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>The UserUseCases contains a hash map mapping the id of the user with the corresponding {@link User User} object.
 * to initialize it, we need the hash map.</p>
 *
 * @Author: Kevin Wu
 * @Modifiedby: Yufei Chen
 */
public class UserUsesCasesFacade {

    private final Map<Integer, User> users = new HashMap<>();
    private final AddUserUseCase auu;
    private final VerifyUserUseCase vuu;
    private final GetUsersUseCase guu;

    /**
     * <p>Constructor for the UserUseCases object</p>
     *
     * @param users the hash map the id of the user with the corresponding {@link User User} object
     */
    public UserUsesCasesFacade(Map<Integer, UserRequestModel> users){
        UserFactory userFactory = new UserFactory();
        for (UserRequestModel userRequestModel : users.values()) {
            User user = userFactory.create(userRequestModel);
            this.users.put(user.getId(), user);
        }
        this.auu = new AddUserUseCase();
        this.vuu = new VerifyUserUseCase();
        this.guu = new GetUsersUseCase();
    }

    /**
     * <p>Add a new {@link User User} object</p>
     *
     * @return user id, -1 if the user already exists
     */
    public int addUser(String userName, String userPassword) {
        return auu.addUser(userName, userPassword, this.users);
    }

    /**
     * <p>Verify whether if the user's password is correct</p>
     *
     * @param userName the username of the user
     * @param userPassword the password of the user
     */
    public UserResponseModel verifyUser(String userName, String userPassword) {
        return vuu.verifyUser(userName, userPassword, this.users);
    }

    public Map<Integer, UserResponseModel> getUsers() {
        return guu.getUsers(this.users);
    }
}
