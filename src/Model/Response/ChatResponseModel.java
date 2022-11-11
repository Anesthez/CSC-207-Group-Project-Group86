package Model.Response;

import Model.Model;

import java.util.ArrayList;

public class ChatResponseModel implements Model {
    /**
     * Author: LemengDai
     * Modified by: Yufei Chen, LemengDai
     */
    private final int id;
    private final int user1_id;

    private final int user2_id;

    public String content;
    public String timestamp;
    public ChatResponseModel(int id, int user1_id, int user2_id, String content, String timestamp) {
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
