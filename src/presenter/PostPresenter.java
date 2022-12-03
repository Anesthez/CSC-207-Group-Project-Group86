package presenter;
import useCases.UseCaseFacade.PostUseCasesFacade;
import databaseInterface.CsvInterface;
import model.request.PostRequestModel;
import model.response.PostResponseModel;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

/**
 * <p>The PostPresenter has one method presentPosts that show the latest 10 {@link Post Post}
 * posted by a user with id inputted.</p>
 *
 * @Author: Yufeichen, DominicGu, StarryDust-02
 */

public class PostPresenter {

    Map<Integer, PostRequestModel> posts;
    Map<Integer, ArrayList<Integer>> postLiked;
    PostUseCasesFacade postManager;

    public PostPresenter() throws IOException {
        CsvInterface csvInterface = new CsvInterface();
        posts = csvInterface.postsReader("database/post.csv");
        postLiked = csvInterface.postsLikedReader("database/post_liked.csv");
        postManager = new PostUseCasesFacade(posts, postLiked);
    }

    public ArrayList<Object> showPost(int postId) {
        return postManager.getDetails(postId);
    }

    public Map<Integer, PostResponseModel> getPosts(){return postManager.getPostsResponseModel();}
}
