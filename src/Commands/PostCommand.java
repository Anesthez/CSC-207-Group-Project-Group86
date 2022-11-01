package Commands;

import Entity.Post;
import Interface.csvInterface;
import repositories.PostManager;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
/*
Author: lemeng Dai
 */
public class PostCommand {
    String[] inputLines;
    int userid;
    public PostCommand(String[] inputLines, int userid){
        this.inputLines = inputLines;
        this.userid = userid;
    }

    public void exact() throws IOException {
        csvInterface csvInteract = new csvInterface();
        Map<Integer, Post> posts = csvInteract.postsReader("database/post.csv");
        Map<Integer, ArrayList<Integer>> postLiked =
                csvInteract.postsLikedReader("database/post_liked.csv");
        PostManager postManager = new PostManager(posts, postLiked);
        if (inputLines.length == 3) {
            postManager.addPost(inputLines[1], userid, inputLines[2]);
            csvInteract.postsWriter("database/post.csv", posts);
        } else if (inputLines[1].equals("show")) {
            for (int i = 0; i < 5; i++) {
                System.out.println(postManager.showPost(i));
            }
            //TODO complete show post after discussion
            //TODO question: show 5 recent posts or 5 recent posts from user

        }
    }
}
