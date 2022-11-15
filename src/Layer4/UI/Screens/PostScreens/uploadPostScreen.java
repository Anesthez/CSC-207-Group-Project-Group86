package Layer4.UI.Screens.PostScreens;

import Layer4.UI.Components.PlaceButton;
import Layer4.UI.Components.PlaceLabel;
import Layer4.UI.Components.PlaceTextField;
import Layer3.Controller.PostController;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * <p>This class is the UI for uploading post.
 * It takes user's input and pass it into PostController</p>
 *
 * @author Kevin Wu
 */
public class uploadPostScreen extends JFrame implements ActionListener {
    public uploadPostScreen(int userId, String name) {
        this.add(new PlaceLabel().create(50, 0, 50, 50, "Title"));

        this.add(new PlaceLabel().create(50, 100, 50, 50, "Content"));

        this.add(new PlaceLabel().create(50, 550, 50, 50, "Topic"));

        JTextField titleText= new PlaceTextField().createTextField(50, 50, 700, 50);
        this.add(titleText);

        JTextField contentText = new PlaceTextField().createTextField(50, 150, 700, 400);
        this.add(contentText);

        JTextField topicText = new PlaceTextField().createTextField(50, 600, 700, 50);
        this.add(topicText);

        JButton postButton = new PlaceButton().create("Post", null,
                650, 675, 100, 25);
        postButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PostController postController = new PostController();
                try {
                    postController.addPost(titleText.getText(), contentText.getText(), userId, topicText.getText());
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        this.add(postButton);

        JButton backButton = new PlaceButton().create("Back", null,
                50, 675, 100, 25);
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
