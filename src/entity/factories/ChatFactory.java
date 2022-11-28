package entity.factories;

import entity.Chat;
import model.request.ChatRequestModel;

import java.util.ArrayList;

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
     * @param chatModel the chat model
     * @return chat object with id, user1_id, user2_id, content and timestamp
     */
    public Chat create(ChatRequestModel chatModel) {
        ArrayList<Object> chatContents = chatModel.get();
        return new Chat((int)chatContents.get(0)
                , (int)chatContents.get(1)
                , (int)chatContents.get(2)
                , (String)chatContents.get(3)
                , (String)chatContents.get(4));
    }
}
