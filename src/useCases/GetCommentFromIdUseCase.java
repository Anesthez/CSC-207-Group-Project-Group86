package useCases;

import entity.Comment;

import java.util.Map;

public class GetCommentFromIdUseCase {
    public Comment getCommentFromId(int id, Map<Integer, Comment> comments) {
        return comments.get(id);
    }
}
