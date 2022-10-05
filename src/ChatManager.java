public class ChatManager {
    User sender = new User();
    User receiver = new User();
    Comments content = new Comments();

    String timestamp;
    Chat chat = new Chat(User sender, User receiver, Comments content, String timestamp);

    public void addChat(String content, String time)
    {
        Comments con = new Comments(content);
        chat.getContents().add(con);
        chat.getTimes().add(time);
    }

    public void deleteChat(Comments del, String deltime)
    {
        chat.getContents().remove(del);
        chat.getTimes().remove(deltime);
    }


}
