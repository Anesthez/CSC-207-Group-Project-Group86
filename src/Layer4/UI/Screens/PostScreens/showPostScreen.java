package Layer4.UI.Screens.PostScreens;

import Layer3.Controller.PostController;
import Layer3.Presenter.PostPresenter;
import Layer4.UI.Components.PlaceButton;
import Layer4.UI.Components.PlaceLabel;

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
    public showPostScreen(int postId) throws Exception {
        //TODO: change coordinates and sizes
        PostPresenter postPresenter = new PostPresenter();
        ArrayList<Object> labels = new ArrayList<>();
        labels = postPresenter.showPost(postId);
        this.add(new PlaceLabel().create(50, 0, 50, 50, labels.get(0).toString()));
        this.add(new PlaceLabel().create(50, 100, 50, 50, labels.get(1).toString()));
        this.add(new PlaceLabel().create(50, 200, 50, 50, labels.get(2).toString()));
        this.add(new PlaceLabel().create(50, 300, 50, 50, labels.get(3).toString()));
        this.add(new PlaceLabel().create(50, 100, 50, 50, labels.get(4).toString()));
        JButton showCommentsButton = new PlaceButton().create("Show Comments", null,
                    650, 675, 100, 50);
        showCommentsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //TODO: call show comments screen
            }
        });
        this.add(showCommentsButton);


        JButton backButton = new PlaceButton().create("Back", null,
                    650, 675, 100, 50);
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //TODO: jump back to the previous screen
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
