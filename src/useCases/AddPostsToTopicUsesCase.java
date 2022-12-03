package useCases;

import entity.Post;
import entity.Topic;

import java.util.Map;

public class AddPostsToTopicUsesCase {
    /**
     * <p>
     *     The addPostsToTopic method is a method that is used to add posts to a topic.
     * </p>
     * @param topic the topic that the posts are added to
     * @param post the post to be added to the topic
     */
    public void addPostsToTopic(Topic topic, Post post)
    {
        /*
        Add Posts associated to the Topic in this Topic.
         */
        Map<Integer, Post> update = topic.getPosts();
        update.put(update.size(), post);
        topic.setPosts(update);

    }
}
