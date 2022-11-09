package Layer3.Controller;

import Layer1.Entity.Chat;
import Layer1.Entity.User;
import Layer2.UseCases.ChatUseCases;
import Layer4.Interface.csvInterface;

import java.io.IOException;
import java.util.Map;

/**
 * <p>The ChatController has one method addChat that add the inputted {@link Chat Chat} to the csv file.</p>
 * @Author: DominicGu
 */

public class ChatController {
    public void addChat(int userid, int receiver_id, String text) throws IOException {
        csvInterface csvInteract = new csvInterface();
        Map<Integer, User> users = csvInteract.usersReader("database/user.csv");
        Map<Integer, Chat> chats = csvInteract.chatsReader("database/chat.csv");
        ChatUseCases chatManager = new ChatUseCases(chats);
        chatManager.addChat(userid, receiver_id, text);
        csvInteract.chatsWriter(chats, "database/chat.csv");
    }
}
