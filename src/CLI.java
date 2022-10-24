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
            String[] userInputs = userInput.split("-");
            switch (userInputs[0]) {
                case "/login ":
                    if (userInputs.length == 3) {
                        userid = userManager.verifyUser(userInputs[1], userInputs[2]);
                        if (userid != -1) {
                            username = userInputs[1];
                            flag = false;
                        } else {
                            System.out.println("user not found, please register first!");
                        }
                    }
                    break;
                case "/register ":
                    if (userInputs.length == 3) {
                        userid = userManager.addUser(userInputs[1], userInputs[2]);
                        if (userid != -1) {
                            csvInteract.usersWriter(users, "database/user.csv");
                            username = userInputs[1];
                            flag = false;
                        }
                    }
                    break;
                case "/exit ":

                    flag = false;
                    exit = true;

                    break;
                default:
                    System.out.println("unknown command");
                    break;
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
            String[] userInputs = userInput.split("-");
            if (!userInput.equals("")) {
                switch (userInputs[0]) {
                    case "/post ":
                        postInterface(userInputs);
                        break;
                    case "/friends":
                        friendsInterface(userInputs);
                        break;
                    case "/exit":
                        flag = false;
                        break;
                    case "/comment":

                        commentInterface(userInputs);
                        break;
                    default:
                        System.out.println("unknown command");
                        break;
                }
            } else {
                System.out.print("");
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
            for (int i = 1; i < 4; i++) {
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