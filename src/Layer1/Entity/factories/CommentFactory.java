package Layer1.Entity.factories;

import Layer1.Entity.Comment;

public class CommentFactory {
    public Comment create(int userId, int id, String content, String timestamp){
        return new Comment(userId, id, content, timestamp);
    }
}
