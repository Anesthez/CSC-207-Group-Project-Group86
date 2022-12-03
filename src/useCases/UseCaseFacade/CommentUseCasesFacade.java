package useCases.UseCaseFacade;

import entity.Comment;
import entity.factories.CommentFactory;
import model.request.CommentRequestModel;
import model.response.CommentResponseModel;
import useCases.*;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 *     CommentUseCases has methods that could be used to interact with {@link Comment Comment} object.
 * </p>
 * @Author: LemengDai
 * @Modifiedby: Yufei Chen
 */
public class CommentUseCasesFacade {
    private final Map<Integer, Comment> comments = new HashMap<>();
    private final AddCommentUseCase acu;
    private final DeleteCommentUseCase dcu;
    private final GetCommentFromIdUseCase gcfu;
    private final GetCommentsUseCase gcu;


    public CommentUseCasesFacade(Map<Integer, CommentRequestModel> comments) {
        CommentFactory commentFactory = new CommentFactory();
        for (CommentRequestModel commentModel : comments.values()) {
            Comment comment = commentFactory.create(commentModel);
            this.comments.put(comment.getId(), comment);
        }
        this.acu = new AddCommentUseCase();
        this.dcu = new DeleteCommentUseCase();
        this.gcfu = new GetCommentFromIdUseCase();
        this.gcu = new GetCommentsUseCase();
    }

    /**
     * <p>add the comment with userId and content to comments hashmap. Comment id is automatically generated with the
     * value comments size + 1
     * </p>
     * @param userId the id of the user
     * @param content the content of the comment
     */
    public void addComment(int userId, String content, int postId) {
        acu.addComment(userId, content, postId, comments);
    }

    /**
     * <p>remove {@link Comment Comment} object with id from hashmap</p>
     * @param id the comment id
     */
    public void deleteComment(int id) {
        dcu.deleteComment(id, comments);
    }

    /**
     * <p>get {@link Comment Comment} object with id</p>
     * <p>return null if there is no Comment object with id</p>
     * @param id the comment id
     * @return {@link Comment Comment} object with id
     */
    public Comment getCommentFromId(int id) {
        return gcfu.getCommentFromId(id, comments);
    }

    public Map<Integer, CommentResponseModel> getComments() {
        return gcu.getComments(comments);
    }
}