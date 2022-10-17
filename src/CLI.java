import Entity.User;
import Interface.csvInterface;
import repositories.UserManager;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

public class CLI {

    public void loginInterface() throws IOException {
        Scanner input=new Scanner(System.in);
        csvInterface csvInteract = new csvInterface();
        Map<Integer, User> users = csvInteract.usersReader("database/user.csv");
        UserManager userManager = new UserManager(users);
        boolean flag = true;
        while(flag){
            String userInput = input.nextLine();
            if (userInput.substring(0, 6).equals("/login")){
                String[] inputLines = userInput.substring(7).split("-");
                if (inputLines.length == 3){
                    if(userManager.verifyUser(inputLines[1], inputLines[2])){
                        postInterface();
                        flag = false;
                    }
                }
            }
            if (userInput.substring(0, 9).equals("/register")){
                String[] inputLines = userInput.substring(10).split("-");
                if (inputLines.length == 3){
                    userManager.addUser(inputLines[1], inputLines[2]);
                    csvInteract.usersWriter(users, "database/user.csv");
                    postInterface();
                    flag = false;
                }
            }
        }
    }

    public void postInterface() throws IOException{

    }

    public static void main(String[] args) throws IOException {
        CLI test = new CLI();
        test.loginInterface();
    }

}