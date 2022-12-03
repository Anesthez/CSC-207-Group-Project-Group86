package useCases;

import entity.Chat;

import java.util.Map;

public class DeleteChatUseCase {
    public void deleteChat(int id, Map<Integer, Chat> chats)
    {
        chats.remove(id);

    }
}
