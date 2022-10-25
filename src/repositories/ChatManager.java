package repositories;

import Entity.Chat;
import Entity.Comment;
import Entity.User;
import Interface.csvInterface;

import java.io.IOException;
import java.lang.reflect.Array;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Author: Dominic Gu
 * Modified by: yufei Chen
 */

public class ChatManager {

    private final Map<Integer, Chat> chats;

    public ChatManager(Map<Integer, Chat> chats) throws IOException {
        this.chats = chats;
    }

    public void addChat(int user_id1, int user_id2, String content)
    {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd hh:mm:ss");
        Chat chat = new Chat(chats.keySet().size() + 1, user_id1, user_id2,
                content, LocalDateTime.now().format(formatter));
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

    public int getIdByUserAndTime(int sender, int receiver, String timestamp){
        for (int id: chats.keySet()){
            if (chats.get(id).getSender_id() == sender && chats.get(id).getReceiver_id() == receiver &&
                    chats.get(id).getTime().equals(timestamp)){
                return id;
            }
        }
        return 0;
    }

}
