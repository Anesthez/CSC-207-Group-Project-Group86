package Layer4.UI.Screens;

import Layer4.UI.Components.PlaceButton;
import Layer4.UI.Components.PlaceLabel;
import Layer4.UI.Components.PlaceTextField;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PostScreen extends JFrame implements ActionListener {
    public PostScreen() {
        this.add(new PlaceLabel().create(50, 0, 50, 50, "Title"));

        this.add(new PlaceLabel().create(50, 100, 50, 50, "Content"));

        JTextField titleText= new PlaceTextField().createTextField(50, 50, 700, 50);
        titleText.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Title: " + titleText.getText());
            }
        });
        this.add(titleText);

        JTextField contentText = new PlaceTextField().createTextField(50, 150, 700, 500);
        contentText.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Content: " + contentText.getText());
            }
        });
        this.add(contentText);

        JButton postButton = new PlaceButton().create("Post", null,
                650, 675, 100, 50);
        postButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Post button clicked");
            }
        });
        this.add(postButton);


        this.setSize(800, 800);
        this.setLayout(null);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

}
