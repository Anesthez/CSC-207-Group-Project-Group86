package Model.Request;

import Model.Model;

import Layer1.Entity.Chat;

import java.util.ArrayList;

/**
 * <p>The ChatModel is a model for {@link Chat Chat}. @</p>
 * @Author: LemengDai
 * Modified by: Yufei Chen
 */

public class ChatRequestModel implements Model {
    private final int id;
    private final int user1_id;

    private final int user2_id;

    public String content;
    public String timestamp;
    /**
     * <p>Constructor for the ChatModel. It takes in the id of the chat, the id of the user that sent it,
     * the id of the user that received it, the content of the chat and the time that the chat is sent.</p>
     *
     * @param id the id of the chat
     * @param user1_id the id of the user that sent the chat
     * @param user2_id the id of the user that received the chat
     * @param content the content of the chat
     * @param timestamp the time that the chat is sent
     */
    public ChatRequestModel(int id, int user1_id, int user2_id, String content, String timestamp) {
        this.id = id;
        this.content = content;
        this.timestamp = timestamp;
        this.user1_id = user1_id;
        this.user2_id = user2_id;
    }
    /**
     * <p>Getter for the chat.</p>
     *
     * @return the chat information in a ArrayList
     */
    public ArrayList<Object> get(){
        ArrayList<Object> contents = new ArrayList<>();
        contents.add(id);
        contents.add(user1_id);
        contents.add(user2_id);
        contents.add(content);
        contents.add(timestamp);
        return contents;
    }
}
