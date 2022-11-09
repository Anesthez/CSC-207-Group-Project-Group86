package Model;

import Layer1.Entity.Chat;

import java.util.ArrayList;

/**
 * <p>The ChatModel is a model for {@link Chat Chat}. @</p>
 * @Author: LemengDai
 * Modified by: Yufei Chen
 */

public class ChatModel implements Model {
    private final int id;
    private final int user1_id;

    private final int user2_id;

    public String content;
    public String timestamp;
    public ChatModel(int id, int user1_id, int user2_id, String content, String timestamp) {
        this.id = id;
        this.content = content;
        this.timestamp = timestamp;
        this.user1_id = user1_id;
        this.user2_id = user2_id;
    }

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
