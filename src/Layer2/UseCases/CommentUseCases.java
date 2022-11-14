package Layer2.UseCases;

import Layer1.Entity.Comment;
import Layer1.Entity.factories.CommentFactory;
import Model.Request.CommentRequestModel;
import Model.Response.CommentResponseModel;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 *     CommentUseCases has methods that could be used to interact with {@link Comment Comment} object.
 * </p>
 * @Author: LemengDai
 * @Modifiedby: Yufei Chen
 */
public class CommentUseCases {
    private final Map<Integer, Comment> comments = new HashMap<>();

    public CommentUseCases(Map<Integer, CommentRequestModel> comments) {
        CommentFactory commentFactory = new CommentFactory();
        for (CommentRequestModel commentModel : comments.values()) {
            Comment comment = commentFactory.create(commentModel);
            this.comments.put(comment.getId(), comment);
        }
    }

    /**
     * <p>add the comment with userId and content to comments hashmap. Comment id is automatically generated with the
     * value comments size + 1
     * </p>
     * @param userId the id of the user
     * @param content the content of the comment
     */
    public void addComment(int userId, String content) {
        Comment comment = new Comment(userId, comments.keySet().size() + 1, content,
                LocalDate.now().toString());
        comments.put(comment.getId(), comment);
    }

    /**
     * <p>remove {@link Comment Comment} object with id from hashmap</p>
     * @param id the comment id
     */
    public void deleteComment(int id) {
        comments.remove(id);
    }

    /**
     * <p>get {@link Comment Comment} object with id</p>
     * <p>return null if there is no Comment object with id</p>
     * @param id the comment id
     * @return {@link Comment Comment} object with id
     */
    public Comment getCommentFromId(int id) {
        return comments.get(id);
    }

    public Map<Integer, CommentResponseModel> getComments() {
        Map<Integer, CommentResponseModel> commentResponseModels = new HashMap<Integer, CommentResponseModel>();
        for (Integer i : this.comments.keySet()) {
            commentResponseModels.put(i, comments.get(i).responseModel());
        }
        return commentResponseModels;
    }
}