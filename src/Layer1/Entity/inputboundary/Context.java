package Layer1.Entity.inputboundary;

/**
 * <p>Context is an abstract class that is inherited by {@link Layer1.Entity.Chat Chat}, {@link Layer1.Entity.Comment Comment}
 * and {@link Layer1.Entity.Post Post}. Context also implements {@link Timeable Timeable}, {@link Searchable Searchable},
 * {@link Postable Postable}</p>}
 * @Author: LemengDai
 */
public abstract class Context implements Timeable, Searchable, Postable{
    protected final int id;
    protected final String content;
    protected final String timestamp;

    /**
     *<p>initialize Context object with id, content and timestamp</p>
     * @param id
     * @param content
     * @param timestamp
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
