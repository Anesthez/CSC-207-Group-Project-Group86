package Layer4.UI.PremiumScreens.FriendsScreens.ChatScreens;

import Layer3.Controller.ChatController;
import Layer3.Presenter.ChatPresenter;
import Layer4.UI.PremiumScreens.FriendsScreens.FriendsScreen;
import Model.Response.ChatResponseModel;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
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
    static String name;

    public ChatScreen(int userid, int receiverId, String name) throws IOException {
        ChatPresenter cp = new ChatPresenter();
        Object[] chatlist = cp.presentMessages(userid, receiverId);
        ChatScreen.name = name;
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
                ChatResponseModel chat = (ChatResponseModel) chatlist[i];
                JLabel message = new JLabel(chat.get().get(0).toString() + "  "
                        + chat.get().get(1).toString() + "  to  " +
                        chat.get().get(2).toString() + ": " +
                        chat.get().get(3).toString() + "  at  " +
                        chat.get().get(4).toString());
                message.setBounds(50, 500 - 50 * i, 700, 50);
                chatScreen.add(message);
            }
        }

        JButton send = new JButton("Send");
        send.setBounds(575, 725, 100, 40);
        chatScreen.add(send);
        JButton back = new JButton("Back");
        back.setBounds(0, 0, 50, 20);
        chatScreen.add(back);

        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FriendsScreen friendsScreen = null;
                try {
                    friendsScreen = new FriendsScreen(userid, name);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                friendsScreen.setVisible(true);
                chatScreen.dispose();
            }
        });

        JTextArea messageArea = new JTextArea("Enter your message here");
        messageArea.setBounds(50, 600, 700, 100);
        chatScreen.add(messageArea);

        BufferedImage logo = ImageIO.read(new File("assets/images/background.png"));
        ImageIcon imageIcon = new ImageIcon(logo);
        JLabel label = new JLabel(imageIcon);
        label.setSize(1600, 900);
        Container container = getContentPane();
        container.add(label);
        this.setSize(1600, 900);
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
        new ChatScreen(userid, receiverId, name);
    }

    @Override
    public void actionPerformed(ActionEvent e) {}
}