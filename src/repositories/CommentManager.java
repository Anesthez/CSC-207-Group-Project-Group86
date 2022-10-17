package repositories;

import Entity.Chat;
import Entity.Comment;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Map;

/**
 * Author: Lemeng Dai
 * Modified by:Yufei Chen
 */
public class CommentManager{
    private Map<Integer, Comment> comments;
    public void addComment(int userId, String content) {
        Comment comment = new Comment(userId, comments.keySet().size() + 1, content,
                LocalDate.now().toString());
        comments.put(comment.getId(), comment);
        /**
         * csv reader will read the csv and create comments hashmap
         * add the comment to hashmap and csv
         */
    }

    public void deleteComment(int id) {
        comments.remove(id);
        /**
         * csv reader will read the csv and create comments hashmap
         * remove the comment from hashmap and csv
         */
    }

    public Comment getCommentFromId(int id) {
        /**
         * csv reader will read the csv and create comments hashmap
         * use the hashmap to get comment from id
         * return Entity.Comment object
         */
        return comments.get(id);
    }
}