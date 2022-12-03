package useCases;

import databaseInterface.CsvInterface;
import entity.Comment;
import model.request.PostRequestModel;
import useCases.UseCaseFacade.PostUseCasesFacade;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>This class is responsible for adding a new comment to the comment list.</p>
 *
 * @author: DominicGu
 */

public class AddCommentUseCase {
    public void addComment(int userId, String content, int postId, Map<Integer, Comment> comments) {
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
}
