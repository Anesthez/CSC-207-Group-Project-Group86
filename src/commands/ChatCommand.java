package commands;

import databaseInterface.csvInterface;
import useCases.ChatUseCases;
import model.request.ChatRequestModel;
import model.request.UserRequestModel;
import entity.Chat;

import java.io.IOException;
import java.util.Map;

/**
 * <p>The ChatCommand contains a command in the form of a array of string and the id of the user that send
 * this command. To initialize it, we need the id of the user, and the command array.</p>
 *
 * <p>In the exact method, there are four command, add command send a {@link Chat Chat} to the receiver,
 * delete command remove a message sent to the receiver, showid command shows the id of a sent message, show command
 * show all message between two user.</p>
 *
 * @Author: Jiahao Gu
 * @Modifiedby: Yufei Chen
 */

public class ChatCommand {
    String[] inputLines;
    int userid;
    /**
     * <p>Constructor for the ChatCommand. It takes in the id of the user and the command array.</p>
     *
     * @param userid the id of the user
     * @param inputLines the command array
     */
    public ChatCommand(String[] inputLines, int userid){
        this.inputLines = inputLines;
        this.userid = userid;
    }

    /**
     * <p>Execute the command.</p>
     */
    public void exact() throws IOException {
        csvInterface csvInteract = new csvInterface();
        Map<Integer, UserRequestModel> users = csvInteract.usersReader("database/user.csv");
        Map<Integer, ChatRequestModel> chats = csvInteract.chatsReader("database/chat.csv");
        ChatUseCases chatManager = new ChatUseCases(chats);

        // use "/chat-add-receiver's id-content" to send a message
        switch (inputLines[1]) {
            case "add": {
                int receiver_id = Integer.parseInt(inputLines[2]);
                if (users.containsKey(receiver_id)) {
                    chatManager.addChat(userid, receiver_id, inputLines[3]);
                    csvInteract.chatsWriter(chatManager.getChats(), "database/chat.csv");
                    System.out.println("message sent");
                } else {
                    System.out.println("user does not exist");
                }
                break;
            }


            // use "/chat-delete-chatid" to delete a message
            case "delete": {
                int chatid = Integer.parseInt(inputLines[2]);
                if (chats.containsKey(chatid)) {
                    chatManager.deleteChat(chatid);
                    csvInteract.chatsWriter(chatManager.getChats(), "database/chat.csv");
                    System.out.println("message deleted");
                } else {
                    System.out.println("chat does not exist");
                }
                break;
            }


            // use "/chat-showid-receiver's id-sent time(yyyy.MM.dd hh:mm:ss)" to find the id of a message
            case "showid": {
                int chatid = chatManager.getIdByUserAndTime(userid, Integer.parseInt(inputLines[2]), inputLines[3]);
                if (chatid != 0) {
                    System.out.println("chat id is " + chatid);
                } else {
                    System.out.println("chat does not exist");
                }
                break;
            }

            default: System.out.println("unknown command");
        }
    }


}
