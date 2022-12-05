package ui.premiumScreens.friendsScreens;

import databaseInterface.CsvInterface;
import ui.premiumScreens.PremiumMainScreen;
import ui.premiumScreens.friendsScreens.chatScreens.ChatScreen;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class FriendsScreen extends JFrame {
    public FriendsScreen(int userId, String name) throws IOException, FontFormatException {
        final String fontPathUI = "assets/fonts/KleeOne-SemiBold.ttf";
        InputStream is = new FileInputStream(fontPathUI);
        Font font = Font.createFont(Font.TRUETYPE_FONT, is);
        font = font.deriveFont(16f);

        Icon backIcon = new ImageIcon("assets/images/back.png");
        JButton back = new JButton();
        back.setIcon(backIcon);
        back.setBounds(0, 0, 45, 45);
        back.addActionListener(e -> {
            PremiumMainScreen premiumMainScreen;
            try {
                premiumMainScreen = new PremiumMainScreen(userId, name);
            } catch (IOException | FontFormatException ex) {
                throw new RuntimeException(ex);
            }
            premiumMainScreen.setVisible(true);
            dispose();
        });
        JScrollPane jScrollPane = new JScrollPane(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
                ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane.setBounds(130, 150, 700, 300);
        JPanel jPanel = new JPanel();
        ArrayList<Integer> ints = new CsvInterface().friendsReader("database/friends.csv").get(userId);

        jPanel.setLayout(new GridLayout(ints.size(), 1));
        jPanel.setSize(700, 2000);
        int i = 0;
        for (int s: ints) {

            JLabel label = new JLabel(String.valueOf(s));
            label.setSize(700, 100);
            label.setFont(font);
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

        Icon friendIcon = new ImageIcon("assets/images/addfriend.png");
        JButton addFriend = new JButton();
        addFriend.setIcon(friendIcon);
        addFriend.setBounds(915, 0, 45, 45);
        addFriend.addActionListener(e -> {
            ui.premiumScreens.friendsScreens.AddFriendsScreen addFriendsScreen = new ui.premiumScreens.friendsScreens.AddFriendsScreen(userId, name);
            addFriendsScreen.setVisible(true);
            dispose();
        });
        jScrollPane.setViewportView(jPanel);
        this.add(addFriend);
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

