package Layer4.UI.Components;

import javax.swing.*;

public class Panel {
    JTextField textField;


    public JTextField createTextField(int x, int y, int width, int height) {
        textField = new JTextField();
        textField.setBounds(x, y, width, height);
        return textField;
    }
}