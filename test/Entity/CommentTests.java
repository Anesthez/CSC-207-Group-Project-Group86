package Entity;

import entity.Comment;
import org.junit.*;
import static org.junit.Assert.*;

/*
 * Author: Tianyu Li, LemengDai
 */
public class CommentTests {
    int[] intExpected = {5, 15, 0, 100};
    static Comment actual;
    String[] strExpected = {"Nice Picture!", "2022.05.15"};

    @BeforeClass
    public static void setUp() {
        actual = new Comment(5, 15, "Nice Picture!", "2022.05.15", 5);
    }

    @After
    public void tearDown() {
    }

    @Test(timeout = 500)
    public void TestGetUserID() {
        assertEquals("There is error in Comment.userId",
                intExpected[0], actual.getUserId());
    }

    @Test(timeout = 500)
    public void TestGetID(){
        assertEquals("There is error in Comment.id!",
                intExpected[1], actual.getId());
    }
    @Test(timeout = 500)
    public void TestContent(){
        assertEquals("There is error in Comment.content!",
                strExpected[0], actual.getContent());
    }

    @Test(timeout = 500)
    public void TestTime(){
        assertEquals("There is error in Comment.time!",
                strExpected[1], actual.getTime());
    }

}


