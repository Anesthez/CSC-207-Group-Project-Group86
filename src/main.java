import Layer4.UI.Screens.LoginScreen;

import javax.swing.*;
import java.awt.*;

public class main {
    public static void main(String[] args) {
        LoginScreen login = new LoginScreen();
        JFrame frame  = new JFrame("UoftMeta");
        CardLayout cardLayout = new CardLayout();
        JPanel screens = new JPanel(cardLayout);
        screens.add(login, "login");
        frame.add(screens);
        cardLayout.show(screens, "UoftMeta");
        frame.setSize(800, 800);
        frame.setVisible(true);
    }
}
