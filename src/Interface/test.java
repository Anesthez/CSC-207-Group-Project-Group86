package Interface;

import Entity.Post;
import Entity.Topic;
import Entity.User;

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
            Map<Integer, User> users = c.usersReader("database/user.csv");
            Map<Integer, Post> posts = c.postsReader("database/post.csv");
            Topic topic = new Topic("Test", "1", users, posts);
            Map<Integer, Topic> topics = new LinkedHashMap<>();
            topics.put(1, topic);
            c.topicWriter(topics, "database/topic.csv");
//            Map<Integer, Topic>
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
