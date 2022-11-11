package Entity;

import Layer1.Entity.Post;
import Layer1.Entity.Topic;
import Layer1.Entity.User;
import org.junit.*;
import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/*
 * Author: Eric Li
 */
public class TopicTests {

    static Topic actual;
    @BeforeClass
    public static void setUp() {
        User user_1 = new User(1, "VIP", "eric", "123qweASD", "2020-01-01 00:00:00");
        Post post_1 = new Post("title", 1, 1, "content", "2020-01-01 00:00:00",
                0, 0, new ArrayList<Integer>(), new ArrayList<Integer>(), "default");
        Map<Integer, User> users = new HashMap<>();
        users.put(1, user_1);
        Map<Integer, Post> posts = new HashMap<>();
        posts.put(1, post_1);
        actual = new Topic("name", "12345", users, posts);
    }

    @After
    public void tearDown() {
    }

    @Test(timeout = 500)
    public void testGetTotalofTopicPopularity(){
        assertSame(0, actual.getTotalPopularity());
    }

    @Test(timeout = 500)
    public void testGetUsers(){
        assertEquals(1, actual.getUsers().size());
    }

    @Test(timeout = 500)
    public void testSetUsers(){
        User user_2 = new User(2, "VIP", "eric", "123qweASD", "2020-01-01 00:00:00");
        Map<Integer, User> users = new HashMap<>();
        users.put(2, user_2);
        actual.setUsers(users);
        assertEquals(1, actual.getUsers().size());
    }

    @Test(timeout = 500)
    public void testGetPosts(){
        assertEquals(1, actual.getPosts().size());
    }

    @Test(timeout = 500)
    public void testSetPosts(){
        Post post_2 = new Post("title", 2, 1, "content", "2020-01-01 00:00:00",
                0, 0, new ArrayList<Integer>(), new ArrayList<Integer>(), "default");
        Map<Integer, Post> posts = new HashMap<>();
        posts.put(2, post_2);
        actual.setPosts(posts);
        assertEquals(1, actual.getPosts().size());
    }

    @Test(timeout = 500)
    public void testGetName(){
        assertEquals("name", actual.getName());
    }

    @Test(timeout = 500)
    public void testSetName(){
        actual.setName("abc");
        assertEquals("abc", actual.getName());
    }

    @Test(timeout = 500)
    public void testGetId(){
        assertEquals("12345", actual.getID());
    }

    @Test(timeout = 500)
    public void testSetId(){
        actual.setID("def");
        assertEquals("def", actual.getID());
    }

    @Test(timeout = 500)
    public void testGetTotalPopularity(){
        assertSame(0, actual.getTotalPopularity());
    }

}
