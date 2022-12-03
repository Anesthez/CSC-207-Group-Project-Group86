package useCases.UseCaseFacade;

import entity.Comment;
import entity.factories.CommentFactory;
import databaseInterface.CsvInterface;
import model.request.CommentRequestModel;
import model.request.PostRequestModel;
import model.response.CommentResponseModel;
import useCases.AddChatUseCase;
import useCases.AddCommentUseCase;
import useCases.DeleteCommentUseCase;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
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
    private AddCommentUseCase acu;
    private DeleteCommentUseCase dcu;



    public CommentUseCasesFacade(Map<Integer, CommentRequestModel> comments) {
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
    public void addComment(int userId, String content, int postId) {
        CsvInterface csvInteract = new CsvInterface();
        Map<Integer, PostRequestModel> posts;
        Map<Integer, ArrayList<Integer>> posts_liked = new HashMap<>();
        try {
            posts = csvInteract.postsReader("database/post.csv");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Comment comment = new Comment(userId, comments.keySet().size() + 1, content,
                LocalDate.now().toString(), postId);

        for (Integer k:posts.keySet()) {

            ArrayList<Integer> users = (ArrayList<Integer>) posts.get(k).get().get(7);
            posts_liked.put(k, users);
        }
        PostUseCasesFacade postUseCases = new PostUseCasesFacade(posts, posts_liked);
        postUseCases.addComment_id(postId, comment.getId());
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
        Map<Integer, CommentResponseModel> commentResponseModels = new HashMap<>();
        for (Integer i : this.comments.keySet()) {
            commentResponseModels.put(i, comments.get(i).responseModel());
        }
        return commentResponseModels;
    }
}