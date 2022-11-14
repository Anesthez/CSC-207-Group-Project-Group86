package Layer4.UI.Screens.PostScreens;

import Layer3.Presenter.PostPresenter;
import Layer4.UI.Components.PlaceButton;
import Layer4.UI.Components.PlaceLabel;
import Layer4.UI.Screens.PostScreens.CommentScreens.ShowCommentScreen;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * <p>This class is the UI for showing post.
 * It takes a postId and present the {@link Layer1.Entity.Post Post} object's attributes.</p>
 *
 * @author Kevin Wu
 */
public class showPostScreen extends JFrame implements ActionListener {
    public showPostScreen(int postId, int userId, String name) throws Exception {
        PostPresenter postPresenter = new PostPresenter();
        ArrayList<Object> labels = new ArrayList<>();
        labels = postPresenter.showPost(postId);
        this.add(new PlaceLabel().create(100, 50, 50, 50, "Title: "));
        this.add(new PlaceLabel().create(150, 50, 200, 50, labels.get(0).toString()));
        this.add(new PlaceLabel().create(700, 25, 100, 50, "PostID: "));
        this.add(new PlaceLabel().create(750, 25, 200, 50, labels.get(1).toString()));
        this.add(new PlaceLabel().create(350, 50, 200, 50, labels.get(2).toString()));
        this.add(new PlaceLabel().create(575, 50, 100, 50, "Likes: "));
        this.add(new PlaceLabel().create(615, 50, 200, 50, labels.get(3).toString()));
        this.add(new PlaceLabel().create(100, 125, 600, 600, labels.get(4).toString()));
        JButton showCommentsButton = new PlaceButton().create("Show Comments", null,
                    600, 675, 125, 50);
        showCommentsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ShowCommentScreen showCommentScreen = new ShowCommentScreen(userId);
                showCommentScreen.setVisible(true);
                dispose();
            }
        });
        this.add(showCommentsButton);


        JButton backButton = new PlaceButton().create("Back", null,
                    100, 675, 100, 50);
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PostScreen postScreen = new PostScreen(userId, name);
                postScreen.setVisible(true);
                dispose();
            }
        });
        this.add(backButton);

        this.setSize(800, 800);
        this.setLayout(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
