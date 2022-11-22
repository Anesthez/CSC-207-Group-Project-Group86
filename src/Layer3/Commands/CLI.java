package Layer3.Commands;

import Layer1.Entity.*;
import Layer4.Interface.*;
import Layer1.Entity.User;
import Layer2.UseCases.UserUsesCases;
import Layer4.Interface.csvInterface;
import Layer2.UseCases.*;
import Model.Request.UserRequestModel;
import Model.Response.UserResponseModel;

import java.io.*;
import java.util.*;

/**
 * The CLI is the ggregate of all the commands that can be used in the program, used for testing purposes
 * In Phase 1 we test the functionality of the program by using the CLI
 */
public class CLI {
    private String username;
    private int userid;

    private final csvInterface csvInteract = new csvInterface();

    public void login() throws IOException {
        Scanner input = new Scanner(System.in);
        Map<Integer, UserRequestModel> users = csvInteract.usersReader("database/user.csv");
        UserUsesCases userManager = new UserUsesCases(users);
        boolean flag = true;
        boolean exit = false;
        while (flag) {
            String userInput = input.nextLine();
            String[] userInputs = userInput.split("-");
            switch (userInputs[0]) {
                case "/login ":
                    if (userInputs.length == 3) {
                        UserResponseModel user = userManager.verifyUser(userInputs[1], userInputs[2]);
                        if (user != null) {
                            userid = (int) user.get().get(0);
                            username = userInputs[1];
                            flag = false;
                        } else {
                            System.out.println("user not found, please register");
                        }
                    }
                    break;
                case "/register ":
                    if (userInputs.length == 3) {
                        userid = userManager.addUser(userInputs[1], userInputs[2]);
                        if (userid != -1) {
//                            csvInteract.usersWriter(users, "database/user.csv");
//                            username = userInputs[1];
//                            flag = false;
                        }
                    }
                    break;
                case "/exit ":

                    flag = false;
                    exit = true;

                    break;
                default:
                    System.out.println("unknown command");
                    break;
            }

        }
        if (!exit) {
            generalInterface();
        }
    }


    public void generalInterface() throws IOException {
        Scanner input = new Scanner(System.in);
        csvInterface csvInteract = new csvInterface();
        boolean flag = true;
        while (flag) {
            System.out.print(username + " ");
            String userInput = input.nextLine();
            String[] userInputs = userInput.split("-");
            switch (userInputs[0]) {
                case "/post ":
                    new PostCommand(userInputs, userid).exact();
                    break;
                case "/friends":
                case "/friend":
                    new FriendsCommand(userInputs, userid).exact();
                    break;
                case "/exit":
                    flag = false;
                    break;
                case "/comment":
                    new CommentCommand(userInputs, userid).exact();
                    break;
                case "/chat":
                    new ChatCommand(userInputs, userid).exact();
                    break;
                case "/help":
                    new HelpCommand(userInputs, userid).exact();
                    break;
                case "/topic":
                    new TopicCommand(userInputs, userid).exact();
                    break;
                case "":
                    System.out.print("");
                    break;
                default:
                    System.out.println("unknown command");
                    break;
            }
        }
    }



    public static void main(String[] args) throws IOException {
        CLI test = new CLI();
        test.login();
    }

}
