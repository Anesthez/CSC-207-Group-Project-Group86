package Layer1.Entity.factories;

import Layer1.Entity.Post;

import java.util.ArrayList;

public class PostFactory {
    public Post create(String postTitle, int userId, int id, String content, String timestamp,
                       int views, int numLikes,ArrayList<Integer>list_user_id,
                       ArrayList<Integer> list_comment_id){
        return new Post(postTitle, userId, id, content, timestamp, views, numLikes, list_user_id, list_comment_id);
    }
}
