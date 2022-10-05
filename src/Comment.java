import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Comment{
    private int userid;
    private Timestamp timestamp;
    private int id;
    private String content;
    private int views;

    public Comment(int userid, int id, String content) {
        this.userid = userid;
        this.timestamp = new Timestamp(System.currentTimeMillis());  // initialize the timestamp with system time
        this.id = id;
        this.content = content;
        this.views = 0;  // initialize comment with 0 views
    }

    public int getUserid() {
        return userid;
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