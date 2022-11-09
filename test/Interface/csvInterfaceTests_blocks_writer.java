package Interface;

import Layer4.Interface.csvInterface;
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
 * This class is used to test blocksWriter method in csvInterface class
 *
 * @Author: Yijun(Kevin) Zhao
 */

public class csvInterfaceTests_blocks_writer {
    csvInterface csv = new csvInterface();
    String blocksPath = "test/Interface/test_blocks.csv";

    @Test(timeout = 500)
    public void test_blocksWriter_1user3blocks() throws IOException {
        Map<Integer, ArrayList<Integer>> blocks = new HashMap<>();
        ArrayList<Integer> blocks_iDs = new ArrayList<>();
        blocks_iDs.add(2);
        blocks_iDs.add(3);
        blocks_iDs.add(4);
        blocks.put(1, blocks_iDs);
        csv.blocksWriter(blocksPath, blocks);

        File csvFile = new File(blocksPath);
        BufferedReader reader = new BufferedReader(new FileReader(csvFile));
        assertEquals("userid,list-blockedIds", reader.readLine());
        assertEquals("1,2 3 4", reader.readLine());
    }

    @Test(timeout = 500)
    public void test_blocksWriter_2user4blocks() throws IOException {
        Map<Integer, ArrayList<Integer>> blocks = new HashMap<>();
        ArrayList<Integer> blocks_iDs = new ArrayList<>();
        blocks_iDs.add(2);
        blocks_iDs.add(3);
        blocks_iDs.add(4);
        blocks_iDs.add(5);
        blocks.put(1, blocks_iDs);
        ArrayList<Integer> blocks_iDs2 = new ArrayList<>();
        blocks_iDs2.add(1);
        blocks_iDs2.add(88);
        blocks_iDs2.add(99);
        blocks_iDs2.add(1111);
        blocks.put(5, blocks_iDs2);
        csv.blocksWriter(blocksPath, blocks);

        File csvFile = new File(blocksPath);
        BufferedReader reader = new BufferedReader(new FileReader(csvFile));
        assertEquals("userid,list-blockedIds", reader.readLine());
        assertEquals("1,2 3 4 5", reader.readLine());
        assertEquals("5,1 88 99 1111", reader.readLine());
    }

    @Test(timeout = 500)
    public void test_blocksWriter_0user0blocks() throws IOException {
        Map<Integer, ArrayList<Integer>> blocks = new HashMap<>();
        csv.blocksWriter(blocksPath, blocks);

        File csvFile = new File(blocksPath);
        BufferedReader reader = new BufferedReader(new FileReader(csvFile));
        assertEquals("userid,list-blockedIds", reader.readLine());
    }

    @Test(timeout = 500)
    public void test_blocksReader_1user3blocks() throws IOException {
        Map<Integer, ArrayList<Integer>> blocks = new HashMap<>();
        ArrayList<Integer> blocks_iDs = new ArrayList<>();
        blocks_iDs.add(2);
        blocks_iDs.add(3);
        blocks_iDs.add(4);
        blocks.put(1, blocks_iDs);
        csv.blocksWriter(blocksPath, blocks);

        Map<Integer, ArrayList<Integer>> blocks2 = csv.blocksReader(blocksPath);
        assertEquals(blocks, blocks2);
    }

    @Test(timeout = 500)
    public void test_blocksReader_2user4blocks() throws IOException {
        Map<Integer, ArrayList<Integer>> blocks = new HashMap<>();
        ArrayList<Integer> blocks_iDs = new ArrayList<>();
        blocks_iDs.add(2);
        blocks_iDs.add(3);
        blocks_iDs.add(4);
        blocks_iDs.add(5);
        blocks.put(1, blocks_iDs);
        ArrayList<Integer> blocks_iDs2 = new ArrayList<>();
        blocks_iDs2.add(1);
        blocks_iDs2.add(88);
        blocks_iDs2.add(99);
        blocks_iDs2.add(1111);
        blocks.put(5, blocks_iDs2);
        csv.blocksWriter(blocksPath, blocks);

        Map<Integer, ArrayList<Integer>> blocks2 = csv.blocksReader(blocksPath);
        assertEquals(blocks, blocks2);
    }

    @Test(timeout = 500)
    public void test_blocksReader_0user0blocks() throws IOException {
        Map<Integer, ArrayList<Integer>> blocks = new HashMap<>();
        csv.blocksWriter(blocksPath, blocks);

        Map<Integer, ArrayList<Integer>> blocks2 = csv.blocksReader(blocksPath);
        assertEquals(blocks, blocks2);
    }

}