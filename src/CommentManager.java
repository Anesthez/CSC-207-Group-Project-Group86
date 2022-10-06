public class CommentManager{
    public void addComment(int userId, int id, String content) {
        Comment comment = new Comment(userId, id, content);
        /**
         * csv reader will read the csv and create comments hashmap
         * add the comment to hashmap and csv
         */
    }

    public void deleteComment(int id) {
        /**
         * csv reader will read the csv and create comments hashmap
         * remove the comment from hashmap and csv
         */
    }

    public Comment getCommentFromId(int id) {
        /**
         * csv reader will read the csv and create comments hashmap
         * use the hashmap to get comment from id
         * return Comment object
         */
        return null;
    }
}