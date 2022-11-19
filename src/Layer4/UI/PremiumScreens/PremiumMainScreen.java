package Layer4.UI.PremiumScreens;


import Layer4.UI.Components.PlaceLabel;
import Layer4.UI.PremiumScreens.FriendsScreens.FriendsScreen;
import Layer4.UI.PremiumScreens.PostScreens.PostScreen;
import Layer4.UI.PremiumScreens.TopicScreens.TopicScreen;


import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class PremiumMainScreen extends JFrame {
    public PremiumMainScreen(int userId, String username) throws IOException {
        this.setLayout(null);
        this.add(new PlaceLabel().create(100, 100, 100, 50, username));
        JButton post = new JButton("Post");
        JButton friend = new JButton("Friend");
        JButton topic = new JButton("Topic");
        BufferedImage logo = ImageIO.read(new File("assets/images/background.png"));
        ImageIcon imageIcon = new ImageIcon(logo);
        JLabel label = new JLabel(imageIcon);
        label.setSize(960, 540);
        Container container = getContentPane();

        post.setBounds(500, 200, 100, 50);
        friend.setBounds(500, 300, 100, 50);
        topic.setBounds(500, 400, 100, 50);

        post.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PostScreen postScreen = null;
                try {
                    postScreen = new PostScreen(userId, username);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                postScreen.setVisible(true);
                dispose();

            }
        });

        friend.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FriendsScreen friendsScreen = null;
                try {
                    friendsScreen = new FriendsScreen(userId, username);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                friendsScreen.setVisible(true);
                dispose();

            }
        });

        topic.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TopicScreen topicScreen = null;
                try {
                    topicScreen = new TopicScreen(userId, username);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                topicScreen.setVisible(true);
                dispose();

            }
        });

        this.add(post);
        this.add(friend);
        this.add(topic);
        container.add(label);
        this.setBounds(0, 0, 960, 540);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
    }
}

