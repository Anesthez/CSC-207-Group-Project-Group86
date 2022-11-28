package presenter;

import useCases.ChatUseCases;
import databaseInterface.csvInterface;
import model.request.ChatRequestModel;
import model.response.ChatResponseModel;
import entity.Chat;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * <p>The ChatPresenter has one method presentMessages that show the latest 10 {@link Chat Chat}
 * between two user with id inputted.</p>
 * @Author: Jiahao Gu
 */

public class ChatPresenter {
    /**
     * Show the latest 10 chat between two user with id inputted.
     */
    public Object[] presentMessages(int userid, int receiverId) throws IOException {
        csvInterface csvInteract = new csvInterface();
        Map<Integer, ChatRequestModel> chats = csvInteract.chatsReader("database/chat.csv");
        ChatUseCases chatManager = new ChatUseCases(chats);
        Map<Integer, ChatResponseModel> chatResponseModels = chatManager.getChats();
        List<ChatResponseModel> chatlist = new ArrayList<>();
        for (int id : chats.keySet()) {
            if (chatResponseModels.get(id).get().get(1).equals(userid) &&
                    chatResponseModels.get(id).get().get(2).equals(receiverId) ||
                    chatResponseModels.get(id).get().get(1).equals(receiverId) &&
                            chatResponseModels.get(id).get().get(2).equals(userid)) {
                chatlist.add(chatResponseModels.get(id));
            }
        }
        Collections.reverse(chatlist);
        return chatlist.toArray();
    }
}
