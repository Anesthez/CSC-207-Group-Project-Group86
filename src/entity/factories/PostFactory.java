package entity.factories;

import entity.Post;
import model.request.PostRequestModel;

import java.util.ArrayList;

/**
 * A factory for creating Post objects.
 *
 * @Author: Yufei Chen
 */
public class PostFactory {
    /**The method that will create a post object from the post model.
     *
     * @param postModel the post model
     * @return post object with postTitle, userId, id, content, timestamp, views, numLikes, list_user_id, list_comment_id, topic
     */
    public Post create(PostRequestModel postModel){
        ArrayList<Object> postContents = postModel.get();
        return new Post((String)postContents.get(0),
                (int)postContents.get(1),
                (int)postContents.get(2),
                (String)postContents.get(3),
                (String)postContents.get(4),
                (int)postContents.get(5),
                (int)postContents.get(6),
                (ArrayList<Integer>)postContents.get(7),
                (ArrayList<Integer>)postContents.get(8),
                (String)postContents.get(9));

    }
}
