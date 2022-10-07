package Entity;

import inputboundary.Postable;
import inputboundary.Timable;

import java.util.ArrayList;

public class Chat implements Timable, Postable {
    private User sender;
    private User receiver;
    private Comment content;

    private ArrayList<Comment> contents = new ArrayList<>();
    private String timestamp;

    private ArrayList<String> times = new ArrayList<>();
    //private Map<Comments, String> contentAndTime = new Map<Comments, String>();

    public Chat(User sender, User receiver, Comment content, String timestamp) {
        this.sender = sender;
        this.receiver = receiver;
        this.content = content;
        this.timestamp = timestamp;
    }

    public ArrayList<Comment> getContents() {
        return contents;
    }

    public void setContents(ArrayList<Comment> contents) {
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

    public Comment getContent() {
        return content;
    }

    public void setContent(Comment content) {
        this.content = content;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public void addPost() {

    }

    @Override
    public void deletePost() {

    }

    @Override
    public void changePost() {

    }

    @Override
    public void searchPost() {

    }

    @Override
    public void setTime() {

    }

    @Override
    public void getTime() {

    }

    @Override
    public void changeTime() {

    }

    @Override
    public void deleteTime() {

    }
}
