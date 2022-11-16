package Layer4.UI.DesignedScreens;


import Layer4.UI.Components.PlaceLabel;
import Layer4.UI.Screens.FriendsScreens.FriendsScreen;
import Layer4.UI.Screens.PostScreens.PostScreen;
import Layer4.UI.Screens.TopicScreens.TopicScreen;


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

/**
 * <p> This is the redesign version of the login screen by Tianyu Li </p>
 * @author Tianyu Li
 */

public class MainScreenNew extends JFrame {
    public MainScreenNew(int userId, String username) throws IOException, FontFormatException {

        final String fontPathGreeting = "assets/fonts/JustAnotherHand-Regular.ttf";
        InputStream is = new FileInputStream(new File(fontPathGreeting));
        Font f = Font.createFont(Font.TRUETYPE_FONT, is);
        f = f.deriveFont(18f);

        final String fontPathUI = "assets/fonts/KleeOne-SemiBold.ttf";
        InputStream is2 = new FileInputStream(new File(fontPathUI));
        Font f2 = Font.createFont(Font.TRUETYPE_FONT, is2);
        f2 = f2.deriveFont(12f);

        this.getContentPane().setBackground(new Color(255, 255, 255));
        BufferedImage logo = ImageIO.read(new File("assets/images/logo_1_trans.png"));
        JLabel picLabel = new JLabel(new ImageIcon(logo));
        picLabel.setBounds(150, 150, 500, 500);

        this.setLayout(null);
        JLabel greetings = new PlaceLabel().create(100, 100, 100, 50, "Welcome! " + username);
        greetings.setFont(f);
        this.add(greetings);

        JButton post = new JButton("Post");
        JButton friend = new JButton("Friend");
        JButton topic = new JButton("Topic");

        post.setBounds(500, 200, 100, 50);
        post.setBackground(new Color(1.0f,1.0f,1.0f,0));
        post.setFont(f2);

        friend.setBounds(500, 300, 100, 50);
        friend.setBackground(new Color(1.0f,1.0f,1.0f,0));
        friend.setFont(f2);

        topic.setBounds(500, 400, 100, 50);
        topic.setBackground(new Color(1.0f,1.0f,1.0f,0));
        topic.setFont(f2);

        post.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PostScreen postScreen = new PostScreen(userId, username);
                postScreen.setVisible(true);
                dispose();
            }
        });

        friend.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FriendsScreen FriendsScreen = new FriendsScreen(userId, username);
                FriendsScreen.setVisible(true);
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
        this.add(picLabel);

        this.setBounds(0, 0, 800, 800);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

