package Layer4.UI.Screens.PostScreens;

import Layer4.UI.Components.PlaceButton;
import Layer4.UI.Components.PlaceLabel;
import Layer4.UI.Components.PlaceTextField;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * <p>This class is the UI for uploading post.
 * It takes user's input and pass it into PostController</p>
 *
 * @author Kevin Wu
 */
public class UploadPostScreen extends JFrame implements ActionListener {
    public UploadPostScreen() {
        this.add(new PlaceLabel().create(50, 0, 50, 50, "Title"));

        this.add(new PlaceLabel().create(50, 100, 50, 50, "Content"));

        JTextField titleText= new PlaceTextField().createTextField(50, 50, 700, 50);
        this.add(titleText);

        JTextField contentText = new PlaceTextField().createTextField(50, 150, 700, 500);
        this.add(contentText);

        JButton postButton = new PlaceButton().create("Post", null,
                650, 675, 100, 50);
        postButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String[] postInfo = new String[2];
                postInfo[0] = titleText.getText();
                postInfo[1] = contentText.getText();
                //TODO: call controller -> use case(similar to command) to upload the post
            }
        });
        this.add(postButton);

        this.setSize(800, 800);
        this.setLayout(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

}
