package Interface;

import Entity.Comment;
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

public class csvInterfaceTests_comments_writer {
    csvInterface csv = new csvInterface();
    String commentsPath = "test/Interface/test_comments.csv";

    @Test(timeout = 500)
    public void test_commentsWriter_3comments() throws IOException {
        Map<Integer, Comment> comments = new HashMap<>();
        Comment comment1 = new Comment(1, 1, "comment1", "2020-01-01 00:00:00");
        Comment comment2 = new Comment(1, 2, "comment2", "2020-01-01 00:00:00");
        Comment comment3 = new Comment(2, 3, "comment3", "2020-01-01 00:00:00");
        comments.put(1, comment1);
        comments.put(2, comment2);
        comments.put(3, comment3);
        csv.commentsWriter(comments, commentsPath);

        File csvFile = new File(commentsPath);
        BufferedReader reader = new BufferedReader(new FileReader(csvFile));
        assertEquals("id,user_id,time,content", reader.readLine());
        assertEquals("1,1,2020-01-01 00:00:00,comment1", reader.readLine());
        assertEquals("2,1,2020-01-01 00:00:00,comment2", reader.readLine());
        assertEquals("3,2,2020-01-01 00:00:00,comment3", reader.readLine());
    }

    @Test(timeout = 500)
    public void test_commentsWriter_0comments() throws IOException {
        Map<Integer, Comment> comments = new HashMap<>();
        csv.commentsWriter(comments, commentsPath);

        File csvFile = new File(commentsPath);
        BufferedReader reader = new BufferedReader(new FileReader(csvFile));
        assertEquals("id,user_id,time,content", reader.readLine());
    }

    @Test(timeout = 500)
    public void test_commentsWriter_1comment() throws IOException {
        Map<Integer, Comment> comments = new HashMap<>();
        Comment comment1 = new Comment(1, 1, "comment1", "2020-01-01 00:00:00");
        comments.put(1, comment1);
        csv.commentsWriter(comments, commentsPath);

        File csvFile = new File(commentsPath);
        BufferedReader reader = new BufferedReader(new FileReader(csvFile));
        assertEquals("id,user_id,time,content", reader.readLine());
        assertEquals("1,1,2020-01-01 00:00:00,comment1", reader.readLine());
    }
}