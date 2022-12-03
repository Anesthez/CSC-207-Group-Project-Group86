package useCases;

import entity.Chat;
import model.response.ChatResponseModel;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>This class is responsible for getting a chat from the chat list.</p>
 *
 * @author: DominicGu
 */

public class GetChatUseCase {
    public Map<Integer, ChatResponseModel> getChats(Map<Integer, Chat> chats) {
        Map<Integer, ChatResponseModel> chatResponseModelMap = new HashMap<>();
        for (Chat chat : chats.values()) {
            chatResponseModelMap.put(chat.getId(), chat.responseModel());
        }
        return chatResponseModelMap;
    }
}
