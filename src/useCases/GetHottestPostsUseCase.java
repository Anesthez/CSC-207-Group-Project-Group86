package useCases;

import entity.Post;
import entity.inputboundary.Modelizable;
import entity.inputboundary.Populable;
import gateways.Popularity_rank;
import model.response.PostResponseModel;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GetHottestPostsUseCase implements Popularity_rank {


    public List<PostResponseModel> getHottestPosts(int post_num, HashMap<Integer, Post> posts) {
        HashMap<Integer, Populable> pop_posts= new HashMap<>();
        for (Post post : posts.values()) {
            pop_posts.put(post.getId(), post);
        }
        ArrayList<Modelizable> ranked_post = rank_by_popularity(pop_posts);
        List<PostResponseModel> hotPosts = new ArrayList<>();
        int remaining = post_num;
        int i = 0;
        while (remaining > 0 && i < ranked_post.size()) {
            hotPosts.add((PostResponseModel) ranked_post.get(i).responseModel());
            remaining -= 1;
        }
        return hotPosts;
    }

    public List<PostResponseModel> getHottestPosts(HashMap<Integer, Post> posts) {
        // Method overload for getHottestPost with default post_num = 3
        return getHottestPosts(3, posts);
    }
}
