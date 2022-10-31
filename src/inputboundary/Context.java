package inputboundary;

/**
 * Author: LemengDai
 */
public abstract class Context implements Timeable, Searchable, Postable{
    protected final int id;
    protected final String content;
    protected final String timestamp;

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
