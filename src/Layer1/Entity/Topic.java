package Layer1.Entity;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 *     The Topic object is an object that contains a lot of post with the same topic. The topic is a classification of
 *     posts.
 * </p>
 * <p>
 *     To initialize a topic object, we have three different ways to initialize it. The first way is to input nothing
 *     when creating a topic object. The second way is to input String name, String ID, Map Posts. The third way is to
 *     input String name, String ID, Map Posts and Map Users.
 * </p>
 * <p>
 *     The Topic object contains a String name, a String ID, an attendUser, a map users, a map posts, a map
 *     postPopularity, an Integer totalPopularity.
 * </p>
 * @implNote the totalPopularity for this object is not meant to be change, thus set as final
 * @Author: Chen Jiang
 * @Modifiedby: Chen Jiang
 */
public class Topic {

    private String name;
    private String ID;
    private User attendUser;

    private Map<Integer, User> users;

    private Map<Integer, Post> posts;

    /*
    A HashMap that maps the popularity of each Post to Post.
     */
    private HashMap<Post, Integer> postPopularity = new HashMap<Post, Integer>();

    /*
    Calculate the total popularity of posts inside this topic.
     */
    private final Integer totalPopularity = getSumofTopicPopularity();

    public Integer getTotalPopularity() {
        return totalPopularity;
    }

    public Topic()
    {
        /*
        Empty constructor, is used when using this method.
         */

    }

    public Topic(HashMap<Post, Integer> topicPopularity) {
        this.postPopularity = topicPopularity;
    }

    public Topic(String name, String ID, Map<Integer, User> users, Map<Integer, Post> posts)
    {
        this.name = name;
        this.ID = ID;
        this.users = users;
        this.posts = posts;
    }

    public Topic(String name, String ID, Map<Integer, Post> posts)
    {
        this.name = name;
        this.ID = ID;
        this.posts = posts;
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

    public Map<Integer, User> getUsers() {
        return users;
    }

    public void setUsers(Map<Integer, User> users) {
        this.users = users;
    }

    public Map<Integer, Post> getPosts() {
        return posts;
    }

    public void setPosts(Map<Integer, Post> posts) {
        this.posts = posts;
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
