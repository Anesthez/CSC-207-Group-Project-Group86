package Entity;

import inputboundary.Postable;
import inputboundary.Searchable;
import inputboundary.Timeable;

import java.util.ArrayList;
/**
 * Author: eric-qli
 * Modified by: Yufei Chen
 */
public class Post implements Postable, Searchable,Timeable{


    private String postTitle;
    private final int userId;
    private final String timestamp;
    private final int id;
    private final String content;
    private final ArrayList<Integer> list_comment_id;
    private int views;
    private int numLikes;
    private final ArrayList<Integer> userLiked;

    private final Integer popularity = views + numLikes * 10;

    public Integer getPopularity() {
        return popularity;
    }

    public Post(String postTitle, int userId, int id, String content, String timestamp,
                int views, int numLikes, ArrayList<Integer> userLiked, ArrayList<Integer> list_comment_id) {
        this.postTitle = postTitle;
        this.userId = userId;
        this.timestamp = timestamp;
        this.id = id;
        this.content = content;
        this.views = views;
        this.numLikes = numLikes;
        this.userLiked = userLiked;
        this.list_comment_id = list_comment_id;
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

    public int getId() {
        return id;
    }

    public String getContent() {
        return this.content;
    }

    public int getNumLikes(){
        return numLikes;
    }

    public ArrayList<Integer> getListComment(){return list_comment_id;}

    public void addListComment(int commentId){
        list_comment_id.add(commentId);
    }

    public void removeListComment(int commentId){list_comment_id.remove(commentId);}

    public int getViews() {
        return this.views;
    }

    public void addViews(){
        this.views ++;
    }

    public ArrayList<Integer> getUserLiked(){
        return this.userLiked;
    }

    public void addUserLike(int userId){
        userLiked.add(userId);
        numLikes += 1;
    }

    public boolean removeUserLike(int UserId){
        try {
            userLiked.remove(userId);
            numLikes -= 1;
            return true;
        }catch(IndexOutOfBoundsException O){
            return false;
        }



    }

//    public String likes(User user){
//        for (User u: userLiked){
//            int pos = 0; // position of the arrayList
//            if (u.getUserId() == user.getUserId()){
//                numLikes--;
//                userLiked.remove(pos);
//                return null;
//            }
//            pos++;
//        }
//
//        numLikes++;
//        userLiked.add(user);
//        return null;
//        /**
//         * first check if the user already liked the post
//         * case 1 liked: remove the like and remove the user from liked list
//         * case 2 havent liked: add a like and add the user to the liked list
//         */
//    }

    @Override
    public String getTime() {
        return timestamp;
    }
}
