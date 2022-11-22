package Layer3.Commands;


import Layer4.Interface.csvInterface;
import Layer2.UseCases.PostUseCases;
import Model.Request.PostRequestModel;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
/*
Author: lemeng Dai
Modified by: Chen Jiang
 */
public class PostCommand {
    String[] inputLines;
    int userid;
    String topic;
    public PostCommand(String[] inputLines, int userid){
        this.inputLines = inputLines;
        this.userid = userid;
    }

    public void exact() throws IOException {
        csvInterface csvInteract = new csvInterface();
        Map<Integer, PostRequestModel> posts = csvInteract.postsReader("database/post.csv");
        Map<Integer, ArrayList<Integer>> postLiked =
                csvInteract.postsLikedReader("database/post_liked.csv");
        PostUseCases postUseCases = new PostUseCases(posts, postLiked);
        if (inputLines.length == 3) {
            postUseCases.addPost(inputLines[1], userid, inputLines[2], topic);
            csvInteract.postsWriter("database/post.csv", postUseCases.getPostsResponseModel());
        } else if (inputLines[1].equals("show")) {
            for (int i = 0; i < 5; i++) {
                System.out.println(postUseCases.showPost(i));
            }
            //TODO complete show post after discussion
            //TODO question: show 5 recent posts or 5 recent posts from user

        }
    }
}
