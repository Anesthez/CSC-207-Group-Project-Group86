
package ui.premiumScreens.postScreens;

import controller.PostController;
import ui.components.PlaceLabel;
import model.response.PostResponseModel;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class HotPostScreen extends JFrame implements ActionListener {

    public HotPostScreen(int userId, String name) throws IOException {
        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        List<PostResponseModel> hotPosts = null;
        try {
            hotPosts = new PostController().getThreeHottestPosts();
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
        JButton mostPopular = new JButton("Most Popular");
        mostPopular.setSize(120, 40);
        mostPopular.setLocation(340, 200);
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
        secondPopular.setLocation(340, 270);
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

        JButton thirdPopular = new JButton("third Popular");
        thirdPopular.setSize(120, 40);
        thirdPopular.setLocation(340, 340);
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

        Icon backIcon = new ImageIcon("assets/images/back.png");
        JButton back = new JButton();
        back.setIcon(backIcon);
        back.setBounds(0, 0, 45, 45);
        back.addActionListener(e -> {
            PostScreen postScreen = null;
            try {
                postScreen = new PostScreen(userId, name);
            } catch (IOException | FontFormatException ex) {
                throw new RuntimeException(ex);
            }
            postScreen.setVisible(true);
            dispose();
        });



        this.add(new PlaceLabel().create(230, 80, 600, 25,
                "THEY ARE THE HOTTEST POSTS ONLINE " + name + "! Take a Look!"));
        this.add(mostPopular);
        this.add(secondPopular);
        this.add(thirdPopular);
        this.add(back);
        BufferedImage logo = ImageIO.read(new File("assets/images/background.png"));
        ImageIcon imageIcon = new ImageIcon(logo);
        JLabel label = new JLabel(imageIcon);
        label.setSize(960, 540);
        Container container = getContentPane();
        container.add(label);
        this.setSize(960, 540);
        this.setResizable(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }
}

