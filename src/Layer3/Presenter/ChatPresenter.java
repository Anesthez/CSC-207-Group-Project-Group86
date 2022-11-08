package Layer3.Presenter;

import Layer1.Entity.Chat;
import Layer4.Interface.csvInterface;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class ChatPresenter {
    public Object[] present_messages(int userid, int receiverId) throws IOException {
        csvInterface csvInteract = new csvInterface();
        Map<Integer, Chat> chats = csvInteract.chatsReader("database/chat.csv");

        List<Chat> chatlist = new ArrayList<>();
        for (int id : chats.keySet()) {
            if (chats.get(id).getSender_id() == userid && chats.get(id).getReceiver_id() == receiverId ||
                    chats.get(id).getSender_id() == receiverId && chats.get(id).getReceiver_id() == userid) {
                chatlist.add(chats.get(id));
            }
        }
        Collections.reverse(chatlist);
        return chatlist.toArray();
    }
}
