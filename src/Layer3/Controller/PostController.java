package Layer3.Controller;


import Layer2.UseCases.PostUseCases;
import Layer4.Interface.csvInterface;
import Model.Request.PostRequestModel;
import Model.Response.PostResponseModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**

 * <p>This class contains the methods for showPostScreen, uploadPostScreen, and HotPostScreen</p>
 *
 * @author Kevin Wu, Tianyu Li
 */
public class PostController {
    /**
     * <p>Add a post object from GUI's user input to csv file</p>
     *
     * @param title the title of the post
     * @param content the content of the post
     * @param userid the id of the user
     * @param topic the topic of the post
     */
    public void addPost(String title, String content, int userid, String topic) throws Exception {
        csvInterface csvInterface = new csvInterface();
        Map<Integer, PostRequestModel> posts = csvInterface.postsReader("database/post.csv");
        Map<Integer, ArrayList<Integer>> postsLiked = csvInterface.postsLikedReader("database/post_liked.csv");
        PostUseCases postManager = new PostUseCases(posts, postsLiked);
        int postId = postManager.addPost(title, userid, content, topic);
        postsLiked.put(postId, new ArrayList<>(List.of(userid)));
        csvInterface.postsWriter("database/post.csv", postManager.getPostsResponseModel());
        csvInterface.postsLikedWriter("database/post_liked.csv", postsLiked);
    }

    public List<PostResponseModel> getThreeHottestPosts() throws Exception {
        csvInterface csvInterface = new csvInterface();
        Map<Integer, PostRequestModel> posts = csvInterface.postsReader("database/post.csv");
        Map<Integer, ArrayList<Integer>> postsLiked = csvInterface.postsLikedReader("database/post_liked.csv");
        PostUseCases postManager = new PostUseCases(posts, postsLiked);
        return postManager.getHottestPosts();
    }
}
