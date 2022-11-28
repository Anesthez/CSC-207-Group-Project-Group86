package ui.screens;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;

import controller.LogInController;
import ui.premiumScreens.PremiumMainScreen;
import model.response.UserResponseModel;
import ui.components.PlaceLabel;
import ui.components.PlaceTextField;

public class LoginScreen extends JFrame{
    public LoginScreen(){
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

        JButton logIn = new JButton("Log in");
        JButton register = new JButton("Register");

        JPanel buttons = new JPanel();
        buttons.setBounds(0, 700, 800, 50);
        buttons.add(logIn);
        buttons.add(register);

        logIn.addActionListener(e -> {
            ArrayList<Object> userInputs = new ArrayList<>();
            String name = usernameText.getText();
            String password1 = passwordText.getText();
            userInputs.add(name);
            userInputs.add(password1);
            usernameText.setText("");
            passwordText.setText("");
            LogInController logInController = new LogInController(userInputs);
            try {
                UserResponseModel userResponseModel = logInController.login();
                if (userResponseModel == null){
                    new LoginScreen();
                }else if (userResponseModel.get().get(1).equals("premium")){
                    int userId = (int) userResponseModel.get().get(0);
                    PremiumMainScreen mainScreen = new PremiumMainScreen(userId, name);
                    mainScreen.setVisible(true);
                    dispose();

                }else{
                    int userId = (int) userResponseModel.get().get(0);
                    MainScreen mainScreen = new MainScreen(userId, name);
                    mainScreen.setVisible(true);
                    dispose();
                }
            } catch (IOException | FontFormatException ex) {
                throw new RuntimeException(ex);
            }
        });
        register.addActionListener(e -> {
            RegisterScreen registerScreen = new RegisterScreen();
            registerScreen.setVisible(true);
            dispose();
        });


        this.setSize(800, 800);

        this.add(new PlaceLabel().create(400, 50, 100, 25, "UofTMeta"));
        this.add(username);
        this.add(password);
        this.add(buttons);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}
