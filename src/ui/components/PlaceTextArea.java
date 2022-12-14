package ui.components;

import javax.swing.*;

/**
 * <p>
 *     PlaceTextArea contains {@link JTextArea textArea} with the specified coordinate, width, height and text displayed
 * </p>
 * @Author: LemengDai
 */
public class PlaceTextArea {
    JTextArea textArea;

    /**
     * <p>constructs a new {@link JTextArea JTextArea} with the specified coordinate, width, height and text displayed</p>
     * @param x: x coordinate
     * @param y: y coordinate
     * @param width width
     * @param height height
     * @param text: specified text
     */
    public JTextArea create(int x, int y, int width, int height, String text) {
        textArea = new JTextArea(text);
        textArea.setBounds(x, y, width, height);
        return textArea;
    }
}
