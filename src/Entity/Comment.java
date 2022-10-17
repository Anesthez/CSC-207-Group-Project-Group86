package Entity;

import inputboundary.Postable;
import inputboundary.Searchable;
import inputboundary.Timeable;

/**
 * Author: LemengDai
 * Modified by: Yufei Chen
 */
public class Comment implements Postable, Searchable, Timeable {
    private final int userId;
    private final String timestamp;
    private final int id;
    private final String content;
    private int views;

    public Comment(int userId, int id, String content, String timestamp) {
        this.userId = userId;
        this.timestamp = timestamp;  // initialize the timestamp with system time
        this.id = id;
        this.content = content;
        this.views = 0;  // initialize comment with 0 views
    }

    public int getUserId() {
        return userId;
    }

    public String getTime() {
        return timestamp;
    }

    public int getId() {
        return this.id;
    }

    public String getContent() {
        return content;
    }

    public int getViews() {
        return views;
    }

    public void setViews(int views){ this.views = views;}
}