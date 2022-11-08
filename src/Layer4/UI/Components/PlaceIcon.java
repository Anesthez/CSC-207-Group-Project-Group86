package Layer4.UI.Components;

import javax.swing.*;
import java.util.Objects;

public class PlaceIcon {
    ImageIcon icon;

    public ImageIcon create(String iconFilePath) {
        icon = new ImageIcon(Objects.requireNonNull(this.getClass().getResource(iconFilePath)));
        return icon;
    }
}