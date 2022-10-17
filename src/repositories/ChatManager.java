package repositories;

import Entity.Chat;
import Entity.Comment;
import Entity.User;
import Interface.csvInterface;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Map;

/**
 * Author: Dominic Gu
 * Modified by: yufei Chen
 */

public class ChatManager {

    private Map<Integer, Chat> chats;

    public ChatManager(Map<Integer, Chat> chats) throws IOException {
        this.chats = chats;
    }

    public void addChat(int user_id1, int user_id2, String content)
    {
        Chat chat = new Chat(chats.keySet().size() + 1, user_id1, user_id2,
                content, LocalDate.now().toString());
        chats.put(chat.getId(), chat);
    }

    public void deleteChat(int id)
    {
        chats.remove(id);
    }

    public Chat getChatById(int id)
    {
        return chats.get(id);
    }


}
