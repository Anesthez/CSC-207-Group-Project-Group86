package Layer4.UI.Screens;

import Layer4.UI.Components.PlaceLabel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TopicScreen extends JPanel implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {

    }

    public TopicScreen()
    {
        JFrame frame = new JFrame("Topic Screen");
        JButton showTopics = new JButton("View Topics");
        JButton showHottestTopics = new JButton("View Hottest Topics");
        JButton cancel = new JButton("Cancel");

        showTopics.setBounds(100, 100, 50, 20);
        showHottestTopics.setBounds(200, 100, 50, 20);
        cancel.setBounds(300, 100, 50, 20);
        frame.add(showTopics);
        frame.add(showHottestTopics);
        frame.add(cancel);
        frame.setSize(500, 500);
        frame.setLayout(null);
        frame.setVisible(true);


    }


}
