package Layer2.UseCases;

import Layer1.Entity.Post;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Map;

/**
 * Author: eric-qli
 * modified by: Yufei Chen
 */
public class PostUseCases {
    private final Map<Integer, Post> posts;
    private final Map<Integer, ArrayList<Integer>> posts_liked;

    public PostUseCases(Map<Integer, Post> posts, Map<Integer, ArrayList<Integer>> posts_liked){
        this.posts = posts;
        this.posts_liked = posts_liked;
    }

    /**
     * @param postTitle the post title to be set
     * @param userId the user id
     * @param content the content of the post
     * add a new post
     */
    public void addPost(String postTitle, int userId, String content){
        Post post = new Post(postTitle,
                userId,
                posts.keySet().size() + 1,
                content,
                LocalDate.now().toString(),
                0,
                0,
                new ArrayList<>(),
                new ArrayList<>());

        posts.put(post.getId(), post);
    }

    /**
     * @param postId the post id
     *
     * @return the post id
     */
    public Post getPostFromId(int postId){
        /**
         * pull from the csv file
         */
        return posts.get(postId);
    }

    /**
     * @param postId the post id
     * @param comment_id the comment id
     * add the new comment to the post
     */
    public void addComment_id(int postId, int comment_id){
        /**
         * idk from where but this is easy and will come back to it
         */
        posts.get(postId).addListComment(comment_id);
    }

    /**
     * @param postId the post id
     * @param comment_id the comment id
     * edit the comment from the post
     */
    public void deleteComment(int postId, int comment_id){
        /**
         * same as addComment
         */
        posts.get(postId).removeListComment(comment_id);
    }

    public Post searchPost(){
        return null;
    }

    /**
     * @param post_id the post id
     * @param user_id the user id
     * like the post
     * add user to the list of users who liked the post
     */
    public void like_posts(int user_id, int post_id){
        posts.get(post_id).addUserLike(user_id);
        posts_liked.get(user_id).add(post_id);
    }

    /**
     * @param post_id the post id
     * @param user_id the user id
     * unlike the post
     * remove user from the list of users who liked the post
     */
    public void unlike_posts(int post_id, int user_id){
        posts.get(post_id).removeUserLike(user_id);
        posts_liked.get(user_id).remove(post_id);
    }

    /**
     * @param post_id the post id
     * @return the information of the post
     */
    public String showPost(int post_id){
        getPostFromId(post_id).addViews();
        Post post = getPostFromId(post_id);
        return ("time:" + post.getTime() +"\n"+
                "content:" + post.getContent() + "\n" +
                "id:" + post.getId() + "\n" +
                "sender:" + post.getUserId());
    }

    /**
     * @param post_id the post id
     * @param user_id the user id
     * @param title the title of the post
     * @return if title is successfully changed
     */
    public boolean changeTitle(int user_id, String title, int post_id){
        if (posts.get(post_id).getUserId() == user_id) {
            posts.get(post_id).setPostTitle(title);
            return true;
        }else{
            return false;
        }
    }
}
