package controller;

import useCases.UseCaseFacade.UserUsesCasesFacade;
import databaseInterface.CsvInterface;
import model.request.UserRequestModel;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

/**
 * <p>This class is responsible for adding a new user to the registered user list.</p>
 *
 * @author: yufeichen
 */

public class RegisterController {
    public int register(String username, String password) throws IOException {
        CsvInterface csvInteract = new CsvInterface();
        Map<Integer, UserRequestModel> users = csvInteract.usersReader("database/user.csv");
        Map<Integer, ArrayList<Integer>> friends = csvInteract.friendsReader("database/friends.csv");
        UserUsesCasesFacade userManager = new UserUsesCasesFacade(users);
        int userId = userManager.addUser(username, password);
        if (userId != -1) {
            csvInteract.usersWriter(userManager.getUsers(), "database/user.csv");
            ArrayList<Integer> defaultL = new ArrayList<>();
            defaultL.add(userId);
            friends.put(userId, defaultL);
            csvInteract.friendsWriter("database/friends.csv", friends);
            return userId;
        }else{
            return -1;
        }
    }
}
