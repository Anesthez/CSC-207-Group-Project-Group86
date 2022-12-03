package controller;

import useCases.UseCaseFacade.CommentUseCasesFacade;
import databaseInterface.CsvInterface;
import model.request.CommentRequestModel;
import entity.Comment;

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
     * @param inputLines inputLines
     * @param userid userid
     */
    public CommentController(String inputLines, int userid, int postId){
        this.inputLines = inputLines;
        this.userid = userid;
        this.postId = postId;
    }

    /**
     * adds {@link Comment Comment} object with user input as content and user id.
     */
    public void create() throws IOException {
        CsvInterface csvInteract = new CsvInterface();
        Map<Integer, CommentRequestModel> comments = csvInteract.commentsReader("database/comments.csv");
        CommentUseCasesFacade commentUseCases = new CommentUseCasesFacade(comments);
        commentUseCases.addComment(userid, inputLines, postId); //TODO: no postid in args?

        csvInteract.commentsWriter(commentUseCases.getComments(), "database/comments.csv");
    }
}
