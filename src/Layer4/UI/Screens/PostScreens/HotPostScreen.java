
package Layer4.UI.Screens.PostScreens;
import javax.swing.*;

import Layer3.Controller.PostController;
import Layer4.UI.Components.*;
import Layer4.UI.Screens.MainScreen;
import Model.Response.PostResponseModel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.List;

public class HotPostScreen extends JFrame implements ActionListener {

    public HotPostScreen(int userId, String name){
        this.setSize(800, 800);
        this.setLayout(null);
        this.setBounds(0, 0, 800, 800);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        List<PostResponseModel> hotPosts = null;
        try {
            hotPosts = new PostController().getThreeHottestPosts();
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
        JButton mostPopular = new JButton("Most Popular");
        mostPopular.setSize(120, 40);
        mostPopular.setLocation(340, 300);
        List<PostResponseModel> finalHotPosts = hotPosts;
        mostPopular.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                ShowPostScreen post1 = null;
                try {
                    post1 = new ShowPostScreen((Integer) finalHotPosts.get(0).get().get(2), userId, name);
                    post1.setVisible(true);
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
                dispose();
            }
        });

        JButton secondPopular = new JButton("Second Popular");
        secondPopular.setSize(120, 40);
        secondPopular.setLocation(340, 370);
        secondPopular.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ShowPostScreen post2 = null;
                try {
                    post2 = new ShowPostScreen((Integer) finalHotPosts.get(1).get().get(2), userId, name);
                    post2.setVisible(true);
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
                dispose();
            }
        });

        JButton thirdPopular = new JButton("Second Popular");
        thirdPopular.setSize(120, 40);
        thirdPopular.setLocation(340, 440);
        thirdPopular.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ShowPostScreen post3 = null;
                try {
                    post3 = new ShowPostScreen((Integer) finalHotPosts.get(2).get().get(2), userId, name);
                    post3.setVisible(true);
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
                dispose();
            }
        });

        JButton back = new JButton("Back");
        back.setBounds(0, 0, 50, 20);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PostScreen postScreen = null;
                try {
                    postScreen = new PostScreen(userId, name);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                postScreen.setVisible(true);
                dispose();
            }
        });



        this.add(new PlaceLabel().create(240, 80, 600, 25,
                "THEY ARE THE HOTTEST POSTS ONLINE DUDE/GIRL!!!"));
        this.add(mostPopular);
        this.add(secondPopular);
        this.add(thirdPopular);
        this.add(back);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }
}

