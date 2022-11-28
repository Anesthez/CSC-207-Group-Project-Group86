package Layer3.Presenter;

import Layer4.Interface.csvInterface;
import Model.Request.CommentRequestModel;
import Model.Request.UserRequestModel;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Map;

/**
 * <p>CommentPresenter is responsible for getting a list of {@link Layer1.Entity.Comment Comment} with username
 * who posts these comments corresponding to a post and then transform them into a single {@link StringBuilder String}
 * which can be displayed later in {@link Layer4.UI.Screens.PostScreens.CommentScreens.ShowCommentScreen} ShowCommentScreen.</p>
 */
public class CommentPresenter {

    /**
     * <p> responsible for getting a list of {@link Layer1.Entity.Comment Comment} with username who posts these comments
     *  corresponding to a post and then transform them into a single {@link StringBuilder String} and return it
     *  which can be displayed later in {@link Layer4.UI.Screens.PostScreens.CommentScreens.ShowCommentScreen}
     *  ShowCommentScreen.</p>
     * @param postId postId
     * @return a string representation of a list of {@link Layer1.Entity.Comment Comment} with username who posts these
     * comments corresponding to a post
     */
    public ArrayList<String> presentComment(int postId) {
        csvInterface csvInteract = new csvInterface();
        ArrayList<String> commentList = new ArrayList<>();
        try {
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
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return commentList;
    }
}
