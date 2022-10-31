package Entity;

import inputboundary.Postable;
import inputboundary.Searchable;
import inputboundary.Timeable;

import inputboundary.Context;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Locale;

/**
 * Author: DominicGU
 * Modified by: Yufei Chen, LemengDai
 */
public class Chat extends Context implements Comparable<Chat>{
    private final int user1_id;

    private final int user2_id;


    public Chat(int id, int user1_id, int user2_id, String content, String timestamp) {
        super(id, content, timestamp);
        this.user1_id = user1_id;
        this.user2_id = user2_id;
    }

    public int getSender_id() {
        return user1_id;
    }

    public int getReceiver_id() {
        return user2_id;
    }

    @Override
    public int compareTo(Chat other) {
        LocalDateTime time1 = LocalDateTime.parse(timestamp.substring(0, 4) + "-" + timestamp.substring(5, 7) +
                "-" + timestamp.substring(8, 10) + "T" + timestamp.substring(11));
        LocalDateTime time2 = LocalDateTime.parse(other.getTime().substring(0, 4) + "-" + other.getTime().substring(5, 7) +
                "-" + other.getTime().substring(8, 10) + "T" + other.getTime().substring(11));
        if (time1.isBefore(time2)) {
            return -1;
        } else if (time1.isAfter(time2)) {
            return 1;
        } else {
            return 0;
        }
    }

    public void printChat(){
        System.out.println(timestamp + " (" + user1_id + " sent to " + user2_id + "):" + content);
    }

}
