package useCases;

import entity.Post;
import useCases.GetPostFromIdUseCase;
import entity.factories.PostFactory;
import entity.inputboundary.Modelizable;
import entity.inputboundary.Populable;
import gateways.Popularity_rank;
import model.request.PostRequestModel;
import model.response.PostResponseModel;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GetHottestPostsUseCase {
    private final RankByPopularity rankByPopularity;


    public List<PostResponseModel> getHottestPosts(int post_num, HashMap<Integer, Post> posts) {
        HashMap<Integer, Populable> pop_posts= new HashMap<>();
        for (Post post : posts.values()) {
            pop_posts.put(post.getId(), post);
        }
        ArrayList<Modelizable> ranked_post = Popularity_rank.rank_by_popularity(pop_posts);
        List<PostResponseModel> hotPosts = new ArrayList<>();
        int remaining = post_num;
        int i = 0;
        while (remaining > 0 && i < ranked_post.size()) {
            hotPosts.add((PostResponseModel) ranked_post.get(i).responseModel());
            remaining -= 1;
        }
        return hotPosts;
    }

    public List<PostResponseModel> getHottestPosts() {
        // Method overload for getHottestPost with default post_num = 3
        return getHottestPosts(3);
    }
}
