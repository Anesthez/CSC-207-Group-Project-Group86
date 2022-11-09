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

    /**
     * <p>
     *     This method is used to get the sum of the popularity of all the posts in the topic.
     * </p>
     * @return the sum of the popularity of all the posts in the topic
     */
    public Topic()
    {
        /*
        Empty constructor, is used when using this method.
         */

    }

    /**
     * <p>
     *     This method is used to create a Topic object.
     * </p>
     * <p>
     *     This method takes in String name, String ID, Map posts and push those parameters onto the Topic Object.
     * </p>
     * @param name the name of the topic
     * @param ID the ID of the topic
     * @param posts the posts of the topic
     */
    public Topic(HashMap<Post, Integer> topicPopularity) {
        this.postPopularity = topicPopularity;
    }

    /**
     * <p>
     *     This method is used to create a Topic object.
     * </p>
     * <p>
     *     This method takes in String name, String ID, Map posts and push those parameters onto the Topic Object.
     * </p>
     * @param name the name of the topic
     * @param ID the ID of the topic
     * @param posts the posts of the topic
     */
    public Topic(String name, String ID, Map<Integer, User> users, Map<Integer, Post> posts)
    {
        this.name = name;
        this.ID = ID;
        this.users = users;
        this.posts = posts;
    }

    /**
     * <p>
     *     This method is used to create a Topic object.
     * </p>
     * <p>
     *     This method takes in String name, String ID, Map posts and push those parameters onto the Topic Object.
     * </p>
     * @param name the name of the topic
     * @param ID the ID of the topic
     * @param posts the posts of the topic
     */
    public Topic(String name, String ID, Map<Integer, Post> posts)
    {
        this.name = name;
        this.ID = ID;
        this.posts = posts;
    }

    /**
     * <p>
     *     This method is used to get the sum of the topic popularity.
     * </p>
     * @return the sum of popularity of the topic
     */
    private Integer getSumofTopicPopularity()
    {
        Integer total = 0;
        for (Integer i : postPopularity.values())
        {
            total += i;
        }

        return total;
    }

    /**
     * <p>
     *     This method is used to get Map od users.
     * </p>
     * @return the user Map.
     */
    public Map<Integer, User> getUsers() {
        return users;
    }

    /**
     * <p>
     *     This method is used to set the user Map.
     * </p>
     * @param users the user Map.
     */
    public void setUsers(Map<Integer, User> users) {
        this.users = users;
    }

    /**
     * <p>
     *     This method is used to get the map of the Posts.
     * </p>
     * @return the Map of the Posts
     */
    public Map<Integer, Post> getPosts() {
        return posts;
    }

    /**
     * <p>
     *     This method is used to set the map of the Posts.
     * </p>
     * @param posts the Map of the Posts
     */
    public void setPosts(Map<Integer, Post> posts) {
        this.posts = posts;
    }

    /**
     * <p>
     *     This method is used to get the name of the topic.
     * </p>
     * @return the name of the topic
     */
    public String getName() {
        return name;
    }

    /**
     * <p>
     *     This method is used to set the name of the topic.
     * </p>
     * @param name the name of the topic
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * <p>
     *     This method is used to get the ID of the topic.
     * </p>
     * @return the ID of the topic
     */
    public String getID() {
        return ID;
    }

    /**
     * <p>
     *     This method is used to set the ID of the topic.
     * </p>
     * @param ID the ID of the topic
     */
    public void setID(String ID) {
        this.ID = ID;
    }

    /**
     * <p>
     *     This method is used to get the user who attend the topic.
     * </p>
     * @return the user who attend the topic
     */
    public User getAttendUser() {
        return attendUser;
    }
    /**
     * <p>
     *     This method is used to set the attendUser of the topic.
     * </p>
     * @param attendUser the attendUser of the topic
     */
    public void setAttendUser(User attendUser) {
        this.attendUser = attendUser;
    }

    /**
     * <p>
     *     This method is used to get the postPopularity of the topic.
     * </p>
     * @return the postPopularity of the topic
     */
    public HashMap<Post, Integer> getPostPopularity() {
        return postPopularity;
    }

    /**
     * <p>
     *     This method is used to set the postPopularity of the topic.
     * </p>
     * @param postPopularity the postPopularity of the topic
     */
    public void setPostPopularity(HashMap<Post, Integer> postPopularity) {
        this.postPopularity = postPopularity;
    }

    /**
     * <p>
     *     This method is used to add the postPopularity of the topic.
     * </p>
     * @return the postPopularity of the topic
     */
    public void addPostPopularity(Post post)
    {
        postPopularity.put(post, post.getPopularity());
    }
}
