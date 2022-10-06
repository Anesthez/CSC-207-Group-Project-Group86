public class PostManager {

    public void addPost(int userId, int postId, String content){
        Post post = new Post(userId, postId, content);
    }

    public Post getPostFromId(int postId){
        /**
         * pull from the csv file
         */
    }

    public void addComment(Comment comment){
        /**
         * idk from where but this is easy and will come back to it
         */
    }

    public void deleteComment(Comment comment){
        /**
         * same as addComment
         */
    }

    public Post searchPost(){

    }


    /**
     * questions:
     * 1. how to storage comment
     * 2. delete by comment or commentid
     * 3. delete from the file or hide from the post
     * 4. if this blog is text based then there should be a title for each post
     * 5. search method: search engine? search by post id? should id be private?
     *
     */
}

}
