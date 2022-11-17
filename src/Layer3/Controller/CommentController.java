package Layer3.Controller;

import Layer2.UseCases.CommentUseCases;
import Layer4.Interface.csvInterface;
import Model.Request.CommentRequestModel;

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
    int postId;

    /**
     * <p>initialize CommentController with user input and user id</p>
     * @param inputLines
     * @param userid
     */
    public CommentController(String inputLines, int userid, int postId){
        this.inputLines = inputLines;
        this.userid = userid;
        this.postId = postId;
    }

    /**
     * adds {@link Layer1.Entity.Comment Comment} object with user input as content and user id.
     * @throws IOException
     */
    public void create() throws IOException {
        csvInterface csvInteract = new csvInterface();
        Map<Integer, CommentRequestModel> comments = csvInteract.commentsReader("database/comments.csv");
        CommentUseCases commentUseCases = new CommentUseCases(comments);
        commentUseCases.addComment(userid, inputLines, postId); //TODO: no postid in args?

        csvInteract.commentsWriter(commentUseCases.getComments(), "database/comments.csv");
    }
}
