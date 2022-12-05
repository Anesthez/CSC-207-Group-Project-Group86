package ui.premiumScreens.friendsScreens;

import controller.AddFriendController;
import javax.swing.*;

import java.awt.*;
import java.io.IOException;

/**
 * Author: Eric Li
 */


class AddFriendsScreen extends JFrame{
    public AddFriendsScreen(int userId, String name){
        this.setLayout(null);
        JButton back = new JButton("Back");
        back.setBounds(0, 0, 50, 20);
        back.addActionListener(e -> {
            FriendsScreen friendsScreen;
            try {
                friendsScreen = new FriendsScreen(userId, name);
            } catch (IOException | FontFormatException ex) {
                throw new RuntimeException(ex);
            }
            friendsScreen.setVisible(true);
            dispose();
        });
        JLabel label = new JLabel("Enter the username of the user you want to add");
        JTextField textField = new JTextField();
        JButton add = new JButton("Add");
        add.setBounds(350, 300, 50, 20);
        textField.setBounds(350, 250, 100, 20);
        add.addActionListener(e -> {
            AddFriendController addFriendController = new AddFriendController();
            try {
                if (addFriendController.add(userId, Integer.parseInt(textField.getText()))){
                    JOptionPane.showMessageDialog(null, String.format("%s added.",
                            textField.getText()));
                    textField.setText("");
                }
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
        });
        this.add(back);
        this.add(label);
        this.add(textField);
        this.add(add);
        this.setSize(800, 800);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }


}

