package Layer4.UI.Screens;

import Layer4.UI.Components.PlaceLabel;
import Layer4.UI.Components.PlaceTextField;

import javax.swing.*;
import java.awt.event.ActionListener;

/**
 * Author: Eric Li
 */

public abstract
class AddFriendsScreen extends JFrame implements ActionListener {
    public AddFriendsScreen(){
        JPanel main = new JPanel();
        main.setSize(800, 800);
        main.setLayout(new BoxLayout(main, BoxLayout.Y_AXIS));

        JPanel friends = new JPanel();
        friends.setLayout(new BoxLayout(friends, BoxLayout.Y_AXIS));
        friends.add(new PlaceLabel().create(400, 50, 100, 25, "Friends"));

        JPanel buttons = new JPanel();
        JButton addFriend = new JButton("Add Friend");
        JButton removeFriend = new JButton("Remove Friend");
        JButton back = new JButton("Back");
        buttons.add(addFriend);
        buttons.add(removeFriend);
        buttons.add(back);

        addFriend.addActionListener(this);
        removeFriend.addActionListener(this);
        back.addActionListener(this);

        main.add(friends);
        main.add(buttons);
        this.setContentPane(main);

        this.pack();
    }
}

