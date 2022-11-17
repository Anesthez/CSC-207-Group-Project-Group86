package Layer4.UI.PremiumScreens.TopicScreens;


import Layer4.UI.PremiumScreens.PremiumMainScreen;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TopicScreen extends JFrame implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {

    }

    public TopicScreen(int userId, String name)
    {
        this.setLayout(null);
        JButton back = new JButton("Back");
        back.setBounds(0, 0, 50, 20);
        this.setSize(800, 800);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PremiumMainScreen premiumMainScreen = new PremiumMainScreen(userId, name);
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
        this.setSize(500, 500);
        this.setLayout(null);


    }


}
