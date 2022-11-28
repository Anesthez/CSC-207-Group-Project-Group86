package ui.premiumScreens;


import ui.components.PlaceLabel;
import ui.premiumScreens.friendsScreens.FriendsScreen;
import ui.premiumScreens.postScreens.PostScreen;
import ui.premiumScreens.topicScreens.TopicScreen;
import ui.screens.LoginScreen;


import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class PremiumMainScreen extends JFrame {

    public PremiumMainScreen(int userId, String username) throws IOException, FontFormatException {

        final String fontPathUI = "assets/fonts/KleeOne-SemiBold.ttf";
        InputStream is = new FileInputStream(fontPathUI);
        Font font = Font.createFont(Font.TRUETYPE_FONT, is);
        font = font.deriveFont(16f);

        List<String> greetingMessages = Arrays.asList("Hello, ", "Good day, ", "Hiya, ");
        List<String> chatters = Arrays.asList("I hope you are doing well.", "It is nice to see you!",
                "Let's check out some posts?");
        Random rand = new Random();
        int indexGreeting = rand.nextInt(greetingMessages.size());
        int indexChatter = rand.nextInt(chatters.size());

        BufferedImage logo = ImageIO.read(new File("assets/images/background.png"));
        ImageIcon imageIcon = new ImageIcon(logo);
        JLabel label = new JLabel(imageIcon);
        label.setSize(960, 540);
        Container container = getContentPane();

        this.setLayout(null);
        JLabel greeting = new PlaceLabel().create(625, 50, 200, 50,
                greetingMessages.get(indexGreeting) + username + "!");
        greeting.setFont(font);
        this.add(greeting);
        JLabel chatting = new PlaceLabel().create(625, 80, 250, 50, chatters.get(indexChatter));
        chatting.setFont(font);
        this.add(chatting);

        Icon postIcon = new ImageIcon("assets/images/post.png");
        Icon topicIcon = new ImageIcon("assets/images/topic.png");
        Icon friendIcon = new ImageIcon("assets/images/friends.png");
        Icon logoutIcon = new ImageIcon("assets/images/logout.png");

        JButton post = new JButton();
        JButton friend = new JButton();
        JButton topic = new JButton();
        JButton logout = new JButton();

        post.setBounds(625, 150, 125, 125);
        post.setIcon(postIcon);

        topic.setBounds(755, 150, 125, 125);
        topic.setIcon(topicIcon);

        friend.setBounds(625, 280, 125, 125);
        friend.setIcon(friendIcon);


        logout.setBounds(755, 280, 125, 125);
        logout.setIcon(logoutIcon);


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
            } catch (IOException | FontFormatException ex) {
                throw new RuntimeException(ex);
            }
            topicScreen.setVisible(true);
            dispose();

        });

        logout.addActionListener(e -> {
            LoginScreen loginScreen = new LoginScreen();
            loginScreen.setVisible(true);
            dispose();

        });

        this.add(post);
        this.add(friend);
        this.add(topic);
        this.add(logout);
        container.add(label);
        this.setBounds(0, 0, 960, 540);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
    }
}

