package useCases;

import entity.Comment;
import model.response.CommentResponseModel;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>This class is responsible for getting a comment from the comment list.</p>
 *
 * @author: DominicGu
 */

public class GetCommentsUseCase {
    public Map<Integer, CommentResponseModel> getComments(Map<Integer, Comment> comments) {
        Map<Integer, CommentResponseModel> commentResponseModels = new HashMap<>();
        for (Integer i : comments.keySet()) {
            commentResponseModels.put(i, comments.get(i).responseModel());
        }
        return commentResponseModels;
    }
}
