package test_Entity;

import Entity.Chat;
import org.junit.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static org.junit.Assert.*;
import static org.junit.Assert.assertTrue;


public class ChatTests {
    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test(timeout = 500)
    public void TestInit(){
        Chat actual = new Chat(1, 123, 456, "Hello!", "2022");
        int[] intExpected = {1, 123, 456};
        String[] strExpected = {"Hello!", "2022"};
        assertEquals("There is error in Chat.id!", actual.getId(), intExpected[0]);
        assertEquals("There is error in Chat.user1_id!", actual.getSender_id(), intExpected[1]);
        assertEquals("There is error in Chat.user2_id!", actual.getReceiver_id(), intExpected[2]);
        assertEquals("There is error in Chat.content!", actual.getContent(), strExpected[0]);
        assertEquals("There is error in Chat.time!", actual.getTime(), strExpected[1]);
    }
}
