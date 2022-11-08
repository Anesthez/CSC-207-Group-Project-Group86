package Layer1.Entity;

import Layer1.Entity.inputboundary.Context;

/**
 * Author: LemengDai
 * Modified by: Yufei Chen, LemengDai
 */
public class Comment extends Context {
    private final int userId;


    public Comment(int userId, int id, String content, String timestamp) {
        super(id, content, timestamp);
        this.userId = userId;
    }

    public int getUserId() {
        return userId;
    }

}