package presenter;
import useCases.PostUseCases;
import databaseInterface.CsvInterface;
import model.request.PostRequestModel;
import model.response.PostResponseModel;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

public class PostPresenter {

    Map<Integer, PostRequestModel> posts;
    Map<Integer, ArrayList<Integer>> postLiked;
    PostUseCases postManager;

    public PostPresenter() throws IOException {
        CsvInterface csvInterface = new CsvInterface();
        posts = csvInterface.postsReader("database/post.csv");
        postLiked = csvInterface.postsLikedReader("database/post_liked.csv");
        postManager = new PostUseCases(posts, postLiked);
    }

    public ArrayList<Object> showPost(int postId) {
        return postManager.getDetails(postId);
    }

    public Map<Integer, PostResponseModel> getPosts(){return postManager.getPostsResponseModel();}
}
