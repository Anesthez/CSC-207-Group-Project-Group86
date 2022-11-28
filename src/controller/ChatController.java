package controller;

import useCases.ChatUseCases;
import databaseInterface.csvInterface;
import model.request.ChatRequestModel;

import java.io.IOException;
import java.util.Map;

public class ChatController {
    public void addChat(int userid, int receiver_id, String text) throws IOException {
        csvInterface csvInteract = new csvInterface();
        Map<Integer, ChatRequestModel> chats = csvInteract.chatsReader("database/chat.csv");
        ChatUseCases chatManager = new ChatUseCases(chats);
        chatManager.addChat(userid, receiver_id, text);
        csvInteract.chatsWriter(chatManager.getChats(), "database/chat.csv");
    }
}
