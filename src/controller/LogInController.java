package controller;

import useCases.UserUsesCases;
import databaseInterface.CsvInterface;
import model.request.UserRequestModel;
import model.response.UserResponseModel;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

public class LogInController {
    ArrayList<Object> userInput;
    public LogInController(ArrayList<Object> userInput){
        this.userInput = userInput;
    }

    public UserResponseModel login() throws IOException {
        CsvInterface csvInteract = new CsvInterface();
        Map<Integer, UserRequestModel> users = csvInteract.usersReader("database/user.csv");
        UserUsesCases userManager = new UserUsesCases(users);
        return userManager.verifyUser((String)userInput.get(0), (String)userInput.get(1));
    }
}
