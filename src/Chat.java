import java.util.ArrayList;
import java.util.Map;

public class Chat implements Timable, Postable{
    private User sender;
    private User receiver;
    private Comments content;

    private ArrayList<Comments> contents = new ArrayList<>();
    private String timestamp;

    private ArrayList<String> times = new ArrayList<>();
    //private Map<Comments, String> contentAndTime = new Map<Comments, String>();

    public Chat(User sender, User receiver, Comments content, String timestamp) {
        this.sender = sender;
        this.receiver = receiver;
        this.content = content;
        this.timestamp = timestamp;
    }

    public ArrayList<Comments> getContents() {
        return contents;
    }

    public void setContents(ArrayList<Comments> contents) {
        this.contents = contents;
    }

    public ArrayList<String> getTimes() {
        return times;
    }

    public void setTimes(ArrayList<String> times) {
        this.times = times;
    }

    public User getSender() {
        return sender;
    }

    public void setSender(User sender) {
        this.sender = sender;
    }

    public User getReceiver() {
        return receiver;
    }

    public void setReceiver(User receiver) {
        this.receiver = receiver;
    }

    public Comments getContent() {
        return content;
    }

    public void setContent(Comments content) {
        this.content = content;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
}
