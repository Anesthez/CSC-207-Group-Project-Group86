package Layer4.UI.Screens.PostScreens.CommentScreens;

import Layer3.Presenter.CommentPresenter;
import Layer4.Interface.csvInterface;
import Layer4.UI.Components.PlaceButton;
import Layer4.UI.Components.PlaceLabel;
import Layer4.UI.Screens.PostScreens.PostScreen;
import Model.Request.CommentRequestModel;
import Model.Request.UserRequestModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

/**
 * <p>
 *     ShowCommentScreen is a screen where the user can view {@link Layer1.Entity.Comment Comments} of a
 *     {@link Layer1.Entity.Post Post}
 *     ShowCommentScreen extends {@link JFrame JFrame} and implements {@link ActionListener ActionListener}
 * </p>
 * @Author: LemengDai
 */
public class ShowCommentScreen extends JFrame{
    /**
     * <p>
     *     initialize ShowCommentScreen with user id.
     * </p>
     * @param userid
     */
    public ShowCommentScreen(int userid, int postId, String username) {
        JLabel title = new PlaceLabel().create(50,100, 200,30, "Comments Section");

        JButton addComment = new PlaceButton().create("Add Comment",null,100, 700, 150, 50);
        JButton cancel = new PlaceButton().create("Cancel",null,300, 700, 150, 50);
        JScrollPane jScrollPane = new JScrollPane(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
                                                  ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane.setBounds(50, 150, 700, 400);
        JPanel jPanel = new JPanel();
        ArrayList<String> strings = new CommentPresenter().presentComment(postId);
        jPanel.setLayout(new GridLayout(strings.size(), 1));
        jPanel.setSize(700, 2000);
        int i = 0;
        for (String s: new CommentPresenter().presentComment(postId)) {

            JLabel label = new JLabel(s);
            label.setSize(700, 40);
            jPanel.add(label);
            i +=1;
        }
        jScrollPane.setViewportView(jPanel);
        //When the user clicks Add Comment button, AddCommentScreen is shown
        addComment.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                try {
                    AddCommentScreen addCommentScreen = new AddCommentScreen(userid, postId, username);
                    addCommentScreen.setVisible(true);
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e.getMessage());
                }
            }
        });

        cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PostScreen postScreen = null;
                try {
                    postScreen = new PostScreen(userid, username);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                postScreen.setVisible(true);
                dispose();
            }
        });

        this.setLayout(null);


        this.setSize(800, 800);

        this.add(new PlaceLabel().create(400, 50, 100, 25, "UofTMeta"));
        this.add(title);
        this.add(addComment);
        this.add(cancel);
        this.add(jScrollPane);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}
