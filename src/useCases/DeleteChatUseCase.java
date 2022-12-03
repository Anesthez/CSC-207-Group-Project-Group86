package useCases;

import entity.Chat;

import java.util.Map;

/**
 * <p>This class is responsible for deleting a chat from the chat list.</p>
 *
 * @author: DominicGu
 */

public class DeleteChatUseCase {
    public void deleteChat(int id, Map<Integer, Chat> chats)
    {
        chats.remove(id);

    }
}
