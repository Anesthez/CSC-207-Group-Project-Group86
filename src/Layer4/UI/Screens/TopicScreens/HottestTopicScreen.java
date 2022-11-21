package Layer4.UI.Screens.TopicScreens;

import Layer3.Controller.TopicController;
import Layer4.Interface.csvInterface;
import Layer4.UI.Screens.MainScreen;
import Model.Request.TopicRequestModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

public class HottestTopicScreen extends JFrame {
    public HottestTopicScreen(int userId, String name) throws IOException {
        JButton back = new JButton("Back");
        back.setBounds(0, 0, 50, 20);
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
            JLabel label = new JLabel(String.valueOf(t.get()));
            label.setSize(700, 100);
            panel.add(label);
        }

    }
    public void setVisible(boolean b) {
    }

}
