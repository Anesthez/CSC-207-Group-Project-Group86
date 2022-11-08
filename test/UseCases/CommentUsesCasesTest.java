package UseCases;

import Layer1.Entity.Comment;
import Layer2.UseCases.CommentUseCases;
import junit.framework.TestCase;

import java.util.HashMap;

public class CommentUsesCasesTest extends TestCase {

    public void setUp() throws Exception {
        super.setUp();
    }

    public void tearDown() throws Exception {
    }

    public void testAddComment() {
        CommentUseCases manager = new CommentUseCases(new HashMap<>());
        manager.addComment(5, "Nice Picture!");
        Comment comment = manager.getCommentFromId(1);
        String actual = "Nice Picture!";
        String expected = comment.getContent();
        assertEquals("There is error in CommentManager.addComment!", actual, expected);
    }

    public void testDeleteComment() {
        CommentUseCases manager = new CommentUseCases(new HashMap<>());
        manager.addComment(5, "Nice Picture!");
        manager.addComment(0, "Hello World!");
        manager.deleteComment(1);
        Comment actual = manager.getCommentFromId(1);
        assertEquals("There is error in CommentManager.deleteComment!", actual, null);
    }

    public void testGetCommentFromId() {
        CommentUseCases manager = new CommentUseCases(new HashMap<>());
        manager.addComment(5, "Nice Picture!");
        manager.addComment(0, "Hello World!");
        Comment comment = manager.getCommentFromId(2);
        String actual = comment.getContent();
        String expected = "Hello World!";
        assertEquals("There is error in CommentManager.getCommentFromId!", actual, expected);
    }
}