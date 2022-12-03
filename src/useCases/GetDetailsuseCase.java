package useCases;

import entity.Post;
import java.util.ArrayList;
import java.util.HashMap;

public class GetDetailsuseCase {

private final GetPostFromIdUseCase getPostFromIdUseCase;

    public GetDetailsuseCase() {
        this.getPostFromIdUseCase = new GetPostFromIdUseCase();
    }

    public ArrayList<Object> getDetails(int post_id, HashMap<Integer, Post> posts) {
        ArrayList<Object> details = new ArrayList<>();
        Post post = getPostFromIdUseCase.getPostFromId(post_id, posts);
        details.add(post.getPostTitle());
        details.add(post.getId());
        details.add(post.getTime());
        details.add(post.getNumLikes());
        details.add(post.getContent());

        return details;
    }
}
