package useCases;

import entity.Post;
import java.util.HashMap;

public class AddCommentIdUseCase {

    /**<p>This is the add comment use case, the method will ad the id of the comment to the list comments with in the
     * post object</p>
     *
     * @param postId the id of the post
     * @param comment_id  the id of the comment
     * @param posts the hashmap of where all posts stores
     */

    public void addComment_id(int postId, int comment_id, HashMap<Integer, Post> posts) {

        posts.get(postId).addListComment(comment_id);
    }
}
