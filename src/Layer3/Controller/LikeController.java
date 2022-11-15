package Layer3.Controller;

import Layer2.UseCases.PostUseCases;
import Layer4.Interface.csvInterface;
import Model.Request.PostRequestModel;
import Model.Response.PostResponseModel;

import java.util.ArrayList;
import java.util.Map;

public class LikeController {

    public void likePost(int postId, int userId) throws Exception {
        csvInterface csvInterface = new csvInterface();
        Map<Integer, PostRequestModel> posts = csvInterface.postsReader("database/posts.csv");
        Map<Integer, ArrayList<Integer>> postsLiked = csvInterface.postsLikedReader("database/posts_liked.csv");
        PostUseCases postManager = new PostUseCases(posts, postsLiked);
        postManager.like_posts(postId, userId);
//        csvInterface.postsWriter("database/posts.csv", posts);
        csvInterface.postsLikedWriter("database/posts_liked.csv", postsLiked);
    }
}
