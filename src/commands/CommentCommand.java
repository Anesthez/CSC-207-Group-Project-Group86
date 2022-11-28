package commands;

import databaseInterface.csvInterface;
import useCases.CommentUseCases;
import model.request.CommentRequestModel;
import entity.Comment;

import java.io.IOException;
import java.util.Map;

/**
 * <p>CommentCommand contains user input and user id</p>
 * @Author: WooooT
 */
public class CommentCommand {
    String[] inputLines;
    int userid;
    public CommentCommand(String[] inputLines, int userid){
        this.inputLines = inputLines;
        this.userid = userid;
    }

    /**
     * <p>parses user input and can be used to add or delete {@link Comment Comment}</p>
     */
    public void exact() throws IOException {
        csvInterface csvInteract = new csvInterface();
        Map<Integer, CommentRequestModel> comments = csvInteract.commentsReader("database/comments.csv");
        if (inputLines[1].equals("add")) {
            int commentid = Integer.parseInt(inputLines[2]);
            if (comments.containsKey(commentid)) {
                CommentUseCases commentUseCases = new CommentUseCases(comments);
                commentUseCases.addComment(userid, inputLines[3], Integer.parseInt(inputLines[3]));
                csvInteract.commentsWriter(commentUseCases.getComments(), "database/comments.csv");
            } else {
                System.out.println("post does not exist");
            }
        } else if (inputLines[1].equals("delete")) {
            int commentid = Integer.parseInt(inputLines[2]);
            if (comments.containsKey(commentid)) {
                CommentUseCases commentUseCases = new CommentUseCases(comments);
                commentUseCases.deleteComment(commentid);
                csvInteract.commentsWriter(commentUseCases.getComments(), "database/comments.csv");
            } else {
                System.out.println("comment does not exist");
            }
        } else {
            System.out.println("unknown command");
        }
    }
}
