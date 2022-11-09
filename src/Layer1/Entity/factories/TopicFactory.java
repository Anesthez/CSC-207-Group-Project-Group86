package Layer1.Entity.factories;

import Layer1.Entity.Post;
import Layer1.Entity.Topic;
import java.util.Map;

/**
 * <p>
 *     A factory for creating Topic objects.
 * </p>
 * <p>
 *     This class is used to create Topic objects. To create the Topic objects, it creates String name, String ID,
 *     Map post and push those parameters onto the Topic Object.
 * </p>
 * <p>
 *     This class is part of the Entity layer.
 * </p>
 *
 * @Author: Chen Jiang
 */
public class TopicFactory {

    /**
     * <p>
     *     This method is used to create a Topic object.
     * </p>
     * <p>
     *     This method takes in String name, String ID, Map post and push those parameters onto the Topic Object.
     * </p>
     *
     * @param name the name of the topic
     * @param ID the ID of the topic
     * @param posts the posts of the topic
     * @return the topic object
     */

    public Topic create(String name, String ID, Map<Integer, Post> posts)
    {
        return new Topic(name, ID, posts);
    }
}
