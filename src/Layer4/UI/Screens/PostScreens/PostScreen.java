package Layer4.UI.Screens.PostScreens;

import Layer3.Controller.PostController;
import Layer4.UI.Screens.MainScreen;
import Model.Response.PostResponseModel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PostScreen extends JFrame {
    public PostScreen(int userId, String name){
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

        JButton hotPosts = new JButton("Trending Hot Posts");
        hotPosts.setBounds(0, 25, 180, 20);
        hotPosts.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                HotPostScreen hotPostScreen = new HotPostScreen(userId, name);
                hotPostScreen.setVisible(true);
                dispose();
            }
        });

        this.add(back);
        this.add(hotPosts);
        this.setLayout(null);
        this.setBounds(0, 0, 800, 800);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}


