package Entity;

import inputboundary.Postable;
import inputboundary.Searchable;
import inputboundary.Timeable;
import inputboundary.Context;

/**
 * Author: LemengDai
 * Modified by: Yufei Chen, LemengDai
 */
public class Comment extends Context {
    private final int userId;
    private int views;

    public Comment(int userId, int id, String content, String timestamp) {
        super(id, content, timestamp);
        this.userId = userId;
        this.views = 0;  // initialize comment with 0 views
    }

    public int getUserId() {
        return userId;
    }

    public int getViews() {
        return views;
    }

    public void setViews(int views){ this.views = views;}
}