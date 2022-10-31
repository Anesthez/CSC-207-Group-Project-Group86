package Interface;

import org.junit.*;

import java.io.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;


public class csvInterfaceTests_friends {
    csvInterface csv = new csvInterface();
    String friendsPath = "test/Interface/test_friends.csv";

    @Test(timeout = 500)
    public void test_friendsWriter_1user3friends() throws IOException {
        Map<Integer, ArrayList<Integer>> friends = new HashMap<>();
        ArrayList<Integer> friends_iDs = new ArrayList<>();
        friends_iDs.add(2);
        friends_iDs.add(3);
        friends_iDs.add(4);
        friends.put(1, friends_iDs);
        csv.friendsWriter(friendsPath, friends);

        File csvFile = new File(friendsPath);
        BufferedReader reader = new BufferedReader(new FileReader(csvFile));
        assertEquals("userid,list-friendIds", reader.readLine());
        assertEquals("1,2 3 4", reader.readLine());
    }

    @Test(timeout = 500)
    public void test_friendsWriter_2user4friends() throws IOException {
        Map<Integer, ArrayList<Integer>> friends = new HashMap<>();
        ArrayList<Integer> friends_iDs = new ArrayList<>();
        friends_iDs.add(2);
        friends_iDs.add(3);
        friends_iDs.add(4);
        friends_iDs.add(5);
        friends.put(1, friends_iDs);
        ArrayList<Integer> friends_iDs2 = new ArrayList<>();
        friends_iDs2.add(1);
        friends_iDs2.add(88);
        friends_iDs2.add(99);
        friends_iDs2.add(1111);
        friends.put(5, friends_iDs2);
        csv.friendsWriter(friendsPath, friends);

        File csvFile = new File(friendsPath);
        BufferedReader reader = new BufferedReader(new FileReader(csvFile));
        assertEquals("userid,list-friendIds", reader.readLine());
        assertEquals("1,2 3 4 5", reader.readLine());
        assertEquals("5,1 88 99 1111", reader.readLine());
    }

    @Test(timeout = 500)
    public void test_friendsWriter_0user0friends() throws IOException {
        Map<Integer, ArrayList<Integer>> friends = new HashMap<>();
        csv.friendsWriter(friendsPath, friends);

        File csvFile = new File(friendsPath);
        BufferedReader reader = new BufferedReader(new FileReader(csvFile));
        assertEquals("userid,list-friendIds", reader.readLine());
    }

    @Test(timeout = 500)
    public void test_friendsReader_1user3friends() throws IOException {
        Map<Integer, ArrayList<Integer>> friends = new HashMap<>();
        ArrayList<Integer> friends_iDs = new ArrayList<>();
        friends_iDs.add(2);
        friends_iDs.add(3);
        friends_iDs.add(4);
        friends.put(1, friends_iDs);
        csv.friendsWriter(friendsPath, friends);

        Map<Integer, ArrayList<Integer>> friends2 = csv.friendsReader(friendsPath);
        assertEquals(friends, friends2);
    }

    @Test(timeout = 500)
    public void test_friendsReader_2user4friends() throws IOException {
        Map<Integer, ArrayList<Integer>> friends = new HashMap<>();
        ArrayList<Integer> friends_iDs = new ArrayList<>();
        friends_iDs.add(2);
        friends_iDs.add(3);
        friends_iDs.add(4);
        friends_iDs.add(5);
        friends.put(1, friends_iDs);
        ArrayList<Integer> friends_iDs2 = new ArrayList<>();
        friends_iDs2.add(1);
        friends_iDs2.add(88);
        friends_iDs2.add(99);
        friends_iDs2.add(1111);
        friends.put(5, friends_iDs2);
        csv.friendsWriter(friendsPath, friends);

        Map<Integer, ArrayList<Integer>> friends2 = csv.friendsReader(friendsPath);
        assertEquals(friends, friends2);
    }

    @Test(timeout = 500)
    public void test_friendsReader_0user0friends() throws IOException {
        Map<Integer, ArrayList<Integer>> friends = new HashMap<>();
        csv.friendsWriter(friendsPath, friends);

        Map<Integer, ArrayList<Integer>> friends2 = csv.friendsReader(friendsPath);
        assertEquals(friends, friends2);
    }

}