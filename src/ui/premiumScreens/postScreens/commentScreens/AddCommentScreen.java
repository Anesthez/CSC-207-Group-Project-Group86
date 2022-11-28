package ui.premiumScreens.postScreens.commentScreens;

import controller.CommentController;
import ui.components.PlaceButton;
import ui.components.PlaceLabel;
import ui.components.PlaceTextArea;
import entity.Comment;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * <p>
 *     AddCommentScreen is a screen where the user can add their {@link Comment Comment}
 *     AddCommentScreen extends {@link JFrame JFrame} and implements {@link ActionListener ActionListener}
 * </p>
 * @Author: LemengDai
 */
public class AddCommentScreen extends JFrame {

    /**
     * <p>
     *     initialize AddCommentScreen with user id.
     * </p>
     * @param userid
     */
    public AddCommentScreen(int userid, int postId, String username) throws IOException {

        JLabel commentContentLabel = new PlaceLabel().create(50,100, 200,30, "Comment Content");
        JTextArea commentContentText = new PlaceTextArea().create(50,150, 500,200, null);

        JButton addComment = new PlaceButton().create("Add Comment",null,100, 700, 150, 50);
        JButton cancel = new PlaceButton().create("Cancel",null,300, 700, 150, 50);

        //When the user clicks Add Comment button, a Comment object with user input as content and user id is created
        addComment.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                try {
                    CommentController commentController =
                            new CommentController(commentContentText.getText(), userid, postId);
                    commentController.create();
                    JOptionPane.showMessageDialog(null, String.format("%s created.",
                            commentContentText.getText()));
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e.getMessage());
                }
            }
        });
        //When the user clicks Cancel, AddActionScreen is closed
        cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Click " + e.getActionCommand());
                ShowCommentScreen showCommentScreen = null;
                try {
                    showCommentScreen = new ShowCommentScreen(userid, postId,username);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                showCommentScreen.setVisible(true);
                dispose();
            }
        });
        this.setLayout(null);


        BufferedImage logo = ImageIO.read(new File("assets/images/background.png"));
        ImageIcon imageIcon = new ImageIcon(logo);
        JLabel label = new JLabel(imageIcon);
        label.setSize(960, 540);
        Container container = getContentPane();
        container.add(label);
        this.setSize(960, 540);

        this.add(new PlaceLabel().create(400, 50, 100, 25, "UofTMeta"));
        this.add(commentContentLabel);
        this.add(commentContentText);
        this.add(addComment);
        this.add(cancel);
        this.setResizable(false);
    }

}


