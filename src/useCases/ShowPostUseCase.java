package useCases;

import entity.Post;
import java.util.HashMap;

public class ShowPostUseCase {
    private final GetPostFromIdUseCase getPostFromIdUseCase;

    public ShowPostUseCase() {
        this.getPostFromIdUseCase = new GetPostFromIdUseCase();
    }

    public String showPost(int post_id, HashMap<Integer, Post> posts) {
        getPostFromIdUseCase.getPostFromId(post_id, posts).addViews();
        Post post = getPostFromIdUseCase.getPostFromId(post_id, posts);
        return ("time:" + post.getTime() +"\n"+
                "content:" + post.getContent() + "\n" +
                "id:" + post.getId() + "\n" +
                "sender:" + post.getUserId());
    }

}
