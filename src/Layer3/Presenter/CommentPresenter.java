package Layer3.Presenter;

import Layer4.Interface.csvInterface;
import Model.Request.CommentRequestModel;
import Model.Request.UserRequestModel;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Map;

public class CommentPresenter {

    public StringBuilder presentComment(int postId) {
        csvInterface csvInteract = new csvInterface();
        StringBuilder commentList = new StringBuilder();
        try {
            Map<Integer, CommentRequestModel> comments = csvInteract.commentsReader("database/comments.csv");
            Map<Integer, UserRequestModel> users = csvInteract.usersReader("database/user.csv");
            for (CommentRequestModel c:comments.values()) {
                ArrayList<Object> param = c.get();
                if ((Integer)param.get(4) == postId) {
                    String username = (String) users.get((Integer) param.get(0)).get().get(2);
                    String comment = (String) param.get(2);
                    commentList.append(username).append("/n").append(comment).append("/n");
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return commentList;
    }
}
