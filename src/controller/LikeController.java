package controller;

import useCases.PostUseCases;
import databaseInterface.CsvInterface;
import model.request.PostRequestModel;

import java.util.ArrayList;
import java.util.Map;

public class LikeController {

    public void likePost(int postId, int userId) throws Exception {
        CsvInterface csvInterface = new CsvInterface();
        Map<Integer, PostRequestModel> posts = csvInterface.postsReader("database/post.csv");
        Map<Integer, ArrayList<Integer>> postsLiked = csvInterface.postsLikedReader("database/post_liked.csv");
        PostUseCases postManager = new PostUseCases(posts, postsLiked);
        postManager.like_posts(userId, postId);
        csvInterface.postsWriter("database/post.csv", postManager.getPostsResponseModel());
        csvInterface.postsLikedWriter("database/post_liked.csv", postsLiked);
    }
}
