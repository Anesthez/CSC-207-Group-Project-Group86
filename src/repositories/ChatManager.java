package repositories;

import Entity.Chat;
import Entity.Comment;
import Entity.User;

public class ChatManager {
    User sender = new User();
    User receiver = new User();
    Comment content = new Comment();

    String timestamp;
    Chat chat = new Chat(User sender, User receiver, Comment content, String timestamp);

    public void addChat(String content, String time)
    {
        Comment con = new Comment(content);
        chat.getContents().add(con);
        chat.getTimes().add(time);
    }

    public void deleteChat(Comment del, String deltime)
    {
        chat.getContents().remove(del);
        chat.getTimes().remove(deltime);
    }


}
