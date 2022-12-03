package ui.premiumScreens.postScreens;

import controller.LikeController;
import presenter.PostPresenter;
import ui.components.PlaceButton;
import ui.components.PlaceLabel;
import ui.premiumScreens.postScreens.commentScreens.ShowCommentScreen;
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
 * <p>This class is the UI for showing post.
 * It takes a postId and present the {@link Post Post} object's attributes.</p>
 *
 * @author Kevin Wu
 */
public class ShowPostScreen extends JFrame implements ActionListener {
    public ShowPostScreen(int postId, int userId, String name) throws Exception {
        PostPresenter postPresenter = new PostPresenter();
        ArrayList<Object> labels = new ArrayList<>();
        labels = postPresenter.showPost(postId);
        this.add(new PlaceLabel().create(100, 50, 50, 50, "Title: "));
        this.add(new PlaceLabel().create(150, 50, 200, 50, labels.get(0).toString()));
        this.add(new PlaceLabel().create(650, 15, 100, 50, "PostID: "));
        this.add(new PlaceLabel().create(700, 15, 200, 50, labels.get(1).toString()));
        this.add(new PlaceLabel().create(350, 50, 200, 50, labels.get(2).toString()));
        this.add(new PlaceLabel().create(575, 50, 100, 50, "Likes: "));
        this.add(new PlaceLabel().create(615, 50, 200, 50, labels.get(3).toString()));
        this.add(new PlaceLabel().create(100, 125, 600, 600, labels.get(4).toString()));


        Icon likeIcon = new ImageIcon("assets/images/liked.png");
        Icon unlikeIcon = new ImageIcon("assets/images/unlike.png");
        JButton likeButton = new PlaceButton().create(null, null,
                650, 60, 45, 45);
        likeButton.setIcon(unlikeIcon);
        likeButton.addActionListener(e -> {
            LikeController likeController = new LikeController();
            try {
                likeController.likePost(postId, userId);
                likeButton.setIcon(likeIcon);
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        });
        this.add(likeButton);

        Icon commentIcon = new ImageIcon("assets/images/comment.png");
        JButton showCommentsButton = new PlaceButton().create(null, null,
                    695, 60, 45, 45);
        ArrayList<Object> finalLabels = labels;
        showCommentsButton.setIcon(commentIcon);
        showCommentsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ShowCommentScreen showCommentScreen = null;
                try {
                    showCommentScreen = new ShowCommentScreen(userId,(Integer) finalLabels.get(1), name);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                showCommentScreen.setVisible(true);
                dispose();
            }
        });
        this.add(showCommentsButton);

        Icon backIcon = new ImageIcon("assets/images/back.png");
        JButton backButton = new JButton();
        backButton.setBounds(0, 0, 45, 45);
        backButton.setIcon(backIcon);
        backButton.addActionListener(e -> {
            PostScreen postScreen = null;
            try {
                postScreen = new PostScreen(userId, name);
            } catch (IOException | FontFormatException ex) {
                throw new RuntimeException(ex);
            }
            postScreen.setVisible(true);
            dispose();
        });
        this.add(backButton);
        BufferedImage logo = ImageIO.read(new File("assets/images/backgroundtrans.png"));
        ImageIcon imageIcon = new ImageIcon(logo);
        JLabel label = new JLabel(imageIcon);
        label.setSize(960, 540);
        Container container = getContentPane();
        container.add(label);
        this.setSize(960, 540);
        this.setLayout(null);
        this.setResizable(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
