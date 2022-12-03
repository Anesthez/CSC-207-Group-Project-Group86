package useCases;


import entity.Post;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class LikePostsUserCase {


    /**<p>This is the like post method, which will leaves a like </p>
     *
     * @param userid the id of the user
     * @param post_id the id of the post
     * @param posts the hashmap of where all posts stores
     * @param posts_liked the hashmap of where all posts liked by users stores
     */

    public void like_posts(int userid, int post_id, HashMap<Integer, Post> posts,
                           Map<Integer, ArrayList<Integer>> posts_liked) {
        posts.get(post_id).addUserLike(userid);
        posts_liked.get(post_id).add(userid);
    }
}
