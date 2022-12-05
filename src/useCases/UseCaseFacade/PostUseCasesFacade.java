package useCases.UseCaseFacade;

import entity.Post;
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

/**<p>This is the post use cases class such that each method will manage one use case of our project, The class will
 * require the maps of the posts and the posts_liked files to initialize and manages the list of posts that it contains
 * {@link Post Post}</p>
 *
 * @Author: eric-qli
 * @Modified by: Yufei Chen, Tianyu Li, Chen Jiang
 */
public class PostUseCasesFacade implements Popularity_rank {
    private final HashMap<Integer, Post> posts = new HashMap<>();
    private final Map<Integer, ArrayList<Integer>> posts_liked;

    /**<p>This is the constructor for the PostUseCases class, it needs the posts and the posts_liked list </p>
     *
     * @param posts the map of posts
     * @param posts_liked  the map of post_id to the list of the userid who liked the post
     */
    public PostUseCasesFacade(Map<Integer, PostRequestModel> posts, Map<Integer, ArrayList<Integer>> posts_liked){
        PostFactory postFactory = new PostFactory();
        for (PostRequestModel requestModel : posts.values()) {
            Post post = postFactory.create(requestModel);
            this.posts.put(post.getId(), post);
        }
        this.posts_liked = posts_liked;
    }


    /**<p>This method is the add post use case, the method receives userId, content, topic of the post and then
     * construct a post object for it.</p>
     *
     * @param postTitle the title of the post
     * @param userId the id of the user
     * @param content the content of the post
     * @param topic the topic of the post
     */
    public int addPost(String postTitle, int userId, String content, String topic){
        Post post = new Post(postTitle,
                userId,
                posts.keySet().size() + 1,
                content,
                LocalDate.now().toString(),
                0,
                0,
                new ArrayList<>(),
                new ArrayList<>(),topic);

        posts.put(post.getId(), post);
        return post.getId();
    }

    /** <p>This represents the get post use case, the method receives the id the user want to check and returns the
     * corresponding post</p>
     *
     * @param postId the id of the post
     * @return Post
     */
    public Post getPostFromId(int postId){
        return posts.get(postId);
    }

    /**<p>This is the add comment use case, the method will ad the id of the comment to the list comments with in the
     * post object</p>
     *
     * @param postId the id of the post
     * @param comment_id  the id of the comment
     */

    public void addComment_id(int postId, int comment_id){

        posts.get(postId).addListComment(comment_id);
    }



    /**<p>This is the like post method, which will leaves a like </p>
     *
     * @param userid the id of the user
     * @param post_id the id of the post
     */

    public void like_posts(int userid, int post_id){
        posts.get(post_id).addUserLike(userid);
        posts_liked.get(post_id).add(userid);
    }


    public String showPost(int post_id){
        getPostFromId(post_id).addViews();
        Post post = getPostFromId(post_id);
        return ("time:" + post.getTime() +"\n"+
                "content:" + post.getContent() + "\n" +
                "id:" + post.getId() + "\n" +
                "sender:" + post.getUserId());
    }

    public ArrayList<Object> getDetails(int post_id){
        ArrayList<Object> details = new ArrayList<>();
        Post post = getPostFromId(post_id);
        details.add(post.getPostTitle());
        details.add(post.getId());
        details.add(post.getTime());
        details.add(post.getNumLikes());
        details.add(post.getContent());

        return details;
    }



    /**
     * @param post_num: the
     * @return post_num amount of the hottest post ranked by popularity.
     */
    public List<PostResponseModel> getHottestPosts(int post_num) {
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
            i += 1;
        }
        return hotPosts;
    }


    public List<PostResponseModel> getHottestPosts() {
        // Method overload for getHottestPost with default post_num = 3
        return getHottestPosts(3);
    }

    public Map<Integer, PostResponseModel> getPostsResponseModel() {
        Map<Integer, PostResponseModel> PostResponseModel = new HashMap<>();
        for (Integer i : this.posts.keySet()) {
            PostResponseModel.put(i, posts.get(i).responseModel());
        }
        return PostResponseModel;
    }

}
