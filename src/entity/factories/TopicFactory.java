package entity.factories;

import entity.Post;
import entity.Topic;
import model.request.PostRequestModel;
import model.request.TopicRequestModel;

import java.util.ArrayList;
import java.util.HashMap;

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
