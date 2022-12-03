package Interface;

import entity.Chat;
import databaseInterface.CsvInterface;
import model.response.ChatResponseModel;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

/**
 * This class is used to test chatsWriter method in csvInterface class
 *
 * @Author: Yijun(Kevin) Zhao
 */

public class csvInterfaceTests_chats_writer {
    CsvInterface csv = new CsvInterface();
    String chatsPath = "test/Interface/test_chats.csv";

    @Test(timeout = 500)
    public void test_chatsWriter_2chats() throws IOException {
        Map<Integer, ChatResponseModel> chats = new HashMap<>();
        Chat chat1 = new Chat(1, 1, 2, "How are you?", "2020-11-11 11:11:11");
        Chat chat2 = new Chat(2, 2, 3, "Hello!", "2020-11-11 11:11:11");
        chats.put(1, chat1.responseModel());
        chats.put(2, chat2.responseModel());
        csv.chatsWriter(chats, chatsPath);

        File csvFile = new File(chatsPath);
        BufferedReader reader = new BufferedReader(new FileReader(csvFile));
        assertEquals("id,user_id1,user_id2,time,content", reader.readLine());
        assertEquals("1,1,2,2020-11-11 11:11:11,How are you?", reader.readLine());
        assertEquals("2,2,3,2020-11-11 11:11:11,Hello!", reader.readLine());
    }

    @Test(timeout = 500)
    public void test_chatsWriter_1chats() throws IOException {
        Map<Integer, ChatResponseModel> chats = new HashMap<>();
        Chat chat1 = new Chat(1, 1, 2, "How are you?", "2020-11-11 11:11:11");
        chats.put(1, chat1.responseModel());
        csv.chatsWriter(chats, chatsPath);

        File csvFile = new File(chatsPath);
        BufferedReader reader = new BufferedReader(new FileReader(csvFile));
        assertEquals("id,user_id1,user_id2,time,content", reader.readLine());
        assertEquals("1,1,2,2020-11-11 11:11:11,How are you?", reader.readLine());
    }

    @Test(timeout = 500)
    public void test_chatsWriter_0chats() throws IOException {
        Map<Integer, ChatResponseModel> chats = new HashMap<>();
        csv.chatsWriter(chats, chatsPath);

        File csvFile = new File(chatsPath);
        BufferedReader reader = new BufferedReader(new FileReader(csvFile));
        assertEquals("id,user_id1,user_id2,time,content", reader.readLine());
    }

    @Test(timeout = 500)
    public void test_chatsWriter_3chats() throws IOException {
        Map<Integer, ChatResponseModel> chats = new HashMap<>();
        Chat chat1 = new Chat(1, 1, 2, "How are you?", "2020-11-11 11:11:11");
        Chat chat2 = new Chat(2, 2, 3, "Hello!", "2020-11-11 11:11:11");
        Chat chat3 = new Chat(3, 1, 3, "Good.", "2020-11-11 11:11:12");
        chats.put(1, chat1.responseModel());
        chats.put(2, chat2.responseModel());
        chats.put(3, chat3.responseModel());
        csv.chatsWriter(chats, chatsPath);

        File csvFile = new File(chatsPath);
        BufferedReader reader = new BufferedReader(new FileReader(csvFile));
        assertEquals("id,user_id1,user_id2,time,content", reader.readLine());
        assertEquals("1,1,2,2020-11-11 11:11:11,How are you?", reader.readLine());
        assertEquals("2,2,3,2020-11-11 11:11:11,Hello!", reader.readLine());
        assertEquals("3,1,3,2020-11-11 11:11:12,Good.", reader.readLine());
    }

    @Test(timeout = 500)
    public void test_chatsWriter_4chats() throws IOException {
        Map<Integer, ChatResponseModel> chats = new HashMap<>();
        Chat chat1 = new Chat(1, 1, 2, "How are you?", "2020-11-11 11:11:11");
        Chat chat2 = new Chat(2, 2, 3, "Hello!", "2020-11-11 11:11:11");
        Chat chat3 = new Chat(3, 1, 3, "Good.", "2020-11-11 11:11:12");
        Chat chat4 = new Chat(4, 2, 1, "Fine.", "2020-11-11 11:11:13");
        chats.put(1, chat1.responseModel());
        chats.put(2, chat2.responseModel());
        chats.put(3, chat3.responseModel());
        chats.put(4, chat4.responseModel());
        csv.chatsWriter(chats, chatsPath);

        File csvFile = new File(chatsPath);
        BufferedReader reader = new BufferedReader(new FileReader(csvFile));
        assertEquals("id,user_id1,user_id2,time,content", reader.readLine());
        assertEquals("1,1,2,2020-11-11 11:11:11,How are you?", reader.readLine());
        assertEquals("2,2,3,2020-11-11 11:11:11,Hello!", reader.readLine());
        assertEquals("3,1,3,2020-11-11 11:11:12,Good.", reader.readLine());
        assertEquals("4,2,1,2020-11-11 11:11:13,Fine.", reader.readLine());
    }
}