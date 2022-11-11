package Layer3.Presenter;

import Layer4.Interface.csvInterface;
import Model.Request.ChatRequestModel;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * <p>The ChatPresenter has one method presentMessages that show the latest 10 {@link Layer1.Entity.Chat Chat}
 * between two user with id inputted.</p>
 * @Author: Jiahao Gu
 */

public class ChatPresenter {
    /**
     * Show the latest 10 chat between two user with id inputted.
     */
    public Object[] presentMessages(int userid, int receiverId) throws IOException {
//        csvInterface csvInteract = new csvInterface();
//        Map<Integer, ChatRequestModel> chats = csvInteract.chatsReader("database/chat.csv");
//
//        List<Chat> chatlist = new ArrayList<>();
//        for (int id : chats.keySet()) {
//            if (chats.get(id).getSender_id() == userid && chats.get(id).getReceiver_id() == receiverId ||
//                    chats.get(id).getSender_id() == receiverId && chats.get(id).getReceiver_id() == userid) {
//                chatlist.add(chats.get(id));
//            }
//        }
//        Collections.reverse(chatlist);
//        return chatlist.toArray();
        return null;
    }
}
