import Layer4.UI.Screens.HotPostScreen;
import Layer4.UI.Screens.LoginScreen;

import javax.swing.*;
import java.awt.*;

public class main {
    public static void main(String[] args) {
        JFrame frame  = new JFrame("UoftMeta");
        HotPostScreen hotPost = new HotPostScreen(frame);
        CardLayout cardLayout = new CardLayout();
        JPanel screens = new JPanel(cardLayout);
        screens.add(hotPost, "login");
        frame.add(screens);
        cardLayout.show(screens, "UoftMeta");
        frame.setSize(800, 800);
        frame.setVisible(true);
    }
}
