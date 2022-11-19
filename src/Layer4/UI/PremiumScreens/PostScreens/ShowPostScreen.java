package Layer4.UI.PremiumScreens.PostScreens;

import Layer3.Controller.LikeController;
import Layer3.Presenter.PostPresenter;
import Layer4.UI.Components.PlaceButton;
import Layer4.UI.Components.PlaceLabel;
import Layer4.UI.PremiumScreens.PostScreens.CommentScreens.ShowCommentScreen;

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
 * It takes a postId and present the {@link Layer1.Entity.Post Post} object's attributes.</p>
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

        JButton likeButton = new PlaceButton().create("Like", null,
                650, 60, 100, 25);
        likeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LikeController likeController = new LikeController();
                try {
                    likeController.likePost(postId, userId);
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        this.add(likeButton);

        JButton showCommentsButton = new PlaceButton().create("Show Comments", null,
                    600, 675, 130, 25);
        ArrayList<Object> finalLabels = labels;
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


        JButton backButton = new PlaceButton().create("Back", null,
                    100, 675, 100, 25);
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PostScreen postScreen = null;
                try {
                    postScreen = new PostScreen(userId, name);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                postScreen.setVisible(true);
                dispose();
            }
        });
        this.add(backButton);
        BufferedImage logo = ImageIO.read(new File("assets/images/background.png"));
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
