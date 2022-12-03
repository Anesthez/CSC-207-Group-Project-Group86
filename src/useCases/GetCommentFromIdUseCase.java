package useCases;

import entity.Comment;

import java.util.Map;

/**
 * <p>This class is responsible for getting a comment from the comment list.</p>
 *
 * @author: DominicGu
 */

public class GetCommentFromIdUseCase {
    public Comment getCommentFromId(int id, Map<Integer, Comment> comments) {
        return comments.get(id);
    }
}
