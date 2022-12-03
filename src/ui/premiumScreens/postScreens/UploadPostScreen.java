package ui.premiumScreens.postScreens;

import controller.PostController;
import ui.components.PlaceButton;
import ui.components.PlaceLabel;
import ui.components.PlaceTextField;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * <p>This class is the UI for uploading post.
 * It takes user's input and pass it into PostController</p>
 *
 * @author Kevin Wu
 */
public class UploadPostScreen extends JFrame implements ActionListener {
    public UploadPostScreen(int userId, String name) throws IOException {
        this.add(new PlaceLabel().create(120, 0, 50, 50, "Title"));
        BufferedImage logo = ImageIO.read(new File("assets/images/backgroundtrans.png"));
        ImageIcon imageIcon = new ImageIcon(logo);
        JLabel label = new JLabel(imageIcon);
        label.setSize(960, 540);
        Container container = getContentPane();
        this.add(new PlaceLabel().create(120, 100, 50, 50, "Content"));

        Icon backIcon = new ImageIcon("assets/images/back.png");
        JButton back = new JButton();
        back.setBounds(0, 0, 45, 45);
        back.setIcon(backIcon);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PostScreen postScreen = null;
                try {
                    postScreen = new PostScreen(userId, name);
                } catch (IOException | FontFormatException ex) {
                    throw new RuntimeException(ex);
                }
                postScreen.setVisible(true);
                dispose();
            }
        });

        JTextField titleText= new PlaceTextField().createTextField(120, 50, 700, 50);
        this.add(titleText);

        JTextField contentText = new PlaceTextField().createTextField(120, 150, 700, 250);
        this.add(contentText);

        JButton postButton = new PlaceButton().create("Post", null,
                720, 400, 100, 50);
        postButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
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

            }
        });
        this.add(postButton);
        this.add(back);
        this.setSize(960, 540);
        this.setResizable(false);
        container.add(label);
        this.setLayout(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

}
