
package Layer4.UI.Screens.PostScreens;
import javax.swing.*;

import Layer4.UI.Components.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HotPostScreen extends JPanel implements ActionListener {

    Container container;

    public HotPostScreen(JFrame frame){  // TODO will take: HotPostScreen(List<Post> hotPosts) in later implementations.
        container = frame.getContentPane();
        container.setLayout(null);

        JButton mostPopular = new JButton("Most Popular");
        mostPopular.setSize(120, 40);
        mostPopular.setLocation(340, 300);
        mostPopular.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Todo connect interface with post 1
            }
        });

        JButton secondPopular = new JButton("Second Popular");
        secondPopular.setSize(120, 40);
        secondPopular.setLocation(340, 370);
        secondPopular.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Todo connect interface with post 2
            }
        });

        JButton thirdPopular = new JButton("Second Popular");
        thirdPopular.setSize(120, 40);
        thirdPopular.setLocation(340, 440);
        thirdPopular.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Todo connect interface with post 3
            }
        });

        JButton yellow = new JButton("YELLOW!");
        yellow.setSize(120, 40);
        yellow.setLocation(340, 510);
        yellow.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                container.setBackground(Color.yellow);
            }
        });

        JButton green = new JButton("GREEN!");
        green.setSize(120, 40);
        green.setLocation(340, 580);
        green.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                container.setBackground(Color.green);
            }
        });

        container.setSize(800, 800);
        container.add(new PlaceLabel().create(240, 80, 600, 25,
                "THEY ARE THE HOTTEST POSTS ONLINE DUDE/GIRL!!!"));
        container.add(mostPopular);
        container.add(secondPopular);
        container.add(thirdPopular);
        container.add(yellow);
        container.add(green);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }
}

