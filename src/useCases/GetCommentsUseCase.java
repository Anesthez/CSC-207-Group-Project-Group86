package useCases;

import entity.Comment;
import model.response.CommentResponseModel;

import java.util.HashMap;
import java.util.Map;

public class GetCommentsUseCase {
    public Map<Integer, CommentResponseModel> getComments(Map<Integer, Comment> comments) {
        Map<Integer, CommentResponseModel> commentResponseModels = new HashMap<>();
        for (Integer i : comments.keySet()) {
            commentResponseModels.put(i, comments.get(i).responseModel());
        }
        return commentResponseModels;
    }
}
