package Interface;

import Entity.Post;
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
 * This class is used to test
 *
 * @Author: Yijun(Kevin) Zhao
 */

public class csvInterfaceTests_posts_writer {
    csvInterface csv = new csvInterface();
    String postsPath = "test/Interface/test_posts.csv";

    @Test(timeout = 500)
    public void test_postsWriter_1user3posts() throws IOException {
        Post post1 = new Post("Test 1", 1, 1, "Test 1 Content", "2020-01-01 00:00:00", 0, 0, new ArrayList<>(), new ArrayList<>());
        Post post2 = new Post("Test 2", 1, 2, "Test 2 Content", "2020-01-01 00:00:00", 0, 0, new ArrayList<>(), new ArrayList<>());
        Post post3 = new Post("Test 3", 1, 3, "Test 3 Content", "2020-01-01 00:00:00", 0, 0, new ArrayList<>(), new ArrayList<>());
        Map<Integer, Post> posts = new HashMap<>();
        posts.put(1, post1);
        posts.put(2, post2);
        posts.put(3, post3);
        csv.postsWriter(postsPath, posts);

        File csvFile = new File(postsPath);
        BufferedReader reader = new BufferedReader(new FileReader(csvFile));
        assertEquals("id,userid,time,content,num-liked,num-viewed,user-liked,list_comment_id,post_title", reader.readLine());
        assertEquals("1,1,2020-01-01 00:00:00,Test 1 Content,0,0,,,Test 1", reader.readLine());
        assertEquals("2,1,2020-01-01 00:00:00,Test 2 Content,0,0,,,Test 2", reader.readLine());
        assertEquals("3,1,2020-01-01 00:00:00,Test 3 Content,0,0,,,Test 3", reader.readLine());
    }

    @Test(timeout = 500)
    public void test_postsWriter_2user4posts() throws IOException {
        Post post1 = new Post("Test 1", 1, 1, "Test 1 Content", "2020-01-01 00:00:00", 0, 0, new ArrayList<>(), new ArrayList<>());
        Post post2 = new Post("Test 2", 1, 2, "Test 2 Content", "2020-01-01 00:00:00", 0, 0, new ArrayList<>(), new ArrayList<>());
        Post post3 = new Post("Test 3", 1, 3, "Test 3 Content", "2020-01-01 00:00:00", 0, 0, new ArrayList<>(), new ArrayList<>());
        Post post4 = new Post("Test 4", 1, 4, "Test 4 Content", "2020-01-01 00:00:00", 0, 0, new ArrayList<>(), new ArrayList<>());
        Post post5 = new Post("Test 5", 2, 5, "Test 5 Content", "2020-01-01 00:00:00", 0, 0, new ArrayList<>(), new ArrayList<>());
        Post post6 = new Post("Test 6", 2, 6, "Test 6 Content", "2020-01-01 00:00:00", 0, 0, new ArrayList<>(), new ArrayList<>());
        Post post7 = new Post("Test 7", 2, 7, "Test 7 Content", "2020-01-01 00:00:00", 0, 0, new ArrayList<>(), new ArrayList<>());
        Post post8 = new Post("Test 8", 2, 8, "Test 8 Content", "2020-01-01 00:00:00", 0, 0, new ArrayList<>(), new ArrayList<>());
        Map<Integer, Post> posts = new HashMap<>();
        posts.put(1, post1);
        posts.put(2, post2);
        posts.put(3, post3);
        posts.put(4, post4);
        posts.put(5, post5);
        posts.put(6, post6);
        posts.put(7, post7);
        posts.put(8, post8);
        csv.postsWriter(postsPath, posts);

        File csvFile = new File(postsPath);
        BufferedReader reader = new BufferedReader(new FileReader(csvFile));
        assertEquals("id,userid,time,content,num-liked,num-viewed,user-liked,list_comment_id,post_title", reader.readLine());
        assertEquals("1,1,2020-01-01 00:00:00,Test 1 Content,0,0,,,Test 1", reader.readLine());
        assertEquals("2,1,2020-01-01 00:00:00,Test 2 Content,0,0,,,Test 2", reader.readLine());
        assertEquals("3,1,2020-01-01 00:00:00,Test 3 Content,0,0,,,Test 3", reader.readLine());
        assertEquals("4,1,2020-01-01 00:00:00,Test 4 Content,0,0,,,Test 4", reader.readLine());
        assertEquals("5,2,2020-01-01 00:00:00,Test 5 Content,0,0,,,Test 5", reader.readLine());
        assertEquals("6,2,2020-01-01 00:00:00,Test 6 Content,0,0,,,Test 6", reader.readLine());
        assertEquals("7,2,2020-01-01 00:00:00,Test 7 Content,0,0,,,Test 7", reader.readLine());
        assertEquals("8,2,2020-01-01 00:00:00,Test 8 Content,0,0,,,Test 8", reader.readLine());
    }
}