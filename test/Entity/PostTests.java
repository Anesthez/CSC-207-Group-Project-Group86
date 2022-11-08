package Entity;

import Layer1.Entity.Post;
import org.junit.*;
import static org.junit.Assert.*;

import java.util.ArrayList;

/*
 * Author: Eric Li
 */
public class PostTests {
    static Post actual;
    @BeforeClass
    public static void setUp() {
        actual = new Post("title", 1, 1, "content", "2020-01-01 00:00:00",
                0, 0, new ArrayList<Integer>(), new ArrayList<Integer>());
    }

    @After
    public void tearDown() {
    }

    @Test(timeout = 500)
    public void testSetPostTitle() {
        actual.setPostTitle("abc");
        assertEquals("abc", actual.getPostTitle());
    }

    @Test(timeout = 500)
    public void testGetId(){
        assertEquals(1, actual.getId());
    }

    @Test(timeout = 500)
    public void testGetContent(){
        assertEquals("content", actual.getContent());
    }

    @Test(timeout = 500)
    public void testGetUserId(){
        assertEquals(1, actual.getUserId());
    }

    @Test(timeout = 500)
    public void testGetTimestamp(){
        assertEquals("2020-01-01 00:00:00", actual.getTimes());
    }

    @Test(timeout = 500)
    public void testGetViews(){
        assertEquals(0, actual.getViews());
    }

    @Test(timeout = 500)
    public void testGetNumLikes(){
        assertEquals(0, actual.getNumLikes());
    }

    @Test(timeout = 500)
    public void testGetUserLiked(){
        assertEquals(new ArrayList<Integer>(), actual.getUserLiked());
    }

    @Test(timeout = 500)
    public void testGetListCommentId(){
        assertEquals(new ArrayList<Integer>(), actual.getListComment());
    }

    @Test(timeout = 500)
    public void testGetPopularity(){
        assertSame(0, actual.getPopularity());
    }

    @Test(timeout = 500)
    public void testSetTitle(){
        actual.setPostTitle("abc");
        assertEquals("abc", actual.getPostTitle());
    }

    @Test(timeout = 500)
    public void TestAddListComment(){
        actual.addListComment(1);
        assertEquals(1, actual.getListComment().size());
    }

    @Test(timeout = 500)
    public void TestRemoveListComment(){
        actual.addListComment(1);
        actual.removeListComment(1);
        assertEquals(0, actual.getListComment().size());
    }

    @Test(timeout = 500)
    public void TestAddViews(){
        actual.addViews();
        assertEquals(1, actual.getViews());
    }

    @Test(timeout = 500)
    public void TestAddUserLiked(){
        actual.addUserLike(1);
        assertEquals(1, actual.getUserLiked().size());
    }

    @Test(timeout = 500)
    public void TestRemoveUserLiked(){
        actual.addUserLike(1);
        actual.removeUserLike(1);
        assertEquals(0, actual.getUserLiked().size());
    }
}
