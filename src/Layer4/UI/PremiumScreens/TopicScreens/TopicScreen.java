package Layer4.UI.PremiumScreens.TopicScreens;


import Layer4.UI.PremiumScreens.PremiumMainScreen;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class TopicScreen extends JFrame implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {

    }

    public TopicScreen(int userId, String name) throws IOException {
        this.setLayout(null);
        JButton back = new JButton("Back");
        back.setBounds(0, 0, 50, 20);
        BufferedImage logo = ImageIO.read(new File("assets/images/background.png"));
        ImageIcon imageIcon = new ImageIcon(logo);
        JLabel label = new JLabel(imageIcon);
        label.setSize(960, 540);
        Container container = getContentPane();
        this.setSize(960, 540);
        this.setResizable(false);
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
        this.add(back);

        JButton showTopics = new JButton("View Topics");
        JButton showHottestTopics = new JButton("View Hottest Topics");
        JButton cancel = new JButton("Cancel");

        showTopics.setBounds(100, 100, 50, 20);
        showHottestTopics.setBounds(200, 100, 50, 20);
        cancel.setBounds(300, 100, 50, 20);
        this.add(showTopics);
        this.add(showHottestTopics);
        this.add(cancel);

        container.add(label);


    }


}
