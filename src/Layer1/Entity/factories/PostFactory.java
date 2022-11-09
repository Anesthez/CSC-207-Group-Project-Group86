package Layer1.Entity.factories;

import Layer1.Entity.Post;

import java.util.ArrayList;

/**
 * A factory for creating Post objects.
 *
 * @Author: Yufei Chen
 */
public class PostFactory {
    /**The method that will create a post object from the post model.
     *
     * @param postTitle
     * @param userId
     * @param id
     * @param content
     * @param timestamp
     * @param views
     * @param numLikes
     * @param list_user_id
     * @param list_comment_id
     * @param topic
     * @return
     */
    public Post create(String postTitle, int userId, int id, String content, String timestamp,
                       int views, int numLikes,ArrayList<Integer>list_user_id,
                       ArrayList<Integer> list_comment_id, String topic){
        return new Post(postTitle, userId, id, content, timestamp, views, numLikes, list_user_id, list_comment_id,
                topic);
    }
}
