package ui.components;

import javax.swing.*;

/**
 * <p>This class is responsible for creating a button for the place.</p>
 *
 * @author: yufeichen
 */

public class PlaceButton {
    JButton button;

    public JButton create(String buttonText, ImageIcon icon, int x,
                                     int y, int width, int height) {
        button = new JButton(buttonText, icon);
        button.setBounds(x, y, width, height);
        return button;
    }
}
