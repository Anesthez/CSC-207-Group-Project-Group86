import Entity.*;
import Interface.*;
import repositories.*;

import java.io.*;
import java.util.*;


public class CLI {
    private String username;
    private int userid;

    private final csvInterface csvInteract = new csvInterface();

    public void loginInterface() throws IOException {
        Scanner input = new Scanner(System.in);

        Map<Integer, User> users = csvInteract.usersReader("database/user.csv");
        UserManager userManager = new UserManager(users);
        boolean flag = true;
        boolean exit = false;
        while (flag) {
            String userInput = input.nextLine();
            if (userInput.length() < 5) {
                System.out.println("unknown command");
            } else if (userInput.substring(0, 6).equals("/login")) {
                String[] inputLines = userInput.substring(7).split("-");
                if (inputLines.length == 3) {
                    userid = userManager.verifyUser(inputLines[1], inputLines[2]);
                    if (userid != -1) {
                        username = inputLines[1];
                        flag = false;
                    } else {
                        System.out.println("user not found");
                    }
                }
            } else if (userInput.substring(0, 9).equals("/register")) {
                String[] inputLines = userInput.substring(10).split("-");
                if (inputLines.length == 3) {
                    userid = userManager.addUser(inputLines[1], inputLines[2]);
                    if (userid != -1) {
                        csvInteract.usersWriter(users, "database/user.csv");
                        username = inputLines[1];
                        flag = false;
                    }
                }
            } else if (userInput.substring(0, 5).equals("/exit")) {

                flag = false;
                exit = true;

            } else {
                System.out.println("unknown command");
            }

        }
        if (!exit) {
            generalInterface();
        }
    }

    public void generalInterface() throws IOException {
        Scanner input = new Scanner(System.in);
        csvInterface csvInteract = new csvInterface();
        boolean flag = true;
        while (flag) {
            System.out.print(username + " ");
            String userInput = input.nextLine();
            if (userInput.length() == 0){
                System.out.print("");
            }
            else if (userInput.length() < 5) {
                System.out.println("unknown command");
            } else if (userInput.substring(0, 5).equals("/post")) {
                String[] inputLines = userInput.substring(6).split("-");
                postInterface(inputLines);
            } else if (userInput.substring(0, 8).equals("/friends")) {
                String[] inputLines = userInput.substring(9).split("-");
                friendsInterface(inputLines);
            } else if (userInput.substring(0, 5).equals("/exit")) {
                flag = false;
            } else if (userInput.substring(0, 8).equals("/comment")) {
                String[] inputLines = userInput.substring(9).split("-");
                commentInterface(inputLines);
            } else {
                System.out.println("unknown command");
            }
        }
    }

    public void postInterface(String[] inputLines) throws IOException {
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

    public void friendsInterface(String[] inputLines) throws IOException {
        csvInterface csvInteract = new csvInterface();
        Map<Integer, User> users = csvInteract.usersReader("database/user.csv");
        Map<Integer, ArrayList<Integer>> friends =
                csvInteract.friendsReader("database/friends.csv");
        if (inputLines[1].equals("add")) {
            int friendid = Integer.parseInt(inputLines[2]);
            if (users.containsKey(friendid)) {
                friends.get(userid).add(friendid);
                csvInteract.friendsWriter("database/friends.csv", friends);
            } else {
                System.out.println("user does not exist");
            }
        } else if (inputLines[1].equals("remove")) {
            int friendid = Integer.parseInt(inputLines[2]);
            if (users.containsKey(friendid)) {
                friends.get(userid).remove(friendid);
                csvInteract.friendsWriter("database/friends.csv", friends);
            } else {
                System.out.println("user does not exist");
            }
        } else {
            System.out.println("unknown command");
        }
    }

    public void commentInterface(String[] inputLines) throws IOException {
        csvInterface csvInteract = new csvInterface();
        Map<Integer, Post> posts = csvInteract.postsReader("database/post.csv");
        Map<Integer, Comment> comments = csvInteract.commentsReader("database/comments.csv");
        if (inputLines[1].equals("add")) {
            int postid = Integer.parseInt(inputLines[2]);
            if (posts.containsKey(postid)) {
                CommentManager commentManager = new CommentManager();
                commentManager.addComment(userid, inputLines[3]); //TODO: no postid in args?
                csvInteract.commentsWriter(comments, "database/comments.csv");
            } else {
                System.out.println("post does not exist");
            }
        } else if (inputLines[1].equals("delete")) {
            int commentid = Integer.parseInt(inputLines[2]);
            if (comments.containsKey(commentid)) {
                CommentManager commentManager = new CommentManager();
                commentManager.deleteComment(commentid);
                csvInteract.commentsWriter(comments, "database/comments.csv");
            } else {
                System.out.println("comment does not exist");
            }
        } else {
            System.out.println("unknown command");
        }
    }

    public static void main(String[] args) throws IOException {
        CLI test = new CLI();
        test.loginInterface();
    }

}