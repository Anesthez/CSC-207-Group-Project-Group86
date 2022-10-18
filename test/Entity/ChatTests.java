package Entity;

import org.junit.*;
import static org.junit.Assert.*;

/*
 * Author: Tianyu Li
 */
public class ChatTests {
    int[] intExpected = {1, 123, 456};
    static Chat  actual;
    String[] strExpected = {"Hello!", "2022"};

    @BeforeClass
    public static void setUp() {
        actual = new Chat(1, 123, 456, "Hello!", "2022");
    }

    @After
    public void tearDown() {
    }

    @Test(timeout = 500)
    public void TestGetID(){
        assertEquals("There is error in Chat.id!",
                intExpected[0], actual.getId());
    }

    @Test(timeout = 500)
    public void TestGetSender(){
        assertEquals("There is error in Chat.user1_id!",
                intExpected[1], actual.getSender_id());
    }

    @Test(timeout = 500)
    public void TestGetReceiver(){
        assertEquals("There is error in Chat.user2_id!",
                intExpected[2], actual.getReceiver_id());
    }

    @Test(timeout = 500)
    public void TestContent(){
        assertEquals("There is error in Chat.content!",
                strExpected[0], actual.getContent());
    }

    @Test(timeout = 500)
    public void TestTime(){
        assertEquals("There is error in Chat.time!",
                strExpected[1], actual.getTime());
    }

}
