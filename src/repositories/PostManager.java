package repositories;

import Entity.Comment;
import Entity.Post;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Map;

/**
 * Author: eric-qli
 * modified by: Yufei Chen
 */
public class PostManager {
    private final Map<Integer, Post> posts;
    private final Map<Integer, ArrayList<Integer>> posts_liked;

    public PostManager(Map<Integer, Post> posts, Map<Integer, ArrayList<Integer>> posts_liked){
        this.posts = posts;
        this.posts_liked = posts_liked;
    }
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

    public Post getPostFromId(int postId){
        /**
         * pull from the csv file
         */
        return posts.get(postId);
    }

    public void addComment_id(int postId, int comment_id){
        /**
         * idk from where but this is easy and will come back to it
         */
        posts.get(postId).addListComment(comment_id);
    }

    public void deleteComment(int postId, int comment_id){
        /**
         * same as addComment
         */
        posts.get(postId).removeListComment(comment_id);
    }

    public Post searchPost(){
        return null;
    }

    public void like_posts(int userid, int post_id){
        posts.get(post_id).addUserLike(userid);
        posts_liked.get(userid).add(post_id);
    }

    public void unlike_posts(int post_id, int user_id){
        posts.get(post_id).removeUserLike(user_id);
        posts_liked.get(user_id).remove(post_id);
    }

    public String showPost(int post_id){
        posts.get(post_id).addViews();
        return posts.get(post_id).getContent();
    }

    public boolean changeTitle(int user_id, String title, int post_id){
        if (posts.get(post_id).getUserId() == user_id) {
            posts.get(post_id).setPostTitle(title);
            return true;
        }else{
            return false;
        }
    }

    /**
     * questions:
     * 1. how to storage comment
     * 2. delete by comment or commentid
     * 3. delete from the file or hide from the post
     * 4. if this blog is text based then there should be a title for each post
     * 5. search method: search engine? search by post id? should id be private?
     *
     */
}
