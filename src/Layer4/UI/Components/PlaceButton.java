package Layer4.UI.Components;

import javax.swing.*;

public class PlaceButton {
    JButton button;

    public JButton create(String buttonText, ImageIcon icon, int x,
                                     int y, int width, int height) {
        button = new JButton(buttonText, icon);
        button.setBounds(x, y, width, height);
        return button;
    }
}
