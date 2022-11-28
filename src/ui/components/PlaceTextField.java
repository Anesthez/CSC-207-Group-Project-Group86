package ui.components;

import javax.swing.*;

public class PlaceTextField {
    JTextField textField;


    public JTextField createTextField(int x, int y, int width, int height) {
        textField = new JTextField();
        textField.setBounds(x, y, width, height);
        return textField;
    }
}
