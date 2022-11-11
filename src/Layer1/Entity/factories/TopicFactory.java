package Layer1.Entity.factories;

import Layer1.Entity.Post;
import Layer1.Entity.Topic;
import Model.Request.PostRequestModel;
import Model.Request.TopicRequestModel;

import java.util.ArrayList;
import java.util.HashMap;
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
     * @param topicModel the model for the topic
     * @return the topic object
     */

    public Topic create(TopicRequestModel topicModel)
    {
        ArrayList<Object> topicContents = topicModel.get();
        HashMap<Integer, PostRequestModel> posts = (HashMap<Integer, PostRequestModel>)topicContents.get(4);
        HashMap<Integer, Post> postMap = new HashMap<>();
        for (PostRequestModel post : posts.values()) {
            PostFactory postFactory = new PostFactory();
            Post post1 = postFactory.create(post);
            postMap.put(post1.getId(), post1);
        }

        return new Topic((String)topicContents.get(0),
                (String)topicContents.get(1),
                postMap);


    }
}
