package useCases;

import entity.Post;
import model.response.PostResponseModel;

import java.util.HashMap;
import java.util.Map;

public class GetPostsResponseModelUseCase {
    public Map<Integer, PostResponseModel> getPostsResponseModel(HashMap<Integer, Post> posts) {
        Map<Integer, PostResponseModel> PostResponseModel = new HashMap<>();
        for (Integer i : posts.keySet()) {
            PostResponseModel.put(i, posts.get(i).responseModel());
        }
        return PostResponseModel;
    }
}
