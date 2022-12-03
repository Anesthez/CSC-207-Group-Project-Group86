package useCases;

import entity.Comment;

import java.util.Map;

/**
 * <p>This class is responsible for deleting a comment from the comment list.</p>
 *
 * @author: DominicGu
 */

public class DeleteCommentUseCase {
    public void deleteComment(int id, Map<Integer, Comment> comments) {
        comments.remove(id);
    }
}
