package presenter;

import databaseInterface.CsvInterface;
import model.request.CommentRequestModel;
import model.request.UserRequestModel;
import entity.Comment;
import ui.screens.postScreens.CommentScreens.ShowCommentScreen;

import javax.swing.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

/**
 * <p>CommentPresenter is responsible for getting a list of {@link Comment Comment} with username
 * who posts these comments corresponding to a post and then transform them into a single {@link StringBuilder String}
 * which can be displayed later in {@link ShowCommentScreen} ShowCommentScreen.</p>
 * @Author: LemengDai
 */
public class CommentPresenter {

    /**
     * <p> responsible for getting a list of {@link Comment Comment} with username who posts these comments
     *  corresponding to a post and then transform them into a single {@link StringBuilder String} and return it
     *  which can be displayed later in {@link ShowCommentScreen}
     *  ShowCommentScreen.</p>
     * @param postId postId
     * @return a string representation of a list of {@link Comment Comment} with username who posts these
     * comments corresponding to a post
     */
    public ArrayList<String> presentComment(int postId) throws IOException {
        CsvInterface csvInteract = new CsvInterface();
        ArrayList<String> commentList = new ArrayList<>();
        Map<Integer, CommentRequestModel> comments = csvInteract.commentsReader("database/comments.csv");
        Map<Integer, UserRequestModel> users = csvInteract.usersReader("database/user.csv");
        for (CommentRequestModel c:comments.values()) {
            ArrayList<Object> param = c.get();
            if ((Integer)param.get(4) == postId) {
                String username = (String) users.get((Integer) param.get(0)).get().get(2);
                String comment = (String) param.get(2);
                commentList.add(username + ": " + comment);
            }
        }
        return commentList;
    }
}
