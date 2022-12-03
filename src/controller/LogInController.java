package controller;

import useCases.UseCaseFacade.UserUsesCasesFacade;
import databaseInterface.CsvInterface;
import model.request.UserRequestModel;
import model.response.UserResponseModel;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

/**
 * <p>This class is responsible for adding a new user to the user list.</p>
 *
 * @author: yufeichen, LemengDai
 */
public class LogInController {
    ArrayList<Object> userInput;
    public LogInController(ArrayList<Object> userInput){
        this.userInput = userInput;
    }

    public UserResponseModel login() throws IOException {
        CsvInterface csvInteract = new CsvInterface();
        Map<Integer, UserRequestModel> users = csvInteract.usersReader("database/user.csv");
        UserUsesCasesFacade userManager = new UserUsesCasesFacade(users);
        return userManager.verifyUser((String)userInput.get(0), (String)userInput.get(1));
    }
}
