package useCases;


import entity.Post;
import java.util.HashMap;

public class GetPostFromIdUseCase {

    /** <p>This represents the get post use case, the method receives the id the user want to check and returns the
     * corresponding post</p>
     *
     * @param id the id of the post
     * @param posts the hashmap of where all posts stores
     * @return Post
     */

    public Post getPostFromId(int id, HashMap<Integer, Post> posts) {
        return posts.get(id);
    }
}