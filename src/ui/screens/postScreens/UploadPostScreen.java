package ui.screens.postScreens;

import controller.PostController;
import ui.components.PlaceButton;
import ui.components.PlaceLabel;
import ui.components.PlaceTextField;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

/**
 * <p>This class is the UI for uploading post.
 * It takes user's input and pass it into PostController</p>
 *
 * @author Kevin Wu
 */
public class UploadPostScreen extends JFrame implements ActionListener {
    public UploadPostScreen(int userId, String name) {
        this.add(new PlaceLabel().create(50, 0, 50, 50, "Title"));

        this.add(new PlaceLabel().create(50, 100, 50, 50, "Content"));
        JButton back = new JButton("Back");
        back.setBounds(0, 0, 50, 20);
        back.addActionListener(e -> {
            PostScreen postScreen;
            try {
                postScreen = new PostScreen(userId, name);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
            postScreen.setVisible(true);
            dispose();
        });

        JTextField titleText= new PlaceTextField().createTextField(50, 50, 700, 50);
        this.add(titleText);

        JTextField contentText = new PlaceTextField().createTextField(50, 150, 700, 500);
        this.add(contentText);

        JButton postButton = new PlaceButton().create("Post", null,
                650, 675, 100, 50);
        postButton.addActionListener(e -> {
            String[] postInfo = new String[2];
            postInfo[0] = titleText.getText();
            postInfo[1] = contentText.getText();
            try {
                new PostController().addPost(postInfo[0], postInfo[1], userId, "topic");
                JOptionPane.showMessageDialog(null, String.format("%s created.",
                        titleText.getText()));
                titleText.setText("");
                contentText.setText("");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }

        });
        this.add(postButton);
        this.add(back);
        this.setSize(800, 800);
        this.setLayout(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

}
