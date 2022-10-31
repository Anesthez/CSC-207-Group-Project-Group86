package repositories;

import Entity.Comment;
import junit.framework.TestCase;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CommentManagerTest extends TestCase {

    public void setUp() throws Exception {
        super.setUp();
    }

    public void tearDown() throws Exception {
    }

    public void testAddComment() {
        CommentManager manager = new CommentManager(new HashMap<>());
        manager.addComment(5, "Nice Picture!");
        Comment comment = manager.getCommentFromId(1);
        String actual = "Nice Picture!";
        String expected = comment.getContent();
        assertEquals("There is error in CommentManager.addComment!", actual, expected);
    }

    public void testDeleteComment() {
        CommentManager manager = new CommentManager(new HashMap<>());
        manager.addComment(5, "Nice Picture!");
        manager.addComment(0, "Hello World!");
        manager.deleteComment(1);
        Comment actual = manager.getCommentFromId(1);
        assertEquals("There is error in CommentManager.deleteComment!", actual, null);
    }

    public void testGetCommentFromId() {
        CommentManager manager = new CommentManager(new HashMap<>());
        manager.addComment(5, "Nice Picture!");
        manager.addComment(0, "Hello World!");
        Comment comment = manager.getCommentFromId(2);
        String actual = comment.getContent();
        String expected = "Hello World!";
        assertEquals("There is error in CommentManager.getCommentFromId!", actual, expected);
    }
}