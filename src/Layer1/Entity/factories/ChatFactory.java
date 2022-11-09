package Layer1.Entity.factories;

import Layer1.Entity.Chat;
import Layer1.Entity.inputboundary.Context;

/**
 * <p>The ChatFactory is a factory that create a {@link Chat Chat} object.</p>
 *
 * <p>To create a chat object, we need the chat id, id of both the sender and receiver, the content of the chat
 * and the time the chat is sent</p>
 * @Author: Yufei Chen
 */

public class ChatFactory {
    /**
     * <p>Constructor for the ChatFactory. It takes in the chat id, id of both the sender and receiver, the content of the chat
     * and the time the chat is sent.</p>
     *
     * @param id the id of the chat
     * @param user1_id the id of the user that sent the chat
     * @param user2_id the id of the user that received the chat
     * @param content the content of the chat
     * @param timestamp the time that the chat is sent
     * @return chat object with id, user1_id, user2_id, content and timestamp
     */
    public Chat create(int id, int user1_id, int user2_id, String content, String timestamp){
        return new Chat(id, user1_id, user2_id, content, timestamp);
    }
}
