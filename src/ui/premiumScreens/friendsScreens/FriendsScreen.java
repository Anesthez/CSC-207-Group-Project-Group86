package ui.premiumScreens.friendsScreens;

import databaseInterface.csvInterface;
import ui.premiumScreens.friendsScreens.chatScreens.ChatScreen;
import ui.premiumScreens.PremiumMainScreen;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class FriendsScreen extends JFrame {
    public FriendsScreen(int userId, String name) throws IOException {
        JButton back = new JButton("Back");
        back.setBounds(0, 0, 50, 20);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PremiumMainScreen premiumMainScreen = null;
                try {
                    premiumMainScreen = new PremiumMainScreen(userId, name);
                } catch (IOException | FontFormatException ex) {
                    throw new RuntimeException(ex);
                }
                premiumMainScreen.setVisible(true);
                dispose();
            }
        });
        JScrollPane jScrollPane = new JScrollPane(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
                ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane.setBounds(50, 150, 700, 400);
        JPanel jPanel = new JPanel();
        ArrayList<Integer> ints = new csvInterface().friendsReader("database/friends.csv").get(userId);

        jPanel.setLayout(new GridLayout(ints.size(), 1));
        jPanel.setSize(700, 2000);
        int i = 0;
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
                    label.setForeground(Color.cyan);
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    label.setForeground(Color.black);
                }
            });
            jPanel.add(label);
            i +=1;
        }
        jScrollPane.setViewportView(jPanel);
        this.add(jScrollPane);
        this.add(back);
        this.setLayout(null);
        BufferedImage logo = ImageIO.read(new File("assets/images/background.png"));
        ImageIcon imageIcon = new ImageIcon(logo);
        JLabel label = new JLabel(imageIcon);
        label.setSize(960, 540);
        Container container = getContentPane();
        container.add(label);
        this.setSize(960, 540);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);

    }
}

