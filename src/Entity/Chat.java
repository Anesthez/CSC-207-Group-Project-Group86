package Entity;

import inputboundary.Postable;
import inputboundary.Searchable;
import inputboundary.Timeable;

import java.util.ArrayList;

/**
 * Author: DominicGU
 * Modified by: Yufei Chen
 */
public class Chat implements Timeable, Postable, Searchable {
    private final int id;

    private final int user1_id;

    private final int user2_id;

    private final String content;
    private final String timestamp;

    private ArrayList<String> times = new ArrayList<>();
    //private Map<Comments, String> contentAndTime = new Map<Comments, String>();

    public Chat(int id, int user1_id, int user2_id, String content, String timestamp) {
        this.id = id;
        this.user1_id = user1_id;
        this.user2_id = user2_id;
        this.content = content;
        this.timestamp = timestamp;
    }

    public ArrayList<String> getTimes() {
        return times;
    }

    public int getId(){return id;}

    public void setTimes(ArrayList<String> times) {
        this.times = times;
    }

    public int getSender_id() {
        return user1_id;
    }

    public int getReceiver_id() {
        return user2_id;
    }

    public String getContent() {
        return content;
    }

    public String getTime() {
        return timestamp;
    }

}
