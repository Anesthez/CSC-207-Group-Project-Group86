import java.sql.Timestamp;

public class Post {

    private int userId;
    private Timestamp timestamp;
    private int postId;
    private String content;
    private int views;

    public Post(int userId, int postId, String content) {
        this.userId = userId;
        this.timestamp = new Timestamp(System.currentTimeMillis());
        this.postId = postId;
        this.content = content;
        this.views = 0;
    }

    public int getUserId() {
        return userId;
    }

    public Timestamp getTimestamp() {
        return this.timestamp;
    }

    public int getPostId() {
        return this.postId;
    }

    public String getContent() {
        return this.content;
    }

    public void setContent(String text) {
        this.content = text;
    }

    public int getViews() {
        return this.views;
    }

    public void addViews(){
        this.views ++;
    }
}
