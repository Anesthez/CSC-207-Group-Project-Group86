package Entity;

import java.util.HashMap;
import java.math.*;

public class Topic {

    private String name;
    private String ID;
    private User attendUser;

    /*
    A HashMap that maps the popularity of each Post to Post.
     */
    private HashMap<Post, Integer> topicPopularity = new HashMap<Post, Integer>();

    /*
    Calculate the total popularity of posts inside this topic.
     */
    private final Integer totalPopularity = getSumofTopicPopularity();

    public Topic()
    {
        /*
        Empty constructor, is used when using this method.
         */

    }

    public Topic(HashMap<Post, Integer> topicPopularity) {
        this.topicPopularity = topicPopularity;
    }

    private Integer getSumofTopicPopularity()
    {
        Integer total = 0;
        for (Integer i : topicPopularity.values())
        {
            total += i;
        }

        return total;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public User getAttendUser() {
        return attendUser;
    }

    public void setAttendUser(User attendUser) {
        this.attendUser = attendUser;
    }

    public HashMap<Post, Integer> getTopicPopularity() {
        return topicPopularity;
    }

    public void setTopicPopularity(HashMap<Post, Integer> topicPopularity) {
        this.topicPopularity = topicPopularity;
    }

    public void addPostPopularity(Post post)
    {
        topicPopularity.put(post, post.getPopularity());
    }
}
