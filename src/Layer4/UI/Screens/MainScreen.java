package Layer4.UI.Screens;


import Layer4.UI.Components.PlaceLabel;
import Layer4.UI.Screens.FriendsScreens.FriendsScreen;
import Layer4.UI.Screens.PostScreens.PostScreen;
import Layer4.UI.Screens.TopicScreens.TopicScreen;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class MainScreen extends JFrame {
    public MainScreen(int userId, String username){
        this.setLayout(null);
        this.add(new PlaceLabel().create(100, 100, 100, 50, username));
        JButton post = new JButton("Post");
        JButton friend = new JButton("Friend");
        JButton topic = new JButton("Topic");

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
                TopicScreen topicScreen = new TopicScreen(userId, username);
                topicScreen.setVisible(true);
                dispose();

            }
        });

        this.add(post);
        this.add(friend);
        this.add(topic);

        this.setBounds(0, 0, 800, 800);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

