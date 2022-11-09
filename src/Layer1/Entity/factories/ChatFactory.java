package Layer1.Entity.factories;

import Layer1.Entity.Chat;
import Layer1.Entity.inputboundary.Context;

/**
 * <p>The ChatFactory is a factory that create a {@link Chat Chat} object.</p>
 *
 * <p>To initialize the ChatFactory, we need the chat id, id of both the sender and receiver, the content of the chat
 * and the time the chat is sent</p>
 * @Author: Yufei Chen
 */

public class ChatFactory {
    public Chat create(int id, int user1_id, int user2_id, String content, String timestamp){
        return new Chat(id, user1_id, user2_id, content, timestamp);
    }
}
