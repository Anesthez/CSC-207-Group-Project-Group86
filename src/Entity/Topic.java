package Entity;

import java.util.HashMap;

public class Topic {

    private String name;
    private String ID;
    private User attendUser;

    /*
    A HashMap that maps the popularity of each Post to Post.
     */
    private HashMap<Post, Integer> postPopularity = new HashMap<Post, Integer>();

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
        this.postPopularity = topicPopularity;
    }

    private Integer getSumofTopicPopularity()
    {
        Integer total = 0;
        for (Integer i : postPopularity.values())
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

    public HashMap<Post, Integer> getPostPopularity() {
        return postPopularity;
    }

    public void setPostPopularity(HashMap<Post, Integer> postPopularity) {
        this.postPopularity = postPopularity;
    }

    public void addPostPopularity(Post post)
    {
        postPopularity.put(post, post.getPopularity());
    }
}
