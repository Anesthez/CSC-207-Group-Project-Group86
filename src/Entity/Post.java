package Entity;

import java.sql.Timestamp;
import java.util.ArrayList;

public class Post {


    private String postTitle;
    private final int userId;
    private final Timestamp timestamp;
    private final int postId;
    private String content;
    private int views;
    private int numLikes;
    private ArrayList<User> userLiked;


    public Post(String postTitle, int userId, int postId, String content) {
        this.postTitle = postTitle;
        this.userId = userId;
        this.timestamp = new Timestamp(System.currentTimeMillis());
        this.postId = postId;
        this.content = content;
        this.views = 0;
        this.numLikes = 0;
        this.userLiked = new ArrayList<User>();
    }


    public String getPostTitle(){
        return this.postTitle;
    }

    public void setPostTitle(String postTitle){
        this.postTitle = postTitle;
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

    public String likes(User user){
        for (User u: userLiked){
            int pos = 0; // position of the arrayList
            /**
             * change the fucntion name when user class is done
             */
            if (u.getUserId() == user.getUserId()){
                numLikes--;
                userLiked.remove(pos);
                return null;
            }
            pos++;
        }

        numLikes++;
        userLiked.add(user);
        return null;
        /**
         * first check if the user already liked the post
         * case 1 liked: remove the like and remove the user from liked list
         * case 2 havent liked: add a like and add the user to the liked list
         */
    }
}
