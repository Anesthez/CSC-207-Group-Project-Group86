package model.response;

import model.ResponseModel;

import java.util.ArrayList;

/**
 * <p>This class is responsible for creating a response model for a post.</p>
 *
 * @author: yufeichen
 */

public class PostResponseModel implements ResponseModel {
    private final int id;
    private final String content;
    private final String timestamp;
    public String postTitle;
    private final int userId;
    private final ArrayList<Integer> list_comment_id;
    private int views;
    private int numLikes;

    private String Topic;

    //private String TopicName;
    private final ArrayList<Integer> userLiked;


    public PostResponseModel(String postTitle, int userId, int id, String content, String timestamp,
                             int views, int numLikes, ArrayList<Integer> userLiked, ArrayList<Integer> list_comment_id,
                             String Topic) {
        this.postTitle = postTitle;
        this.userId = userId;
        this.id = id;
        this.content = content;
        this.timestamp = timestamp;
        this.views = views;
        this.numLikes = numLikes;
        this.userLiked = userLiked;
        this.list_comment_id = list_comment_id;
        this.Topic = Topic;
    }
    @Override
    public ArrayList<Object> get() {
        ArrayList<Object> contents = new ArrayList<>();
        contents.add(postTitle);
        contents.add(userId);
        contents.add(id);
        contents.add(content);
        contents.add(timestamp);
        contents.add(views);
        contents.add(numLikes);
        contents.add(userLiked);
        contents.add(list_comment_id);
        contents.add(Topic);
        return contents;
    }
}
