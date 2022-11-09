package Layer3.Controller;

import Layer1.Entity.Comment;
import Layer1.Entity.Post;
import Layer2.UseCases.CommentUseCases;
import Layer4.Interface.csvInterface;

import java.io.IOException;
import java.util.Map;

/**
 * <p>
 *     CommentController contains user comment and user id.
 * </p>
 * @Author: LemengDai
 */
public class CommentController {
    String inputLines;
    int userid;

    /**
     * <p>initialize CommentController with user input and user id</p>
     * @param inputLines
     * @param userid
     */
    public CommentController(String inputLines, int userid){
        this.inputLines = inputLines;
        this.userid = userid;
    }

    /**
     * adds {@link Comment Comment} object with user input as content and user id.
     * @throws IOException
     */
    public void create() throws IOException {
        csvInterface csvInteract = new csvInterface();
        Map<Integer, Comment> comments = csvInteract.commentsReader("database/comments.csv");
        CommentUseCases commentUseCases = new CommentUseCases(comments);
        commentUseCases.addComment(userid, inputLines); //TODO: no postid in args?
        csvInteract.commentsWriter(comments, "database/comments.csv");
    }
}
