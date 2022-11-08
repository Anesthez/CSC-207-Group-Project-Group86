package Layer4.UI.Components;
import javax.swing.*;

public class PlaceLabel {
    JLabel label;

    public JLabel create(int x, int y, int width, int height, String text){
        label = new JLabel(text);
        label.setBounds(x, y, width, height);
        return label;
    }
}
