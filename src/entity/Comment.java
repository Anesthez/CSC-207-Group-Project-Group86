package entity;

import entity.inputboundary.Context;
import model.response.CommentResponseModel;

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
    private final int postId;

    /**
     * <p>initialize a Comment object userid, the id of the post, content and the time for the post</p>
     * @param userId the id of the user
     * @param id the id of the comment
     * @param content the content of the comment
     * @param timestamp the timestamp of the comment
     * @param postId the id of the post
     */
    public Comment(int userId, int id, String content, String timestamp, int postId) {
        super(id, content, timestamp);
        this.userId = userId;
        this.postId = postId;
    }

    public int getUserId() {
        return userId;
    }
    public int getPostId() {
        return postId;
    }

    @Override
    public CommentResponseModel responseModel() {
        return new CommentResponseModel(this.getUserId(), this.getId(), this.getContent(), this.getTime(), this.getPostId());
    }
}