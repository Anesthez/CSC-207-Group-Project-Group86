package Layer4.UI.Screens;

import Layer3.Presenter.ChatPresenter;
import Layer3.Controller.ChatController;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

/**
 * <p>The ChatScreen is the UI of chat. It shows 10 latest messages between two users and it allow user to send a
 * message to the othe user.@</p>
 * @Author: Jiahao Gu
 */

public class ChatScreen extends JFrame implements ActionListener {
    /**
     * <p>Constructor for the ChatScreen. It takes in the {@link ChatController ChatController} and the {@link ChatPresenter ChatPresenter}.</p>
     *
     * @param chatController the ChatController
     * @param chatPresenter the ChatPresenter
     */

    public ChatScreen(int userid, int receiverId) throws IOException {
        ChatPresenter cp = new ChatPresenter();
        Object[] chatlist = cp.presentMessages(userid, receiverId);

        JFrame chatScreen = new JFrame();

        JLabel pastChat = new JLabel("Past Messages:");
        pastChat.setBounds(50, 20, 700, 50);
        chatScreen.add(pastChat);

        if (chatlist.length == 0) {
            JLabel message = new JLabel("No message found");
            message.setBounds(50, 50, 700, 50);
            chatScreen.add(message);
        } else {
            for (int i = 0; i < Math.min(10, chatlist.length); i++) {
                JLabel message = new JLabel(chatlist[i].toString());
                message.setBounds(50, 500 - 50 * i, 700, 50);
                chatScreen.add(message);
            }
        }

        JButton send = new JButton("Send");
        send.setBounds(575, 725, 100, 40);
        chatScreen.add(send);

        JTextArea messageArea = new JTextArea("Enter your message here");
        messageArea.setBounds(50, 600, 700, 100);
        chatScreen.add(messageArea);

        chatScreen.setSize(800, 800);
        send.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = messageArea.getText();
                ChatController cc = new ChatController();
                try {
                    cc.addChat(userid, receiverId, text);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                messageArea.setText("Message Sent");
            }
        });
        JButton refresh = new JButton("Refresh");
        refresh.setBounds(675, 725, 100, 40);
        chatScreen.add(refresh);
        refresh.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    ChatScreen.new_window(userid, receiverId);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                chatScreen.dispose();
            }
        });
        chatScreen.setLayout(null);
        chatScreen.setVisible(true);
    }

    public static void main(String[] args) throws IOException {
        ChatScreen.new_window(2, 3);
    }

    public static void new_window(int userid, int receiverId) throws IOException {
        new ChatScreen(userid, receiverId);
    }

    @Override
    public void actionPerformed(ActionEvent e) {}
}