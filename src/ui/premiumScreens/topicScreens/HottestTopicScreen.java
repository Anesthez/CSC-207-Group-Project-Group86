package ui.premiumScreens.topicScreens;

import controller.TopicController;
import databaseInterface.CsvInterface;
import ui.components.PlaceLabel;
import ui.premiumScreens.PremiumMainScreen;
import ui.screens.MainScreen;
import model.request.TopicRequestModel;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Map;

public class HottestTopicScreen extends JFrame implements ActionListener {
    public void actionPerformed(ActionEvent e) {

    }
    public HottestTopicScreen(int userId, String name) throws IOException, FontFormatException {
        this.setLayout(null);
        JButton back = new JButton("Back");
        BufferedImage logo = ImageIO.read(new File("assets/images/background.png"));
        ImageIcon imageIcon = new ImageIcon(logo);
        JLabel label = new JLabel(imageIcon);
        label.setSize(960, 540);
        Container container = getContentPane();
        this.setSize(960, 540);
        this.setResizable(false);
        final String fontPathUI = "assets/fonts/KleeOne-SemiBold.ttf";
        InputStream is = new FileInputStream(new File(fontPathUI));
        Font font = Font.createFont(Font.TRUETYPE_FONT, is);
        font = font.deriveFont(14f);
        back.setBounds(0, 0, 50, 20);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PremiumMainScreen premiumMainScreen = null;
                try {
                    premiumMainScreen = new PremiumMainScreen(userId, name);
                } catch (IOException | FontFormatException ex) {
                    throw new RuntimeException(ex);
                }
                premiumMainScreen.setVisible(true);
                dispose();
            }
        });
        this.add(back);

        CsvInterface c = new CsvInterface();
        Map<Integer, TopicRequestModel> t = c.topicsReader("database/topic.csv");
        ArrayList<TopicRequestModel> ht = new ArrayList<>();
        for (Integer i : t.keySet()){
            ht.add(t.get(i));
        }
        TopicController tc = new TopicController();
        ArrayList<TopicRequestModel> trm = tc.getHottestTopics();
        JLabel hottestTopics = new PlaceLabel().create(300, 180, 400, 50, "1. "+trm.get(0).get().get(0));
        this.add(hottestTopics);

        JLabel secondHottestTopics = new PlaceLabel().create(300, 220, 400, 50, "2. "+trm.get(1).get().get(0));
        this.add(secondHottestTopics);

        JLabel thirdHottestTopics = new PlaceLabel().create(300, 260, 400, 50, "3. "+trm.get(2).get().get(0));
        this.add(thirdHottestTopics);

        this.setBounds(0, 0, 960, 540);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        container.add(label);
    }
}
