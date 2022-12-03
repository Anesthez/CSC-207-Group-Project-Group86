package ui.components;

import javax.swing.*;

/**
 * <p>This class is responsible for creating a button for the place.</p>
 *
 * @author: yufeichen
 */

public class PlaceTextField {
    JTextField textField;


    public JTextField createTextField(int x, int y, int width, int height) {
        textField = new JTextField();
        textField.setBounds(x, y, width, height);
        return textField;
    }
}
