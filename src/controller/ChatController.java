package controller;

import useCases.AddChatUseCase;
import useCases.UseCaseFacade.ChatUseCasesFacade;
import databaseInterface.CsvInterface;
import model.request.ChatRequestModel;
import useCases.DeleteChatUseCase;
import useCases.GetChatUseCase;

import java.io.IOException;
import java.util.Map;

/**
 * <p>This class is responsible for adding a new chat to the chat list.</p>
 *
 * @author: DominicGu
 */

public class ChatController {
    public void addChat(int userid, int receiver_id, String text) throws IOException {
        CsvInterface csvInteract = new CsvInterface();
        Map<Integer, ChatRequestModel> chats = csvInteract.chatsReader("database/chat.csv");
        ChatUseCasesFacade chatManager = new ChatUseCasesFacade(chats);
        chatManager.addChat(userid, receiver_id, text);
        csvInteract.chatsWriter(chatManager.getChats(), "database/chat.csv");
    }
}
