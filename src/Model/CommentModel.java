package Model;

import java.util.ArrayList;

public class CommentModel implements Model{
    private final int id;

    private final int userId;
    private int views;

    private String content;
    private String timestamp;

    public CommentModel(int userId, int id, String content, String timestamp, int views) {
        this.userId = userId;
        this.id = id;
        this.content = content;
        this.timestamp = timestamp;
        this.views = views;  // initialize comment with 0 views
    }

    public ArrayList<Object> get(){
        ArrayList<Object> contents = new ArrayList<>();
        contents.add(userId);
        contents.add(id);
        contents.add(content);
        contents.add(timestamp);
        contents.add(views);
        return contents;
    }
}
