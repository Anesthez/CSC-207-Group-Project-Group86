package Layer3.Commands;

import Layer1.Entity.Post;
import Layer4.Interface.csvInterface;
import Layer2.UseCases.PostUseCases;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

/**
 * <p>This class contains the command for operations for a post using CLI</p>
 *
 * @Author: lemeng Dai
 * @Modified by: Chen Jiang

 */
public class PostCommand {
    String[] inputLines;
    int userid;
    String topic;

    /**
     * <p>Constructor for the PostCommand object</p>
     *
     * @param inputLines the input lines from the CLI
     * @param userid the id of the user
     */
    public PostCommand(String[] inputLines, int userid){
        this.inputLines = inputLines;
        this.userid = userid;
    }

    /**
     * <p>Execute the command for operations for a post using CLI</p>
     *
     * @throws IOException if the file is not found
     */
    public void exact() throws IOException {
        csvInterface csvInteract = new csvInterface();
        Map<Integer, Post> posts = csvInteract.postsReader("database/post.csv");
        Map<Integer, ArrayList<Integer>> postLiked =
                csvInteract.postsLikedReader("database/post_liked.csv");
        PostUseCases postUseCases = new PostUseCases(posts, postLiked);
        if (inputLines.length == 3) {
            //TODO: check this with DaiLemeng
            postUseCases.addPost(inputLines[1], userid, inputLines[2], topic);
            csvInteract.postsWriter("database/post.csv", posts);
        } else if (inputLines[1].equals("show")) {
            for (int i = 0; i < 5; i++) {
                System.out.println(postUseCases.showPost(i));
            }
            //TODO complete show post after discussion
            //TODO question: show 5 recent posts or 5 recent posts from user

        }
    }
}
