package Layer1.Entity.factories;

import Layer1.Entity.Comment;


public class CommentFactory {
    /**
     *<p>CommentFactory is a factory used to create {@link Comment Comment} object.</p>
     * @param userId
     * @param id
     * @param content
     * @param timestamp
     * @return comment object with userId, id, content and timestamp
     */
    public Comment create(int userId, int id, String content, String timestamp){
        return new Comment(userId, id, content, timestamp);
    }
}
