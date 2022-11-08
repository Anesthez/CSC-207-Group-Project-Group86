package Layer4.UI.Screens;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Layer4.UI.Components.*;

public class LoginScreen extends JFrame implements ActionListener {
    public LoginScreen(){


        JPanel username = new JPanel();
        username.setBounds(400, 300, 200, 50);
        username.add(new PlaceLabel().create(0, 0, 50, 50, "username"));

        JPanel password = new JPanel();
        password.setBounds(400, 300, 200, 50);
        password.add(new PlaceLabel().create(0, 0, 50, 50, "username"));

        JButton logIn = new JButton("Log in");
        JButton cancel = new JButton("Cancel");

        JPanel buttons = new JPanel();
        buttons.add(logIn);
        buttons.add(cancel);

        logIn.addActionListener(this);
        cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        JPanel loginScreen = new JPanel();
        loginScreen.setSize(800, 800);
        loginScreen.setLayout(new BoxLayout(loginScreen, BoxLayout.Y_AXIS));

        loginScreen.add(new PlaceLabel().create(400, 50, 100, 25, "UofTMeta"));
        loginScreen.add(username);
        loginScreen.add(password);
        loginScreen.add(buttons);
        this.setContentPane(main);

        this.pack();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
