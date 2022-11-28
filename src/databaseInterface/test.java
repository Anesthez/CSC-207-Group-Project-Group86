package databaseInterface;

import model.request.PostRequestModel;
import model.request.TopicRequestModel;
import model.request.UserRequestModel;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

public class test {
    public static void main(String[] args) {
        csvInterface c = new csvInterface();
        try {
            c.topicsReader("database/topic.csv");
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
