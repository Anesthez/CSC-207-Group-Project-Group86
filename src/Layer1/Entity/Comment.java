package Layer1.Entity;

import Layer1.Entity.inputboundary.Context;
import Model.Request.CommentRequestModel;

/**
 * <p>The comment object is a comment that will be sent by the user. The object is a subclass for context which will
 * extend the properties for the {@link Context Context}
 * </p>
 *
 * <p>To initialize a comment object, we need userid, the id of the post, content and the time for the post
 * </p>
 *
 * @implNote the user id for the class is not to be altered, thus set as final.
 * @Author: LemengDai
 * @Modifiedby: Yufei Chen, LemengDai
 */
public class Comment extends Context {
    private final int userId;

    /**
     * <p>initialize a Comment object userid, the id of the post, content and the time for the post</p>
     * @param userId
     * @param id
     * @param content
     * @param timestamp
     */
    public Comment(int userId, int id, String content, String timestamp) {
        super(id, content, timestamp);
        this.userId = userId;
    }

    public int getUserId() {
        return userId;
    }

    @Override
    public CommentRequestModel responseModel() {
        return new CommentRequestModel(this.getId(), this.getUserId(), this.getContent(), this.getTime());
    }
}