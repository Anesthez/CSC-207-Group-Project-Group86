package Layer4.UI.Screens;

import Layer1.Entity.Post;
import Layer4.UI.Components.PlaceButton;
import Layer4.UI.Components.PlaceLabel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class showPostScreen extends JFrame implements ActionListener {
    public showPostScreen(Post post) {
        //TODO: change coordinates and size
        this.add(new PlaceLabel().create(50, 0, 50, 50, post.getPostTitle()));
        this.add(new PlaceLabel().create(50, 100, 50, 50, String.valueOf(post.getUserId())));
        this.add(new PlaceLabel().create(50, 200, 50, 50, post.getTime()));
        this.add(new PlaceLabel().create(50, 300, 50, 50, String.valueOf(post.getNumLikes())));
        this.add(new PlaceLabel().create(50, 100, 50, 50, post.getContent()));
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
