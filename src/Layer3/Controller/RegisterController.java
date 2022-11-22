package Layer3.Controller;

import Layer2.UseCases.UserUsesCases;
import Layer4.Interface.csvInterface;
import Model.Request.UserRequestModel;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

public class RegisterController {
    public int register(String username, String password) throws IOException {
        csvInterface csvInteract = new csvInterface();
        Map<Integer, UserRequestModel> users = csvInteract.usersReader("database/user.csv");
        Map<Integer, ArrayList<Integer>> friends = csvInteract.friendsReader("database/friends.csv");
        UserUsesCases userManager = new UserUsesCases(users);
        int userId = userManager.addUser(username, password);
        if (userId != -1) {
            csvInteract.usersWriter(userManager.getUsers(), "database/user.csv");
            friends.put(userId, new ArrayList<>(userId));
            csvInteract.friendsWriter("database/friends.csv", friends);
            return userId;
        }else{
            return -1;
        }
    }
}
