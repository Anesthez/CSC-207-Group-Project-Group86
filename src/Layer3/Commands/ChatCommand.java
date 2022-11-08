package Layer3.Commands;

import Layer1.Entity.Chat;
import Layer1.Entity.User;
import Layer4.Interface.csvInterface;
import Layer2.UseCases.ChatUseCases;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/*
Author: Jiahao Gu
 */
public class ChatCommand {
    String[] inputLines;
    int userid;
    public ChatCommand(String[] inputLines, int userid){
        this.inputLines = inputLines;
        this.userid = userid;
    }

    public void exact() throws IOException {
        csvInterface csvInteract = new csvInterface();
        Map<Integer, User> users = csvInteract.usersReader("database/user.csv");
        Map<Integer, Chat> chats = csvInteract.chatsReader("database/chat.csv");
        ChatUseCases chatManager = new ChatUseCases(chats);

        // use "/chat-add-receiver's id-content" to send a message
        switch (inputLines[1]) {
            case "add": {
                int receiver_id = Integer.parseInt(inputLines[2]);
                if (users.containsKey(receiver_id)) {
                    chatManager.addChat(userid, receiver_id, inputLines[3]);
                    csvInteract.chatsWriter(chats, "database/chat.csv");
                    System.out.println("message sent");
                } else {
                    System.out.println("user does not exist");
                }
            }


            // use "/chat-delete-chatid" to delete a message
            case "delete": {
                int chatid = Integer.parseInt(inputLines[2]);
                if (chats.containsKey(chatid)) {
                    chatManager.deleteChat(chatid);
                    csvInteract.chatsWriter(chats, "database/chat.csv");
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


            // use "/chat-show-receiver's id" to show all messages sent between two people
            case "show": {
                int receiver_id = Integer.parseInt(inputLines[2]);
                if (users.containsKey(receiver_id)) {
                    List<Chat> chatlist = new ArrayList<>();
                    for (int id : chats.keySet()) {
                        if (chats.get(id).getSender_id() == userid && chats.get(id).getReceiver_id() == receiver_id ||
                                chats.get(id).getSender_id() == receiver_id && chats.get(id).getReceiver_id() == userid) {
                            chatlist.add(chats.get(id));
                        }
                    }
                    if (chatlist.isEmpty()) {
                        System.out.println("No message found");
                    }
                    chatlist.sort(null);
                    for (Chat c : chatlist) {
                        c.printChat();
                    }
                } else {
                    System.out.println("user does not exist");
                }
                break;
            }
            default: System.out.println("unknown command");
        }
    }


}