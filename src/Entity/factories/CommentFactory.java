package Entity.factories;

import Entity.Comment;

public class CommentFactory {
    public Comment creat(int userId, int id, String content, String timestamp){
        return new Comment(userId, id, content, timestamp);
    }
}
