package Layer4.UI.PremiumScreens.TopicScreens;

import Layer3.Controller.TopicController;
import Layer4.UI.Components.PlaceLabel;
import Layer4.UI.PremiumScreens.PremiumMainScreen;
import Layer4.UI.Screens.MainScreen;
import Model.Request.TopicRequestModel;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class HottestTopicScreen extends JFrame implements ActionListener {
    public void setVisible(boolean b) {
    }
    @Override
    public void actionPerformed(ActionEvent e) {

    }
    public HottestTopicScreen(int userId, String name) throws IOException {
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
                MainScreen mainScreen = new MainScreen(userId, name);
                mainScreen.setVisible(true);
                dispose();
            }
        });
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        TopicController topicController = new TopicController();
        ArrayList<TopicRequestModel> ht = topicController.getHottestTopics();
        for (TopicRequestModel t : ht){
            JLabel label1 = new JLabel(String.valueOf(t.get()));
            label.setSize(700, 100);
            panel.add(label1);
        }

    }
}
