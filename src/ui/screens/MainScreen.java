package ui.screens;


import ui.components.PlaceLabel;
import ui.screens.friendsScreens.FriendsScreen;
import ui.screens.postScreens.PostScreen;
import ui.screens.topicScreens.TopicScreen;

import javax.swing.*;
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

        post.addActionListener(e -> {
            PostScreen postScreen;
            try {
                postScreen = new PostScreen(userId, username);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
            postScreen.setVisible(true);
            dispose();

        });

        friend.addActionListener(e -> {
            FriendsScreen friendsScreen;
            try {
                friendsScreen = new FriendsScreen(userId, username);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
            friendsScreen.setVisible(true);
            dispose();

        });

        topic.addActionListener(e -> {
            TopicScreen topicScreen;
            try {
                topicScreen = new TopicScreen(userId, username);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
            topicScreen.setVisible(true);
            dispose();

        });

        this.add(post);
        this.add(friend);
        this.add(topic);

        this.setBounds(0, 0, 800, 800);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

