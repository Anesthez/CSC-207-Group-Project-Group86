package UseCases;

import entity.Comment;
import useCases.UseCaseFacade.CommentUseCasesFacade;
import junit.framework.TestCase;

import java.util.HashMap;

public class CommentUsesCasesTest extends TestCase {

    public void setUp() throws Exception {
        super.setUp();
    }

    public void tearDown() throws Exception {
    }

    public void testAddComment() {
        CommentUseCasesFacade manager = new CommentUseCasesFacade(new HashMap<>());
        manager.addComment(5, "Nice Picture!", 1);
        Comment comment = manager.getCommentFromId(1);
        String actual = "Nice Picture!";
        String expected = comment.getContent();
        assertEquals("There is error in CommentManager.addComment!", actual, expected);
    }

    public void testDeleteComment() {
        CommentUseCasesFacade manager = new CommentUseCasesFacade(new HashMap<>());
        manager.addComment(5, "Nice Picture!",1);
        manager.addComment(0, "Hello World!", 2);
        manager.deleteComment(1);
        Comment actual = manager.getCommentFromId(1);
        assertEquals("There is error in CommentManager.deleteComment!", actual, null);
    }

    public void testGetCommentFromId() {
        CommentUseCasesFacade manager = new CommentUseCasesFacade(new HashMap<>());
        manager.addComment(5, "Nice Picture!",1);
        manager.addComment(0, "Hello World!",2);
        Comment comment = manager.getCommentFromId(2);
        String actual = comment.getContent();
        String expected = "Hello World!";
        assertEquals("There is error in CommentManager.getCommentFromId!", actual, expected);
    }
}