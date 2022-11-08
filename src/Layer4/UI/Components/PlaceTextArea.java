package Layer4.UI.Components;

import javax.swing.*;

public class PlaceTextArea {
    JTextArea textArea;

    public JTextArea create(int x, int y, int width, int height, String text) {
        textArea = new JTextArea(text);
        textArea.setBounds(x, y, width, height);
        return textArea;
    }
}
