package UseCases;


import model.request.ChatRequestModel;
import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Test;
import useCases.ChatUseCases;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

/*
 * Author: Jiahao Gu
 */

public class ChatUseCasesTests {
    static ChatUseCases actual;

    @BeforeClass

    public static void setUp() {
        ChatRequestModel chat1 = new ChatRequestModel(1, 1, 2, "Hello!", "2021");
        ChatRequestModel chat2 = new ChatRequestModel(2, 2, 1, "How are u?", "2022");
        ChatRequestModel chat3 = new ChatRequestModel(3, 1, 2, "Good!", "2022");
        Map<Integer, ChatRequestModel> cuc = new HashMap<>();
        cuc.put(1, chat1);
        cuc.put(2, chat2);
        cuc.put(3, chat3);
        actual = new ChatUseCases(cuc);
    }

    @After
    public void tearDown() {
    }

    @Test(timeout = 500)
    public void testAddChat(){
        actual.addChat(2, 1,  "me2!");
        int senderid = actual.getChatList().get(4).getSender_id();
        int receiverid = actual.getChatList().get(4).getReceiver_id();
        String content = actual.getChatList().get(4).getContent();

        assertEquals("There is error in addChat!", 2, senderid);
        assertEquals("There is error in addChat!", 1, receiverid);
        assertEquals("There is error in addChat!", "me2!", content);
    }

    @Test(timeout = 500)
    public void testDeleteChat(){
        actual.deleteChat(4);
        assertEquals("There is error in deleteChat!",3, actual.getChatList().size());
    }

    @Test(timeout = 500)
    public void testGetIdByUserAndTime(){
        assertEquals("There is error in getIdByUserAndTime!",1,
                actual.getIdByUserAndTime(1,2, "2021"));
    }
}
