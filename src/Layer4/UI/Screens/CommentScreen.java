package Layer4.UI.Screens;

import Layer4.UI.Components.PlaceButton;
import Layer4.UI.Components.PlaceLabel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CommentScreen extends JPanel implements ActionListener {
    JTextField comment = new JTextField(15);
    public CommentScreen(){
        JLabel title = new JLabel("Comment Screen");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel commentContentLabel = new JLabel("Comment Content");
        JTextField commentContentText = comment;

        JButton addComment = new JButton("Add Comment");
        JButton cancel = new JButton("Cancel");

        JPanel buttons = new JPanel();
        buttons.add(addComment);
        buttons.add(cancel);

        addComment.addActionListener(this);
        cancel.addActionListener(this);


        this.setSize(800, 800);
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        this.add(new PlaceLabel().create(400, 50, 100, 25, "UofTMeta"));
        this.add(title);
        this.add(commentContentLabel);
        this.add(commentContentText);
        this.add(buttons);

        cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

    /**
     * Invoked when an action occurs.
     *
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {

    }


}


