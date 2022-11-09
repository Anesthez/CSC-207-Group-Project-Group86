package Layer4.UI.Screens;

import Layer4.UI.Components.PlaceButton;
import Layer4.UI.Components.PlaceLabel;
import Layer4.UI.Components.PlaceTextArea;
import Layer3.Controller.CommentController;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

public class AddCommentScreen extends JFrame implements ActionListener {

    public AddCommentScreen(int userid){

        JLabel commentContentLabel = new PlaceLabel().create(50,100, 200,30, "Comment Content");
        JTextArea commentContentText = new PlaceTextArea().create(50,150, 500,200, null);

        JButton addComment = new PlaceButton().create("Add Comment",null,100, 700, 150, 50);
        JButton cancel = new PlaceButton().create("Cancel",null,300, 700, 150, 50);

        addComment.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                try {
                    CommentController commentController = new CommentController(commentContentText.getText(), userid);
                    commentController.create();
                    JOptionPane.showMessageDialog(null, String.format("%s created.", commentContentText.getText()));
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e.getMessage());
                }
            }
        });
        cancel.addActionListener(this);
        this.setLayout(null);


        this.setSize(800, 800);

        this.add(new PlaceLabel().create(400, 50, 100, 25, "UofTMeta"));
        this.add(commentContentLabel);
        this.add(commentContentText);
        this.add(addComment);
        this.add(cancel);
    }

    /**
     * Invoked when an action occurs.
     *
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Click " + e.getActionCommand());
        this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
    }


}


