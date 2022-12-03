package Interface;

import entity.Post;
import entity.User;
import databaseInterface.CsvInterface;
import model.response.PostResponseModel;
import model.response.TopicResponseModel;
import model.response.UserResponseModel;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

/**
 * This class is used to test topicsWriter method in csvInterface class
 *
 * @Author: Yijun(Kevin) Zhao
 */

public class csvInterfaceTests_topics_writer {
    CsvInterface csv = new CsvInterface();
    String topicsPath = "test/Interface/test_topics.csv";

    @Test(timeout = 500)
    public void test_topicsWriter_1topic() throws IOException {
        Map<Integer, TopicResponseModel> topics = new HashMap<>();
        Map<Integer, UserResponseModel> users = new HashMap<>();
        Map<Integer, PostResponseModel> posts = new HashMap<>();
        users.put(1, new User(1, "normal", "User1", "password1", "2019-01-01").responseModel());
        users.put(2, new User(2, "admin", "User2", "password2", "2019-01-01").responseModel());
        users.put(3, new User(3, "normal", "User3", "password3", "2019-01-01").responseModel());
        posts.put(1, new Post("Post 1", 1, 1, "Post 1 Content", "2020-01-01 00:00:00", 0, 0, new ArrayList<>(), new ArrayList<>(), "topic1").responseModel());
        posts.put(2, new Post("Post 2", 2, 1, "Post 2 Content", "2020-01-01 00:00:00", 0, 0, new ArrayList<>(), new ArrayList<>(), "topic1").responseModel());
        posts.put(3, new Post("Post 3", 3, 1, "Post 3 Content", "2020-01-01 00:00:00", 0, 0, new ArrayList<>(), new ArrayList<>(), "topic1").responseModel());
        TopicResponseModel topic = new TopicResponseModel("topic1", "1", users, posts);
        topics.put(1, topic);
        csv.topicWriter(topics, topicsPath);

        File csvFile = new File(topicsPath);
        BufferedReader reader = new BufferedReader(new FileReader(csvFile));
        assertEquals("id,name,posts,users", reader.readLine());
        assertEquals("1,topic1, 1.Post 1 Content 2.Post 2 Content 3.Post 3 Content, 1.User1 2.User2 3.User3", reader.readLine());
    }

    @Test(timeout = 500)
    public void test_topicsWriter_2topics() throws IOException {
        Map<Integer, TopicResponseModel> topics = new HashMap<>();
        Map<Integer, UserResponseModel> users = new HashMap<>();
        Map<Integer, PostResponseModel> posts = new HashMap<>();
        users.put(1, new User(1, "normal", "User1", "password1", "2019-01-01").responseModel());
        users.put(2, new User(2, "admin", "User2", "password2", "2019-01-01").responseModel());
        users.put(3, new User(3, "normal", "User3", "password3", "2019-01-01").responseModel());
        posts.put(1, new Post("Post 1", 1, 1, "Post 1 Content", "2020-01-01 00:00:00", 0, 0, new ArrayList<>(), new ArrayList<>(), "topic1").responseModel());
        posts.put(2, new Post("Post 2", 2, 1, "Post 2 Content", "2020-01-01 00:00:00", 0, 0, new ArrayList<>(), new ArrayList<>(), "topic1").responseModel());
        posts.put(3, new Post("Post 3", 3, 1, "Post 3 Content", "2020-01-01 00:00:00", 0, 0, new ArrayList<>(), new ArrayList<>(), "topic1").responseModel());
        TopicResponseModel topic = new TopicResponseModel("topic1", "1", users, posts);
        topics.put(1, topic);
        TopicResponseModel topic2 = new TopicResponseModel("topic2", "2", users, posts);
        topics.put(2, topic2);
        csv.topicWriter(topics, topicsPath);

        File csvFile = new File(topicsPath);
        BufferedReader reader = new BufferedReader(new FileReader(csvFile));
        assertEquals("id,name,posts,users", reader.readLine());
        assertEquals("1,topic1, 1.Post 1 Content 2.Post 2 Content 3.Post 3 Content, 1.User1 2.User2 3.User3", reader.readLine());
        assertEquals("2,topic2, 1.Post 1 Content 2.Post 2 Content 3.Post 3 Content 1.Post 1 Content 2.Post 2 Content 3.Post 3 Content, 1.User1 2.User2 3.User3 1.User1 2.User2 3.User3", reader.readLine());
    }
}