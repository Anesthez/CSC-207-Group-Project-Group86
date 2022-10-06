import java.sql.Timestamp;

public class Comment{
    private int userId;
    private Timestamp timestamp;
    private int id;
    private String content;
    private int views;

    public Comment(int userId, int id, String content) {
        this.userId = userId;
        this.timestamp = new Timestamp(System.currentTimeMillis());  // initialize the timestamp with system time
        this.id = id;
        this.content = content;
        this.views = 0;  // initialize comment with 0 views
    }

    public int getUserId() {
        return userId;
    }

    public Timestamp getTimestamp() {
        return this.timestamp;
    }

    public int getId() {
        return this.id;
    }

    public String getContent() {
        return this.content;
    }

    public int getViews() {
        return this.views;
    }
}