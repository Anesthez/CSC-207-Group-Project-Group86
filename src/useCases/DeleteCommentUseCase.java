package useCases;

import entity.Comment;

import java.util.Map;

public class DeleteCommentUseCase {
    public void deleteComment(int id, Map<Integer, Comment> comments) {
        comments.remove(id);
    }
}
