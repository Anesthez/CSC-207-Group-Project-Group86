package entity;

import entity.inputboundary.Context;
import entity.inputboundary.Populable;
import model.response.PostResponseModel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

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
 * @Modifiedby: Yufei Chen, LemengDai, Chen Jiang
 */
public class Post extends Context implements Populable {


    private String postTitle;
    private final int userId;
    private final ArrayList<Integer> list_comment_id;
    private int views;
    private int numLikes;
    private String topic;

    //private String TopicName;
    private final ArrayList<Integer> userLiked;

    private final Integer popularity = getPop();

    /**<p>This method returns the popularity for the post object</p>
     *
     * @return Integer
     */
    public Integer getPopularity() {
        return popularity;
    }

    private int getPop(){
        return views + numLikes * 10;
    }

    /**<p>This is the constructor for the class Post, it calls the constructor of its super class
     * {@link Context Context}</p>
     *
     * @param postTitle the title of the post
     * @param userId the id of the user
     * @param id the id of the post
     * @param content the content of the post
     * @param timestamp the timestamp of the post
     * @param views the number of views for the post
     * @param numLikes the number of likes for the post
     * @param userLiked the list of userIds of who liked the post
     * @param list_comment_id the list of comments for the post
     * @param topic the topic of the post
     */
    public Post(String postTitle, int userId, int id, String content, String timestamp,
                int views, int numLikes, ArrayList<Integer> userLiked, ArrayList<Integer> list_comment_id, String topic) {
        super(id, content, timestamp);
        this.postTitle = postTitle;
        this.userId = userId;
        this.views = views;
        this.numLikes = numLikes;
        this.userLiked = userLiked;
        this.list_comment_id = list_comment_id;
        this.topic = topic;
    }

    /**<p>This method will return the topic for the post object</p>
     *
     * @return String
     */

    public String getTopic() {
        return topic;
    }

    /**<p>This method will change the topic of the object post to the input parameter</p>
     *
     */
    public void setTopic(String topic) {
        this.topic = topic;
    }

    /**<p>This method will return the title for the post</p>
     *
     * @return String
     */
    public String getPostTitle(){
        return this.postTitle;
    }

    /**<p>This method will set the posttitle for the object to the input parameter</p>
     *
     */

    public void setPostTitle(String postTitle){
        this.postTitle = postTitle;
    }

    /**<p>This method will return the Userid who sent the post for the post object</p>
     *
     * @return int
     */

    public int getUserId() {
        return userId;
    }

    /**<p>This method will return the number of user that likes the post</p>
     *
     * @return int
     */

    public int getNumLikes(){
        return numLikes;
    }

    /**<p>This method will return the list of comment id that is under the post object</p>
     *
     * @return ArrayList<Integer>
     */

    public ArrayList<Integer> getListComment(){return list_comment_id;}

    /** <p>This method will add a comment id to the list of comment id that the class contains</p>
     *
     * @param commentId the id of the comment that will be added to the list
     */
    public void addListComment(int commentId){
        list_comment_id.add(commentId);
    }

    /**<p>this method will remove the comment id from the list, which represents the deletion of the comment</p>
     *
     * @param commentId the id of the comment that will be removed from the list
     */

    public void removeListComment(int commentId){list_comment_id.remove(commentId);}

    public int getViews() {
        return this.views;
    }

    public void addViews(){
        this.views ++;
    }

    public ArrayList<Integer> getUserLiked(){
        return this.userLiked;
    }

    public void addUserLike(int userId){
        userLiked.add(userId);
        numLikes += 1;
    }

    public String getTimes() {
        return timestamp;
    }

    public void removeUserLike(){
        try {
            userLiked.remove(userId);
            numLikes -= 1;
        }catch(IndexOutOfBoundsException ignored){
        }
    }

    public Map<Integer, Topic> addTopic(Map<Integer, Topic> topicMap)
    {
        int count = 0;
        for (Integer i : topicMap.keySet())
        {
            if (this.topic.equals(topicMap.get(i).getName()))
            {
                count = 1;
                Map<Integer, Post> newPostList = topicMap.get(i).getPosts();
                Integer newid = newPostList.size() + 1;
                newPostList.put(newid, this);
                topicMap.get(i).setPosts(newPostList);
            }
        }
        if (count == 0)
        {
            Integer newid = topicMap.size() + 1;
            Map<Integer, Post> newPostMap = new HashMap<>();
            newPostMap.put(1, this);
            Topic topic1 = new Topic(this.topic, newid+"", newPostMap);
            topicMap.put(newid, topic1);
        }
        return topicMap;
    }

    @Override
    public PostResponseModel responseModel() {
        return new PostResponseModel(postTitle, userId, id, content, timestamp, views,
                numLikes, userLiked, list_comment_id, topic);
    }
}
