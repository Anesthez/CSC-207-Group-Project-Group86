package useCases;


import entity.Post;
import java.util.ArrayList;
import java.util.HashMap;

public class AddPostUseCase {

    /**<p>This method is the add post use case, the method receives userId, content, topic of the post and then
     * construct a post object for it.</p>
     *
     * @param title the title of the post
     * @param user_id the id of the user
     * @param id the id of the post
     * @param content the content of the post
     * @param timestamp the time the post is created
     * @param views the number of views of the post
     * @param numlikes the number of likes of the post
     * @param userliked the list of ids of users who liked the post
     * @param posts the hashmap of where all posts stores
     * @param comment_ids the hashmap of where all comments id stores
     * @param topic the topic of the post
     */
    public void addPost(String title, int user_id, int id,
                        String content, String timestamp,
                        int views, int numlikes, ArrayList<Integer> userliked,
                        ArrayList<Integer> comment_ids, String topic, HashMap<Integer, Post> posts) {
        Post post = new Post(title,
                user_id,
                id,
                content,
                timestamp,
                views,
                numlikes,
                userliked,
                comment_ids,
                topic);
        posts.put(post.getId(), post);
    }
}
