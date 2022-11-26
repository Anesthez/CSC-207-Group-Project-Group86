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
        JButton hottestTopic = new JButton("Hottest Topic");
        JButton secondHottestTopic = new JButton("Second Hottest Topic");
        JButton thirdHottestTopic = new JButton("Third Hottest Topic");

        hottestTopic.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                HottestTopicScreen htScreen = null;
                try {
                    htScreen = new FirstHotScreen(userId, name);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                htScreen.setVisible(true);
                dispose();
            }
        });

        secondHottestTopic.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                HottestTopicScreen htScreen = null;
                try {
                    htScreen = new SecondHotScreen(userId, name);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                htScreen.setVisible(true);
                dispose();
            }
        });

        thirdHottestTopic.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                HottestTopicScreen htScreen = null;
                try {
                    htScreen = new ThirdHotScreen(userId, name);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                htScreen.setVisible(true);
                dispose();
            }
        });
        this.setBounds(0, 0, 960, 540);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setResizable(false);

    }
    public void setVisible(boolean b) {
    }


}
