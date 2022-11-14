package Layer1.Entity;

import Layer1.Entity.inputboundary.Context;

import java.util.ArrayList;
/**
 * <p>The post object is a post that will be sent to by the user. The object is a subclass for context which will
 * extends the properties for the {@link Context Context}
 * </p>
 *
 * <p>To initialize a post object, we need post title, userid, the id of the post, content, the time for the post,
 * number of views, number of likes, list of views for the object, list of likes for the object</p>
 *
 * <p>The post object contains list of comments, list of the userIds of who liked the post, the number of views for a
 * certain post and a popularity that uses our model to calculate the popularity for the post. Each list will have add
 * and remove methods for the post object. The post also inherits all the methods and parameters from abstract class
 * object</p>
 *
 * @implNote the user id for the class is not to be altered, thus set as final.
 * @Author: eric-qli
 * @Modifiedby: Yufei Chen, LemengDai
 */
public class Post extends Context{


    private String postTitle;
    private final int userId;
    private final ArrayList<Integer> list_comment_id;
    private int views;
    private int numLikes;

    //private String TopicName;
    private final ArrayList<Integer> userLiked;

    private final Integer popularity = views + numLikes * 10;

    public Integer getPopularity() {
        return popularity;
    }

    public Post(String postTitle, int userId, int id, String content, String timestamp,
                int views, int numLikes, ArrayList<Integer> userLiked, ArrayList<Integer> list_comment_id) {
        super(id, content, timestamp);
        this.postTitle = postTitle;
        this.userId = userId;
        this.views = views;
        this.numLikes = numLikes;
        this.userLiked = userLiked;
        this.list_comment_id = list_comment_id;
    }

    /**
     * @return the post title
     */
    public String getPostTitle(){
        return this.postTitle;
    }

    /**
     * @param postTitle the post title to be set
     */
    public void setPostTitle(String postTitle){
        this.postTitle = postTitle;
    }

    /**
     * @return the user id
     */
    public int getUserId() {
        return userId;
    }

    /**
     * @return the list of comments
     */
    public int getNumLikes(){
        return numLikes;
    }

    /**
     * @return the list of comments
     */
    public ArrayList<Integer> getListComment(){return list_comment_id;}

    /**
     * @param numLikes the number of likes to be set
     */
    public void addListComment(int commentId){
        list_comment_id.add(commentId);
    }

    /**
     * @param numLikes the number of likes to be set
     */
    public void removeListComment(int commentId){list_comment_id.remove(commentId);}

    /**
     * @return the list of comments
     */
    public int getViews() {
        return this.views;
    }

    /**
     * number of views add 1
     */
    public void addViews(){
        this.views ++;
    }

    /**
     * @return the list of users liked this post
     */
    public ArrayList<Integer> getUserLiked(){
        return this.userLiked;
    }

    /**
     * @param userId the user id to be added to the list of users liked this post
     * number of likes add 1
     * user id added to the list of users liked this post
     */
    public void addUserLike(int userId){
        userLiked.add(userId);
        numLikes += 1;
    }

    /*
     * @return the timestamp of the post
     */
    public String getTimes() {
        return timestamp;
    }

    /**
     * @param userId the user id to be removed from the list of users liked this post
     * number of likes minus 1
     * user id removed from the list of users liked this post
     */
    public boolean removeUserLike(int UserId){
        try {
            userLiked.remove(userId);
            numLikes -= 1;
            return true;
        }catch(IndexOutOfBoundsException O){
            return false;
        }



    }
}
