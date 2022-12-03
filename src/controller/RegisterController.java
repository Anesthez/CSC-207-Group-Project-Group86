package controller;

import useCases.UserUsesCases;
import databaseInterface.CsvInterface;
import model.request.UserRequestModel;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

public class RegisterController {
    public int register(String username, String password) throws IOException {
        CsvInterface csvInteract = new CsvInterface();
        Map<Integer, UserRequestModel> users = csvInteract.usersReader("database/user.csv");
        Map<Integer, ArrayList<Integer>> friends = csvInteract.friendsReader("database/friends.csv");
        UserUsesCases userManager = new UserUsesCases(users);
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
