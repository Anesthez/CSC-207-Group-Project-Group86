package Layer4.UI.PremiumScreens.PostScreens;

import Layer3.Presenter.PostPresenter;
import Layer4.Interface.csvInterface;
import Layer4.UI.PremiumScreens.PremiumMainScreen;
import Layer4.UI.Screens.FriendsScreens.ChatScreens.ChatScreen;
import Layer4.UI.Screens.MainScreen;
import Model.Response.PostResponseModel;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

public class PostScreen extends JFrame {
    public PostScreen(int userId, String name) throws IOException {
        JButton back = new JButton("Back");
        back.setBounds(0, 0, 50, 20);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PremiumMainScreen mainScreen = null;
                try {
                    mainScreen = new PremiumMainScreen(userId, name);
                } catch (IOException | FontFormatException ex) {
                    throw new RuntimeException(ex);
                }
                mainScreen.setVisible(true);
                dispose();
            }
        });

        JButton uploadPost = new JButton("Upload Post");
        uploadPost.setBounds(0, 50, 100, 20);
        uploadPost.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UploadPostScreen uploadPostScreen = null;
                try {
                    uploadPostScreen = new UploadPostScreen(userId, name);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                uploadPostScreen.setVisible(true);
                dispose();
            }
        });
        JButton hotPosts = new JButton("Trending Hot Posts");
        hotPosts.setBounds(0, 25, 180, 20);
        hotPosts.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                HotPostScreen hotPostScreen = null;
                try {
                    hotPostScreen = new HotPostScreen(userId, name);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                hotPostScreen.setVisible(true);
                dispose();
            }
        });
        JLabel label1 = new JLabel("Browse Posts");
        label1.setBounds(400, 300, 100, 20);
        JScrollPane jScrollPane = new JScrollPane(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
                ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane.setBounds(50, 150, 700, 400);
        JPanel jPanel = new JPanel();
        Map<Integer, PostResponseModel> posts = new PostPresenter().getPosts();

        jPanel.setLayout(new GridLayout(posts.size(), 1));
        jPanel.setSize(700, 2000);
        int i = 0;
        for (PostResponseModel s: posts.values()) {

            JLabel label = new JLabel(s.get().get(3) + " User:"+s.get().get(1) + " "+ s.get().get(2));
            label.setSize(700, 100);
            label.addMouseListener(new MouseListener() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    try {
                        ShowPostScreen showPostScreen = new ShowPostScreen((int) s.get().get(2), userId, name);
                        showPostScreen.setVisible(true);
                        dispose();
                    } catch (Exception ex) {
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
                    label.setForeground(Color.cyan);
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    label.setForeground(Color.black);
                }
            });
            jPanel.add(label);
            i +=1;
        }
        jScrollPane.setViewportView(jPanel);
        this.add(jScrollPane);
        this.add(back);
        this.add(hotPosts);
        this.setLayout(null);
        BufferedImage logo = ImageIO.read(new File("assets/images/background.png"));
        ImageIcon imageIcon = new ImageIcon(logo);
        JLabel label = new JLabel(imageIcon);
        label.setSize(960, 540);
        Container container = getContentPane();
        container.add(label);
        this.setSize(960, 540);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.add(uploadPost);
        this.setResizable(false);
    }
}
