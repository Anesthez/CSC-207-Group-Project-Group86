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
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class PremiumMainScreen extends JFrame {

    List<String> greetingMessages = Arrays.asList("Hello, ", "Good day, ", "Hiya, ");
    List<String> chatters = Arrays.asList("I hope you are doing well.", "It is nice to see you!",
            "Let's check out some posts?");
    Random rand = new Random();
    int indexGreeting = rand.nextInt(greetingMessages.size());
    int indexChatter = rand.nextInt(chatters.size());

    public PremiumMainScreen(int userId, String username) throws IOException, FontFormatException {

        final String fontPathUI = "assets/fonts/KleeOne-SemiBold.ttf";
        InputStream is = new FileInputStream(new File(fontPathUI));
        Font font = Font.createFont(Font.TRUETYPE_FONT, is);
        font = font.deriveFont(12f);

        this.setLayout(null);
        this.add(new PlaceLabel().create(100, 100, 200, 50,
                greetingMessages.get(indexGreeting) + username + "!"));
        this.add(new PlaceLabel().create(100, 150, 200, 50, chatters.get(indexChatter)));

        JButton post = new JButton("Post");
        JButton friend = new JButton("Friend");
        JButton topic = new JButton("Topic");
        BufferedImage logo = ImageIO.read(new File("assets/images/background.png"));
        ImageIcon imageIcon = new ImageIcon(logo);
        JLabel label = new JLabel(imageIcon);
        label.setSize(960, 540);
        Container container = getContentPane();
        container.setFont(font);

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

