package Layer1.Entity;

import Layer1.Entity.inputboundary.Context;

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
public class Post extends Context{


    private String postTitle;
    private final int userId;
    private final ArrayList<Integer> list_comment_id;
    private int views;
    private int numLikes;
    private String topic;

    //private String TopicName;
    private final ArrayList<Integer> userLiked;

    private final Integer popularity = views + numLikes * 10;

    public Integer getPopularity() {
        return popularity;
    }

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


    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getPostTitle(){
        return this.postTitle;
    }

    public void setPostTitle(String postTitle){
        this.postTitle = postTitle;
    }

    public int getUserId() {
        return userId;
    }

    public int getNumLikes(){
        return numLikes;
    }

    public ArrayList<Integer> getListComment(){return list_comment_id;}

    public void addListComment(int commentId){
        list_comment_id.add(commentId);
    }

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

    public boolean removeUserLike(int UserId){
        try {
            userLiked.remove(userId);
            numLikes -= 1;
            return true;
        }catch(IndexOutOfBoundsException O){
            return false;
        }
    }

    public Map<Integer, Topic> addTopic(Map<Integer, Topic> topicMap)
    {
        int count = 0;
        Map<Integer, Topic> newTopicList = topicMap;
        for (Integer i : topicMap.keySet())
        {
            if (this.topic.equals(topicMap.get(i)))
            {
                count = 1;
                Map<Integer, Post> newPostList = topicMap.get(i).getPosts();
                Integer newid = newPostList.size() + 1;
                newPostList.put(newid, this);
                newTopicList.get(i).setPosts(newPostList);
            }
        }
        if (count == 0)
        {
            Integer newid = topicMap.size() + 1;
            Map<Integer, Post> newPostMap = new HashMap<>();
            newPostMap.put(1, this);
            Topic topic1 = new Topic(this.topic, newid+"", newPostMap);
            newTopicList.put(newid, topic1);
        }
        return newTopicList;
    }
}
