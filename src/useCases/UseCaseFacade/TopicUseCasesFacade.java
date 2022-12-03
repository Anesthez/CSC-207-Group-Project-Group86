package useCases.UseCaseFacade;

import entity.Post;
import entity.Topic;
import model.request.TopicRequestModel;
import useCases.AddPostsToTopicUsesCase;
import useCases.GetTopTopicsUseCase;
import useCases.GetMaxTopicUseCase;
import useCases.GetTopPostsUseCase;

import java.io.IOException;
import java.util.ArrayList;


/**
 * <p>
 * The TopicUserCases class is a class that is used to control Topic and implement some functions with regards to
 * Topics.
 * </p>
 * <p>
 * The TopicUserCases contains several methods: addPostsToTopic, getTopPosts, getTopTopics, and a private method
 * get MaxTopics.
 * </p>
 *
 * @Author: Chen Jiang
 * @Modifiedby: Chen Jiang, Kevin Wu
 */
public class TopicUseCasesFacade {
    private final AddPostsToTopicUsesCase addPostsToTopicUsesCase;
    private final GetMaxTopicUseCase getMaxTopicUseCase;
    private final GetTopTopicsUseCase getTopTopicsUseCase;
    private final GetTopPostsUseCase getTopPostsUseCase;

    public TopicUseCasesFacade() {
        this.addPostsToTopicUsesCase = new AddPostsToTopicUsesCase();
        this.getMaxTopicUseCase = new GetMaxTopicUseCase();
        this.getTopTopicsUseCase = new GetTopTopicsUseCase();
        this.getTopPostsUseCase = new GetTopPostsUseCase();
    }

    /**
     * <p>
     * The addPostsToTopic method is a method that is used to add posts to a topic.
     * </p>
     *
     * @param topic the topic that the posts are added to
     * @param post  the post to be added to the topic
     */
    public void addPostsToTopic(Topic topic, Post post) {
        /*
        Add Posts associated to the Topic in this Topic.
         */
        addPostsToTopicUsesCase.addPostsToTopic(topic, post);

    }

    /**
     * <p>
     * The getTopPosts method is a method that is used to get the top posts in a topic.
     * </p>
     *
     * @param topic the topic user chose
     * @return the top posts in the topic
     */
    public ArrayList<Post> getTopPosts(Topic topic) {
        /*
        Return five Posts with the highest popularity.
         */

        return getTopPostsUseCase.getTopPosts(topic);
    }

    /**
     * <p>
     * The getTopTopics method is a method that is used to get the top topics.
     * </p>
     *
     * @param topic the topic user chose
     * @return the top topics
     */
    public ArrayList<TopicRequestModel> getTopTopics(ArrayList<TopicRequestModel> topic) throws IOException {
        /*
        Return five Topics with the highest popularity.
         */
        return getTopTopicsUseCase.getTopTopics(topic);
    }


    /**
     * <p>
     * The getMaxTopic method is a method that is used to get the maximum topic.
     * </p>
     *
     * @param topic the topics to be compared
     * @return the maximum topic
     */
    private Integer getMaxTopic(ArrayList<Topic> topic) {
        return getMaxTopicUseCase.getMaxTopic(topic);
    }
}
