package ui.premiumScreens.topicScreens;

import databaseInterface.csvInterface;
import model.request.TopicRequestModel;
import ui.premiumScreens.PremiumMainScreen;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

public class ShowTopicsScreen extends JFrame implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {

    }

    public ShowTopicsScreen(Integer userID, String name) throws IOException, FontFormatException {
        this.setLayout(null);
        BufferedImage logo = ImageIO.read(new File("assets/images/background.png"));
        ImageIcon imageIcon = new ImageIcon(logo);
        JLabel jlabel = new JLabel(imageIcon);
        jlabel.setSize(960, 540);
        Container container = getContentPane();
        this.setSize(960, 540);
        this.setResizable(false);
        final String fontPathUI = "assets/fonts/KleeOne-SemiBold.ttf";
        InputStream is = new FileInputStream(new File(fontPathUI));
        Font font = Font.createFont(Font.TRUETYPE_FONT, is);
        font = font.deriveFont(14f);
        JButton back = new JButton("Back");
        back.setBounds(0, 0, 50, 20);
        back.addActionListener(e -> {
            PremiumMainScreen mainScreen = null;
            try {
                mainScreen = new PremiumMainScreen(userID, name);
                mainScreen.setVisible(true);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            } catch (FontFormatException ex) {
                throw new RuntimeException(ex);
            }
            dispose();
        });

        JButton hottestTopic = new JButton("Hottest Topic");
        hottestTopic.setBounds(0, 50, 150, 20);
        hottestTopic.addActionListener(e -> {
            try {
                HottestTopicScreen htScreen = new HottestTopicScreen(userID, name);
                htScreen.setVisible(true);
            } catch (IOException | FontFormatException ex) {
                throw new RuntimeException(ex);
            }
            dispose();
        });
        JScrollPane jScrollPane = new JScrollPane(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
                ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane.setBounds(50, 150, 800, 300);
        JPanel jPanel = new JPanel();
        Map<Integer, TopicRequestModel> topics = new csvInterface().topicsReader("database/topic.csv");
        jPanel.setLayout(new GridLayout(topics.size(), 1));
        for (TopicRequestModel t : topics.values()){
            JLabel label = new JLabel(t.get().get(0) + ". " + t.get().get(1));
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
        }
        jScrollPane.setViewportView(jPanel);
        this.add(jScrollPane);
        this.add(back);
        this.add(hottestTopic);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        container.add(jlabel);
    }
}
