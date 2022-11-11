package Layer1.Entity.factories;

import Layer1.Entity.Comment;
import Model.Request.CommentRequestModel;

import java.util.ArrayList;


public class CommentFactory {
    /**
     *<p>CommentFactory is a factory used to create {@link Comment Comment} object.</p>
     * @param commentModel the model for the comment
     * @return comment object with userId, id, content and timestamp
     */
    public Comment create(CommentRequestModel commentModel){
        ArrayList<Object> CommentContents = commentModel.get();
        return new Comment((int)CommentContents.get(0),
                (int) CommentContents.get(1),
                (String) CommentContents.get(2),
                (String) CommentContents.get(3));
    }
}
