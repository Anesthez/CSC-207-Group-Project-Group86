package Layer4.UI.Screens.TopicScreens;


import Layer1.Entity.Topic;
import Layer4.Interface.csvInterface;
import Layer4.UI.Screens.MainScreen;
import Model.Request.TopicRequestModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

public class TopicScreen extends JFrame implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {

    }
    public TopicScreen(Integer userID, String name) throws IOException{
        JButton back = new JButton("Back");
        back.setBounds(0, 0, 50, 20);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainScreen mainScreen = new MainScreen(userID, name);
                mainScreen.setVisible(true);
                dispose();
            }
        });
        JButton hottestTopic = new JButton("Hottest Topic");
        hottestTopic.setBounds(0, 50, 150, 20);
        hottestTopic.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                HottestTopicScreen htScreen = null;
                try {
                    htScreen = new HottestTopicScreen(userID, name);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                htScreen.setVisible(true);
                dispose();
            }
        });
        JScrollPane jScrollPane = new JScrollPane(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
                ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane.setBounds(50, 150, 800, 800);
        JPanel jPanel = new JPanel();
        Map<Integer, TopicRequestModel> topics = new csvInterface().topicsReader("database/topic.csv");
        jPanel.setLayout(new GridLayout(topics.size(), 1));
        jPanel.setSize(800, 2000);
        int i=0;
        for (TopicRequestModel t : topics.values()){
        JLabel label = new JLabel(String.valueOf(t.get()));
        label.setSize(800, 100);
        label.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try{
                    HottestTopicScreen htScreen = new HottestTopicScreen(userID, name);
                    htScreen.setVisible(true);
                    dispose();
                }
                catch (Exception ex){
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
                label.setForeground(Color.BLUE);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                label.setForeground(Color.BLACK);
            }
        });
        jPanel.add(label);
        i+=1;
        }
        jScrollPane.setViewportView(jPanel);
        this.add(jScrollPane);
        this.add(back);
        this.setLayout(null);
        this.setBounds(0, 0, 800, 800);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        };
    }


