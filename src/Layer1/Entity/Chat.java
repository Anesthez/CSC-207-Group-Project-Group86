package Layer1.Entity;

import Layer1.Entity.inputboundary.Context;

import java.time.LocalDateTime;

/**
 * <p>The chat object is a chat message that is sent by one user, and received by another user. The object is a
 * subclass for context which will extends the properties for the {@link Context Context}</p>
 *
 * <p>The chat object contains id of the chat, the id of the user that sent it and received it,
 * the content of the chat and the time that the chat is sent. To initialize it, we need all the elements.</p>
 *
 * <p>The chat object contains mothods to get receiver's id and sender's id, a print method to output the chat,
 * a toString method to convert the chat into a String containing all the information, which is more friendly to
 * the reader, and a compareTo method to allow comparison between chats based on the time the chat is sent.</p>
 *
 * @Author: Jiahao Gu
 * @Modifiedby: Yufei Chen, LemengDai
 */

public class Chat extends Context implements Comparable<Chat>{
    private final int user1_id;

    private final int user2_id;

    /**
     * <p>Constructor for the chat object. It takes in the id of the chat, the id of the user that sent it,
     * the id of the user that received it, the content of the chat and the time that the chat is sent.</p>
     *
     * @param id the id of the chat
     * @param user1_id the id of the user that sent the chat
     * @param user2_id the id of the user that received the chat
     * @param content the content of the chat
     * @param timestamp the time that the chat is sent
     */
    public Chat(int id, int user1_id, int user2_id, String content, String timestamp) {
        super(id, content, timestamp);
        this.user1_id = user1_id;
        this.user2_id = user2_id;
    }

    /**
     * <p>Getter for the id of the user that sender the chat.</p>
     *
     * @return the id of the user that send the chat
     */
    public int getSender_id() {
        return user1_id;
    }

    /**
     * <p>Getter for the id of the user that receive the chat.</p>
     *
     * @return the id of the user that receive the chat
     */
    public int getReceiver_id() {
        return user2_id;
    }

    /**
     * <p>Compare two chats based on the time sent</p>
     */
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

    /**
     * <p>Print the chat in a friendly format.</p>
     */
    public void printChat(){
        System.out.println(this.toString());
    }

    /**
     * <p>Convert the chat into a String containing all the information.</p>
     *
     * @return the String containing all the information
     */
    @Override
    public String toString(){
        return timestamp + " (" + user1_id + " sent to " + user2_id + "):" + content;
    }

}
