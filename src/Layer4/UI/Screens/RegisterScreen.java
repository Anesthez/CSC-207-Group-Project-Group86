package Layer4.UI.Screens;

import Layer3.Controller.RegisterController;
import Layer4.UI.Components.PlaceLabel;
import Layer4.UI.Components.PlaceTextField;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class RegisterScreen extends JFrame {
    public RegisterScreen(){
        PlaceTextField placeTextField = new PlaceTextField();
        this.setLayout(null);
        JPanel username = new JPanel();
        username.setLayout(null);
        username.setBounds(0, 350, 800, 50);
        username.add(new PlaceLabel().create(100, 0, 100, 50, "Username："));
        JTextField usernameText = placeTextField.createTextField(200, 10, 400, 30);
        username.add(usernameText);

        JPanel password = new JPanel();
        password.setLayout(null);
        password.setBounds(0, 400, 800, 50);
        password.add(new PlaceLabel().create(100, 0, 100, 50, "Password："));
        JPasswordField passwordText = new JPasswordField();
        passwordText.setBounds(200, 10, 400, 30);
        password.add(passwordText);

        JPanel password2 = new JPanel();
        password2.setLayout(null);
        password2.setBounds(0, 450, 800, 50);
        password2.add(new PlaceLabel().create(20, 0, 100, 50, "Password again："));
        JPasswordField passwordText2 = new JPasswordField();
        passwordText2.setBounds(200, 10, 400, 30);
        password2.add(passwordText2);

        JButton register = new JButton("Register");
        JButton cancel = new JButton("Cancel");

        JPanel buttons = new JPanel();
        buttons.setBounds(0, 700, 800, 50);
        buttons.add(cancel);
        buttons.add(register);

        cancel.addActionListener(e -> {
            new LoginScreen();
            this.dispose();
        });

        register.addActionListener(e -> {
            String name = usernameText.getText();
            String s_password = passwordText.getText();
            String s_password2 = passwordText2.getText();
            if (s_password.equals(s_password2)){
                try {
                    int a = new RegisterController().register(s_password, name);
                    if (a != -1){
                        new MainScreen(a, name).setVisible(true);
                        this.dispose();}
                    else {
                        JOptionPane.showMessageDialog(null, "Username already exists");
                        usernameText.setText("");
                        passwordText.setText("");
                        passwordText2.setText("");
                    }
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }else{
                JOptionPane.showMessageDialog(null, "The passwords are not the same!");
            }
        });
        this.setSize(800, 800);
        this.add(username);
        this.add(password);
        this.add(password2);
        this.add(buttons);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
