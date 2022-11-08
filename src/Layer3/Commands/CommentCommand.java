package Layer3.Commands;

import Layer1.Entity.Comment;
import Layer1.Entity.Post;
import Layer4.Interface.csvInterface;
import Layer2.UseCases.CommentUseCases;

import java.io.IOException;
import java.util.Map;

/*
Author: WooooT
 */
public class CommentCommand {
    String[] inputLines;
    int userid;
    public CommentCommand(String[] inputLines, int userid){
        this.inputLines = inputLines;
        this.userid = userid;
    }

    public void exact() throws IOException {
        csvInterface csvInteract = new csvInterface();
        Map<Integer, Post> posts = csvInteract.postsReader("database/post.csv");
        Map<Integer, Comment> comments = csvInteract.commentsReader("database/comments.csv");
        if (inputLines[1].equals("add")) {
            int postid = Integer.parseInt(inputLines[2]);
            if (posts.containsKey(postid)) {
                CommentUseCases commentUseCases = new CommentUseCases(comments);
                commentUseCases.addComment(userid, inputLines[3]); //TODO: no postid in args?
                csvInteract.commentsWriter(comments, "database/comments.csv");
            } else {
                System.out.println("post does not exist");
            }
        } else if (inputLines[1].equals("delete")) {
            int commentid = Integer.parseInt(inputLines[2]);
            if (comments.containsKey(commentid)) {
                CommentUseCases commentUseCases = new CommentUseCases(comments);
                commentUseCases.deleteComment(commentid);
                csvInteract.commentsWriter(comments, "database/comments.csv");
            } else {
                System.out.println("comment does not exist");
            }
        } else {
            System.out.println("unknown command");
        }
    }
}
