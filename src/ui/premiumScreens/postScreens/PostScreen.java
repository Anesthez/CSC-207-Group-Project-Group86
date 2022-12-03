package ui.premiumScreens.postScreens;

import presenter.PostPresenter;
import ui.premiumScreens.PremiumMainScreen;
import model.response.PostResponseModel;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

public class PostScreen extends JFrame {
    public PostScreen(int userId, String name) throws IOException, FontFormatException {

        final String fontPathUI = "assets/fonts/KleeOne-SemiBold.ttf";
        InputStream is = new FileInputStream(fontPathUI);
        Font font = Font.createFont(Font.TRUETYPE_FONT, is);
        font = font.deriveFont(16f);

        Icon backIcon = new ImageIcon("assets/images/back.png");
        Icon postIcon = new ImageIcon("assets/images/addpost.png");

        JButton back = new JButton();
        back.setIcon(backIcon);
        back.setBounds(0, 0, 45, 45);
        back.addActionListener(e -> {
            PremiumMainScreen mainScreen;
            try {
                mainScreen = new PremiumMainScreen(userId, name);
            } catch (IOException | FontFormatException ex) {
                throw new RuntimeException(ex);
            }
            mainScreen.setVisible(true);
            dispose();
        });

        JButton uploadPost = new JButton();
        uploadPost.setIcon(postIcon);
        uploadPost.setBounds(915, 45, 45, 45);
        uploadPost.addActionListener(e -> {
            UploadPostScreen uploadPostScreen;
            try {
                uploadPostScreen = new UploadPostScreen(userId, name);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
            uploadPostScreen.setVisible(true);
            dispose();
        });
        JButton hotPosts = new JButton("Trending Hot Posts");
        hotPosts.setFont(font);
        hotPosts.setBounds(780, 0, 180, 45);
        hotPosts.addActionListener(e -> {

            HotPostScreen hotPostScreen;
            try {
                hotPostScreen = new HotPostScreen(userId, name);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
            hotPostScreen.setVisible(true);
            dispose();
        });
        JScrollPane jScrollPane = new JScrollPane(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
                ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane.setBounds(130, 150, 700, 300);
        JPanel jPanel = new JPanel();
        Map<Integer, PostResponseModel> posts = new PostPresenter().getPosts();

        jPanel.setLayout(new GridLayout(posts.size(), 1));
        jPanel.setSize(700, 2000);
        for (PostResponseModel s: posts.values()) {

            JLabel label = new JLabel(s.get().get(3) + " User:"+s.get().get(1) + " "+ s.get().get(2));
            label.setFont(font);
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
        }
        jScrollPane.setViewportView(jPanel);
        this.add(jScrollPane);
        this.add(back);
        this.add(hotPosts);
        this.add(uploadPost);
        this.setLayout(null);
        BufferedImage logo = ImageIO.read(new File("assets/images/background.png"));
        ImageIcon imageIcon = new ImageIcon(logo);
        JLabel label = new JLabel(imageIcon);
        label.setSize(960, 540);
        Container container = getContentPane();
        container.add(label);
        this.setSize(960, 540);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
    }
}
