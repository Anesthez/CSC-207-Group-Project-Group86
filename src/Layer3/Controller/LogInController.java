package Layer3.Controller;

import Layer1.Entity.User;
import Layer2.UseCases.UserUsesCases;
import Layer4.Interface.csvInterface;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

public class LogInController {
    ArrayList<Object> userInput;
    public LogInController(ArrayList<Object> userInput){
        this.userInput = userInput;
    }

    public int login() throws IOException {
        csvInterface csvInteract = new csvInterface();
        Map<Integer, User> users = csvInteract.usersReader("database/user.csv");
        UserUsesCases userManager = new UserUsesCases(users);
        return userManager.verifyUser((String)userInput.get(0), (String)userInput.get(1));
    }
}
