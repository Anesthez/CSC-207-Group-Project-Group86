package ui.components;
import javax.swing.*;

/**
 * <p>This class is responsible for creating a button for the place.</p>
 *
 * @author: yufeichen
 */

public class PlaceLabel {
    JLabel label;

    public JLabel create(int x, int y, int width, int height, String text){
        label = new JLabel(text);
        label.setBounds(x, y, width, height);
        return label;
    }
}
