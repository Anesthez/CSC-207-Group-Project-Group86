package controller;

import useCases.AddChatUseCase;
import useCases.UseCaseFacade.ChatUseCasesFacade;
import databaseInterface.CsvInterface;
import model.request.ChatRequestModel;
import useCases.DeleteChatUseCase;
import useCases.GetChatUseCase;

import java.io.IOException;
import java.util.Map;

public class ChatController {
    public void addChat(int userid, int receiver_id, String text) throws IOException {
        CsvInterface csvInteract = new CsvInterface();
        Map<Integer, ChatRequestModel> chats = csvInteract.chatsReader("database/chat.csv");
        AddChatUseCase acu = new AddChatUseCase();
        DeleteChatUseCase dcu = new DeleteChatUseCase();
        GetChatUseCase gcu = new GetChatUseCase();
        ChatUseCasesFacade chatManager = new ChatUseCasesFacade(chats,acu,dcu,gcu);
        chatManager.addChat(userid, receiver_id, text);
        csvInteract.chatsWriter(chatManager.getChats(), "database/chat.csv");
    }
}
