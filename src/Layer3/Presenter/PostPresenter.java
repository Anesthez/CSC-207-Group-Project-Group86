package Layer3.Presenter;
import Layer1.Entity.Post;
import Layer2.UseCases.PostUseCases;
import Layer4.Interface.csvInterface;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

public class PostPresenter {

    Map<Integer, Post> posts;
    Map<Integer, ArrayList<Integer>> postLiked;
    PostUseCases postManager;

    public PostPresenter() throws IOException {
        csvInterface csvInterface = new csvInterface();
        posts = csvInterface.postsReader("database/post.csv");
        postLiked = csvInterface.postsLikedReader("database/post.csv");
        postManager = new PostUseCases(posts, postLiked);
    }

    public PostUseCases getManager() {
        return postManager;
    }
}
