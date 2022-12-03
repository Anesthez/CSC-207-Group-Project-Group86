package ui.premiumScreens.postScreens.commentScreens;

import presenter.CommentPresenter;
import ui.components.PlaceButton;
import ui.components.PlaceLabel;
import ui.premiumScreens.postScreens.PostScreen;
import entity.Comment;
import entity.Post;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 * <p>
 *     ShowCommentScreen is a screen where the user can view {@link Comment Comments} of a
 *     {@link Post Post}
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
    public ShowCommentScreen(int userid, int postId, String username) throws IOException {
        JLabel title = new PlaceLabel().create(50,100, 200,30, "Comments Section");

        JButton addComment = new PlaceButton().create("Add Comment",null,680, 100, 150, 50);
        JButton cancel = new PlaceButton().create(null,null,0, 0, 45, 45);
        Icon backIcon = new ImageIcon("assets/images/back.png");
        cancel.setIcon(backIcon);
        JScrollPane jScrollPane = new JScrollPane(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
                                                  ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane.setBounds(130, 150, 700, 300);
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
                } catch (IOException | FontFormatException ex) {
                    throw new RuntimeException(ex);
                }
                postScreen.setVisible(true);
                dispose();
            }
        });

        this.setLayout(null);


        BufferedImage logo = ImageIO.read(new File("assets/images/backgroundtrans.png"));
        ImageIcon imageIcon = new ImageIcon(logo);
        JLabel label = new JLabel(imageIcon);
        label.setSize(960, 540);
        this.setSize(960, 540);

        this.add(new PlaceLabel().create(400, 50, 100, 25, "UofTMeta"));
        this.add(title);
        this.add(addComment);
        this.add(cancel);
        this.add(jScrollPane);
        Container container = getContentPane();
        container.add(label);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
    }

}
