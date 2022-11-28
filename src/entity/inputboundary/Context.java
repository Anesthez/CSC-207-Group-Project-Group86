package entity.inputboundary;

import entity.Chat;
import entity.Comment;
import entity.Post;

/**
 * <p>Context is an abstract class that is inherited by {@link Chat Chat}, {@link Comment Comment}
 * and {@link Post Post}. Context also implements {@link Timeable Timeable}, {@link Searchable Searchable},
 * {@link Postable Postable}</p>}
 * @Author: LemengDai
 */
public abstract class Context implements Timeable, Searchable, Postable, Modelizable{
    protected final int id;
    protected final String content;
    protected final String timestamp;

    /**
     *<p>initialize Context object with id, content and timestamp</p>
     * @param id the id of the context
     * @param content the content of the context
     * @param timestamp the timestamp of the context
     */
    public Context(int id, String content, String timestamp) {
        this.id = id;
        this.content = content;
        this.timestamp = timestamp;
    }

    public int getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public String getTime(){
        return timestamp;
    }
}
