package Layer4.UI.DesignedScreens;

import Layer3.Controller.LogInController;
import Layer4.UI.Components.PlaceLabel;
import Layer4.UI.Components.PlaceTextField;

import javax.imageio.ImageIO;
import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

/**
 * <p> This is the redesign version of the login screen by Tianyu Li </p>
 * @author Tianyu Li
 */
public class LoginScreenNew extends JFrame {

    public LoginScreenNew() throws IOException, FontFormatException {

        final String fontPath = "assets/fonts/KleeOne-SemiBold.ttf";
        InputStream is = new FileInputStream(new File(fontPath));
        Font f = Font.createFont(Font.TRUETYPE_FONT, is);
        f = f.deriveFont(12f);

        this.getContentPane().setBackground(new Color(255, 255, 255));
        BufferedImage logo = ImageIO.read(new File("assets/images/logo_1_trans.png"));
        JLabel picLabel = new JLabel(new ImageIcon(logo));
        picLabel.setBounds(150, 150, 500, 500);

        PlaceTextField placeTextField = new PlaceTextField();
        JPanel username = new JPanel();
        username.setBackground(new Color(1.0f,1.0f,1.0f,0));

        username.setLayout(null);
        username.setBounds(0, 350, 800, 50);
        JLabel usrText = new PlaceLabel().create(100, 0, 100, 50, "Username：");
        usrText.setFont(f);
        username.add(usrText);
        username.setFont(f);
        JTextField usernameText = placeTextField.createTextField(200, 10, 400, 30);
        usernameText.setFont(f);
        username.add(usernameText);


        JPanel password = new JPanel();
        password.setBackground(new Color(1.0f,1.0f,1.0f,0));

        password.setLayout(null);
        password.setBounds(0, 400, 800, 50);
        JLabel pwdText = new PlaceLabel().create(100, 0, 100, 50, "Password：");
        pwdText.setFont(f);
        password.add(pwdText);

        JPasswordField passwordText = new JPasswordField();
        passwordText.setBounds(200, 10, 400, 30);
        passwordText.setFont(f);
        password.add(passwordText);

        JButton logIn = new JButton("Log in");
        logIn.setBackground(new Color(1.0f,1.0f,1.0f,0));
        logIn.setFont(f);

        JButton cancel = new JButton("Cancel");
        cancel.setBackground(new Color(1.0f,1.0f,1.0f,0));
        cancel.setFont(f);

        JPanel buttons = new JPanel();
        buttons.setBackground(new Color(1.0f,1.0f,1.0f,0));

        buttons.setBounds(0, 700, 800, 50);
        buttons.add(logIn);
        buttons.add(cancel);

        logIn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ArrayList<Object> userInputs = new ArrayList<>();
                String name = usernameText.getText();
                String password = passwordText.getText();
                userInputs.add(name);
                userInputs.add(password);
                usernameText.setText("");
                passwordText.setText("");
                LogInController logInController = new LogInController(userInputs);
                try {
                    int userId = logInController.login();
                    if (userId == -1){
                        new LoginScreenNew();
                    }else{
                        MainScreenNew mainScreen = new MainScreenNew(userId, name);
                        mainScreen.setVisible(true);
                        dispose();

                    }
                } catch (IOException | FontFormatException ex) {
                    throw new RuntimeException(ex);
                }
            }

        });
        cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ArrayList<Object> userInputs = new ArrayList<>();
                userInputs.add("default");
                userInputs.add("default");
                LogInController logInController = new LogInController(userInputs);
                try {
                    if (logInController.login() == -1){
                        new LoginScreenNew();
                    }
                } catch (IOException | FontFormatException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });


        this.setSize(800, 800);
        this.add(username);
        this.add(password);
        this.add(buttons);
        this.add(picLabel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}
