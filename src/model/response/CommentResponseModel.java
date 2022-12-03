package model.response;

import model.ResponseModel;

import java.util.ArrayList;

public class CommentResponseModel implements ResponseModel {
    private final int id;

    private final int userId;

    private String content;
    private String timestamp;

    private final int postId;

    public CommentResponseModel(int userId, int id, String content, String timestamp, int postId) {
        this.userId = userId;
        this.id = id;
        this.content = content;
        this.timestamp = timestamp;
        this.postId = postId;
    }

    public ArrayList<Object> get(){
        ArrayList<Object> contents = new ArrayList<>();
        contents.add(userId);
        contents.add(id);
        contents.add(content);
        contents.add(timestamp);
        contents.add(postId);
        return contents;
    }
}
