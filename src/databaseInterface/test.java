package databaseInterface;

import model.request.PostRequestModel;
import model.request.TopicRequestModel;
import model.request.UserRequestModel;
import model.response.PostResponseModel;
import model.response.TopicResponseModel;
import useCases.TopicUseCases;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class test {
    public static void main(String[] args) {
        csvInterface c = new csvInterface();
        try {
            Map<Integer, TopicRequestModel> topics = c.topicsReader("database/topic.csv");
            Set<Integer> topicKeys = topics.keySet();
            for (Integer topicKey : topicKeys) {
                System.out.println(String.valueOf(topics.get(topicKey).get().get(3)));
            }

            TopicUseCases tuc = new TopicUseCases();
            ArrayList<TopicRequestModel> topicRequestModels = new ArrayList<>(topics.values());
            ArrayList<TopicRequestModel> ts = tuc.getTopTopics(topicRequestModels);
            for (TopicRequestModel t : ts) {
                System.out.println(t.get());
            }
            Map<Integer, TopicResponseModel> rtopics = new LinkedHashMap<>();
            Map<Integer, PostResponseModel> post = new LinkedHashMap<>();
            //PostResponseModel p = new PostResponseModel();
//            post.put(2, );
//            c.topicWriter(topics,"database/topic.csv");

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try {
            Map<Integer, UserRequestModel> users = c.usersReader("database/user.csv");
            Map<Integer, PostRequestModel> posts = c.postsReader("database/post.csv");
            TopicRequestModel topic = new TopicRequestModel("Test", "1", users, posts);
            Map<Integer, TopicRequestModel> topics = new LinkedHashMap<>();
            topics.put(1, topic);
//            c.topicWriter(topics, "database/topic.csv");
//            c.topicsReader("database/topic.csv");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
