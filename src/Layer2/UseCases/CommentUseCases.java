package Layer2.UseCases;

import Layer1.Entity.Comment;

import java.time.LocalDate;
import java.util.Map;

/**
 * <p>
 *     CommentUseCases has methods that could be used to interact with {@link Comment Comment} object.
 * </p>
 * @Author: LemengDai
 * @Modifiedby: Yufei Chen
 */
public class CommentUseCases {
    private Map<Integer, Comment> comments;

    public CommentUseCases(Map<Integer, Comment> comments) {
        this.comments = comments;
    }

    /**
     * <p>add the comment with userId and content to comments hashmap. Comment id is automatically generated with the
     * value comments size + 1
     * </p>
     * @param userId
     * @param content
     */
    public void addComment(int userId, String content) {
        Comment comment = new Comment(userId, comments.keySet().size() + 1, content,
                LocalDate.now().toString());
        comments.put(comment.getId(), comment);
    }

    /**
     * <p>remove {@link Comment Comment} object with id from hashmap</p>
     * @param id
     */
    public void deleteComment(int id) {
        comments.remove(id);
    }

    /**
     * <p>get {@link Comment Comment} object with id</p>
     * <p>return null if there is no Comment object with id</p>
     * @param id
     * @return {@link Comment Comment} object with id
     */
    public Comment getCommentFromId(int id) {
        return comments.get(id);
    }
}