package Interface;


import Layer1.Entity.Comment;
import Layer4.Interface.csvInterface;

import Model.Request.CommentRequestModel;
import Model.Response.CommentResponseModel;
import org.junit.Test;
import Layer4.Interface.csvInterface;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

/**
 * This class is used to test commentsWriter method in csvInterface class
 *
 * @Author: Yijun(Kevin) Zhao
 */

public class csvInterfaceTests_comments_writer {
    csvInterface csv = new csvInterface();
    String commentsPath = "test/Interface/test_comments.csv";

    @Test(timeout = 500)
    public void test_commentsWriter_3comments() throws IOException {
        Map<Integer, CommentResponseModel> comments = new HashMap<>();
        Comment comment1 = new Comment(1, 1, "comment1", "2020-01-01 00:00:00",1);
        Comment comment2 = new Comment(1, 2, "comment2", "2020-01-01 00:00:00", 1);
        Comment comment3 = new Comment(2, 3, "comment3", "2020-01-01 00:00:00", 2);
        comments.put(1, comment1.responseModel());
        comments.put(2, comment2.responseModel());
        comments.put(3, comment3.responseModel());
        csv.commentsWriter(comments, commentsPath);

        File csvFile = new File(commentsPath);
        BufferedReader reader = new BufferedReader(new FileReader(csvFile));
        assertEquals("id,user_id,time,content,post_id", reader.readLine());
        assertEquals("1,1,2020-01-01 00:00:00,comment1,1", reader.readLine());
        assertEquals("2,1,2020-01-01 00:00:00,comment2,1", reader.readLine());
        assertEquals("3,2,2020-01-01 00:00:00,comment3,2", reader.readLine());
    }

    @Test(timeout = 500)
    public void test_commentsWriter_0comments() throws IOException {
        Map<Integer, CommentResponseModel> comments = new HashMap<>();
        csv.commentsWriter(comments, commentsPath);

        File csvFile = new File(commentsPath);
        BufferedReader reader = new BufferedReader(new FileReader(csvFile));
        assertEquals("id,user_id,time,content,post_id", reader.readLine());
    }

    @Test(timeout = 500)
    public void test_commentsWriter_1comment() throws IOException {
        Map<Integer, CommentResponseModel> comments = new HashMap<>();
        Comment comment1 = new Comment(1, 1, "comment1", "2020-01-01 00:00:00",1);
        comments.put(1, comment1.responseModel());
        csv.commentsWriter(comments, commentsPath);

        File csvFile = new File(commentsPath);
        BufferedReader reader = new BufferedReader(new FileReader(csvFile));
        assertEquals("id,user_id,time,content,post_id", reader.readLine());
        assertEquals("1,1,2020-01-01 00:00:00,comment1,1", reader.readLine());
    }
}