package ui.screens.friendsScreens;

import databaseInterface.csvInterface;
import ui.screens.friendsScreens.chatScreens.ChatScreen;
import ui.screens.MainScreen;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.util.ArrayList;

public class FriendsScreen extends JFrame {
    public FriendsScreen(int userId, String name) throws IOException {
        JButton back = new JButton("Back");
        back.setBounds(0, 0, 50, 20);
        back.addActionListener(e -> {
            MainScreen mainScreen = new MainScreen(userId, name);
            mainScreen.setVisible(true);
            dispose();
        });
        JScrollPane jScrollPane = new JScrollPane(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
                ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane.setBounds(50, 150, 700, 400);
        JPanel jPanel = new JPanel();
        ArrayList<Integer> ints = new csvInterface().friendsReader("database/friends.csv").get(userId);

        jPanel.setLayout(new GridLayout(ints.size(), 1));
        jPanel.setSize(700, 2000);
        for (int s: ints) {

            JLabel label = new JLabel(String.valueOf(s));
            label.setSize(700, 100);
            label.addMouseListener(new MouseListener() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    try {
                        ChatScreen chatScreen = new ChatScreen(userId, s, name);
                        chatScreen.setVisible(true);
                        dispose();
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                }

                @Override
                public void mousePressed(MouseEvent e) {

                }

                @Override
                public void mouseReleased(MouseEvent e) {
                }

                @Override
                public void mouseEntered(MouseEvent e) {
                    label.setForeground(Color.blue);
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    label.setForeground(Color.black);
                }
            });
            jPanel.add(label);
        }
        JButton addFriend = new JButton("Add Friend");
        addFriend.setBounds(50, 50, 100, 50);
        addFriend.addActionListener(e -> {
            AddFriendsScreen addFriendsScreen = new AddFriendsScreen(userId, name);
            addFriendsScreen.setVisible(true);
            dispose();
        });
        jScrollPane.setViewportView(jPanel);
        this.add(addFriend);
        this.add(jScrollPane);
        this.add(back);
        this.setLayout(null);
        this.setBounds(0, 0, 800, 800);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}

