package Interface;/*
 * This class is for reading scv files.
 *
 * Author: Yijun(Kevin) Zhao
 * Modified by: yufei Chen
 *
 */


import Entity.Chat;
import Entity.Comment;
import Entity.Post;
import Entity.User;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class csvInterface {

    public Map<Integer, Post> postsReader(String postPath) throws IOException {
        File csvFile = new File(postPath);
        Map<String, Integer> headers = new LinkedHashMap<>();
        Map<Integer, Post> posts = new HashMap<>();
        headers.put("id", 0);
        headers.put("userid", 1);
        headers.put("time", 2);
        headers.put("content", 3);
        headers.put("num-liked", 4);
        headers.put("num-viewed", 5);
        headers.put("user-liked", 6);
        headers.put("list_comment_id", 7);
        headers.put("post_title", 8);
        BufferedReader reader = new BufferedReader(new FileReader(csvFile));
        reader.readLine(); // skip header

        String row;
        while ((row = reader.readLine()) != null) {
            String[] col = row.split(",");
            int id = Integer.parseInt(col[headers.get("id")]);
            int userid = Integer.parseInt(col[headers.get("userid")]);
            String time = String.valueOf(col[headers.get("time")]);
            String content = String.valueOf(col[headers.get("content")]);
            int num_liked = Integer.parseInt(col[headers.get("num-liked")]);
            int num_viewed = Integer.parseInt(col[headers.get("num-viewed")]);
            String list_comment_id = String.valueOf(col[headers.get("list_comment_id")]);
            String list_user_id = String.valueOf(col[headers.get("user-liked")]);
            String post_title = String.valueOf(col[headers.get("post_title")]);
            String[] userIds = list_user_id.substring(1, list_comment_id.length() - 1).split(", ");
            String[] commentIds = list_comment_id.substring(1, list_comment_id.length() - 1).split(", ");
            ArrayList<Integer> iList_comment_id = new ArrayList<>();
            ArrayList<Integer> iList_user_id = new ArrayList<>();

            for (String commentId:
                 commentIds) {
                iList_comment_id.add(Integer.parseInt(commentId));
            }
            for (String userId:
                    userIds) {
                iList_user_id.add(Integer.parseInt(userId));
            }
            Post post = new Post(post_title,
                    userid,
                    id,
                    content,
                    time,
                    num_liked,
                    num_viewed,
                    iList_user_id,
                    iList_comment_id);
            posts.put(id, post);
        }

        reader.close();
        return posts;
    }

    public Map<Integer, ArrayList<Integer>> postsLikedReader(String post_likedPath) throws IOException{
        Map<Integer, ArrayList<Integer>> postsLiked = new HashMap<>();
        File csvFile = new File(post_likedPath);
        Map<String, Integer> headers = new LinkedHashMap<>();
        headers.put("userid", 0);
        headers.put("list-postId", 1);
        BufferedReader reader = new BufferedReader(new FileReader(csvFile));
        reader.readLine(); // skip header

        String row;
        while ((row = reader.readLine()) != null) {
            String[] col = row.split(",");
            int userid = Integer.parseInt(col[headers.get("userid")]);
            String list_post_id = String.valueOf(col[headers.get("list-postId")]);
            String[] postIds = list_post_id.substring(1, list_post_id.length() - 1).split(", ");
            ArrayList<Integer> iList_post_id = new ArrayList<>();
            for (String postId:
                    postIds) {
                iList_post_id.add(Integer.parseInt(postId));
            }
            postsLiked.put(userid, iList_post_id);
        }
        reader.close();
        return postsLiked;
    }

    public Map<Integer, User> usersReader(String userPath) throws IOException {
        File csvFile = new File(userPath);
        Map<String, Integer> headers = new LinkedHashMap<>();
        Map<Integer, User> users = new HashMap<>();
        headers.put("id", 0);
        headers.put("user-type", 1);
        headers.put("password", 2);
        headers.put("name", 3);
        headers.put("time", 4);
        BufferedReader reader = new BufferedReader(new FileReader(csvFile));
        reader.readLine(); // skip header
        String row;
        while ((row = reader.readLine()) != null) {
            String[] col = row.split(",");
            int id = Integer.parseInt(col[headers.get("id")]);
            String userType = String.valueOf(col[headers.get("user-type")]);
            String password = String.valueOf(col[headers.get("password")]);
            String name = String.valueOf(col[headers.get("name")]);
            String time = String.valueOf(col[headers.get("time")]);


            User user = new User(id, userType, password, name, time);
            users.put(id, user);
        }

        reader.close();
        return users;
    }

    public Map<Integer, ArrayList<Integer>> friendsReader(String friendsPath) throws IOException {
        Map<Integer, ArrayList<Integer>> friends = new HashMap<>();
        File csvFile = new File(friendsPath);
        Map<String, Integer> headers = new LinkedHashMap<>();
        headers.put("userid", 0);
        headers.put("list-friendIds", 1);
        BufferedReader reader = new BufferedReader(new FileReader(csvFile));
        reader.readLine(); // skip header

        String row;
        while ((row = reader.readLine()) != null) {
            String[] col = row.split(",");
            int userid = Integer.parseInt(col[headers.get("userid")]);
            String list_friend_id = String.valueOf(col[headers.get("list-postId")]);
            String[] friendIds = list_friend_id.substring(1, list_friend_id.length() - 1).split(", ");
            ArrayList<Integer> iList_friend_id = new ArrayList<>();
            for (String friendId:
                    friendIds) {
                iList_friend_id.add(Integer.parseInt(friendId));
            }
            friends.put(userid, iList_friend_id);
        }
        reader.close();
        return friends;
    }

    public Map<Integer, Chat> chatsReader(String chatPath) throws IOException {
        Map<Integer, Chat> chats = new HashMap<>();
        File csvFile = new File(chatPath);
        Map<String, Integer> headers = new LinkedHashMap<>();
        headers.put("id", 0);
        headers.put("user_id1", 1);
        headers.put("user_id2", 2);
        headers.put("time", 3);
        headers.put("content", 4);

        BufferedReader reader = new BufferedReader(new FileReader(csvFile));
        reader.readLine(); // skip header
        String row;
        while ((row = reader.readLine()) != null) {
            String[] col = row.split(",");
            int id = Integer.parseInt(col[headers.get("id")]);
            int user_id1 = Integer.parseInt(col[headers.get("user_id1")]);
            int user_id2 = Integer.parseInt(col[headers.get("user_id2")]);
            String content = String.valueOf(col[headers.get("content")]);
            String time = String.valueOf(col[headers.get("time")]);


            Chat chat = new Chat(id, user_id1, user_id2, time, content);
            chats.put(id, chat);
        }
        reader.close();
        return chats;
    }

    public Map<Integer, Comment> commentsReader(String commentPath) throws IOException {
        Map<Integer, Comment> comments = new HashMap<>();
        File csvFile = new File(commentPath);
        Map<String, Integer> headers = new LinkedHashMap<>();
        headers.put("id", 0);
        headers.put("user_id", 1);
        headers.put("time", 2);
        headers.put("content", 3);

        BufferedReader reader = new BufferedReader(new FileReader(csvFile));
        reader.readLine(); // skip header
        String row;
        while ((row = reader.readLine()) != null) {
            String[] col = row.split(",");
            int id = Integer.parseInt(col[headers.get("id")]);
            int user_id = Integer.parseInt(col[headers.get("user_id")]);
            String content = String.valueOf(col[headers.get("content")]);
            String time = String.valueOf(col[headers.get("time")]);


            Comment comment = new Comment(user_id, id, time, content);
            comments.put(id, comment);
        }
        reader.close();
        return comments;
    }

    public void postsWriter(String postsPath, Map<Integer, Post> posts) {
        Map<String, Integer> headers = new LinkedHashMap<>();

        headers.put("id", 0);
        headers.put("userid", 1);
        headers.put("time", 2);
        headers.put("content", 3);
        headers.put("num-liked", 4);
        headers.put("num-viewed", 5);
        headers.put("user-liked", 6);
        headers.put("list_comment_id", 7);
        headers.put("post_title", 8);

        BufferedWriter writer;
        try {
            writer = new BufferedWriter(new FileWriter(postsPath));
            writer.write(String.join(",", headers.keySet()));
            writer.newLine();

            for (Post post : posts.values()) {
                String line = (
                        String.valueOf(post.getId())+","+
                        String.valueOf(post.getUserId())+","+
                        post.getTime()+","+
                        post.getContent()+","+
                        String.valueOf(post.getNumLikes())+","+
                        String.valueOf(post.getViews())+","+
                        post.getUserLiked().toString()+","+
                        post.getListComment().toString()+","+
                        post.getPostTitle());
                writer.write(line);
                writer.newLine();
            }

            writer.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void postsLikedWriter(String posts_likedPath, Map<Integer, ArrayList<Integer>> posts_liked) {
        Map<String, Integer> headers = new LinkedHashMap<>();
        headers.put("userid", 0);
        headers.put("list-postId", 1);
        BufferedWriter writer;
        try {
            writer = new BufferedWriter(new FileWriter(posts_likedPath));
            writer.write(String.join(",", headers.keySet()));
            writer.newLine();

            for (Integer postId: posts_liked.keySet()) {
                String line = (
                        String.valueOf(postId)+","+
                        posts_liked.get(postId)+","+
                                toString());
                writer.write(line);
                writer.newLine();
            }

            writer.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void usersWriter(Map<Integer, User> users, String userPath) {
        Map<String, Integer> headers = new LinkedHashMap<>();
        headers.put("id", 0);
        headers.put("user-type", 1);
        headers.put("password", 2);
        headers.put("name", 3);
        headers.put("time", 4);

        BufferedWriter writer;
        try {
            writer = new BufferedWriter(new FileWriter(userPath));
            writer.write(String.join(",", headers.keySet()));
            writer.newLine();

            for (User user : users.values()) {
                String line = (
                        String.valueOf(user.getId())+","+
                        user.getUserType()+","+
                        user.getUserPassword()+","+
                        user.getUserName()+","+
                        user.getTime());
                writer.write(line);
                writer.newLine();
            }

            writer.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void friendsWriter(String friendsPath, Map<Integer, ArrayList<Integer>> friends) {
        Map<String, Integer> headers = new LinkedHashMap<>();
        headers.put("userid", 0);
        headers.put("list-friendIds", 1);
        BufferedWriter writer;
        try {
            writer = new BufferedWriter(new FileWriter(friendsPath));
            writer.write(String.join(",", headers.keySet()));
            writer.newLine();

            for (Integer userId: friends.keySet()) {
                String line = (
                        String.valueOf(userId)+","+
                        friends.get(userId).toString());
                writer.write(line);
                writer.newLine();
            }

            writer.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void chatsWriter(Map<Integer, Chat> chats, String chatPath) {
        Map<String, Integer> headers = new LinkedHashMap<>();
        headers.put("id", 0);
        headers.put("user_id1", 1);
        headers.put("user_id2", 2);
        headers.put("time", 3);
        headers.put("content", 4);
        BufferedWriter writer;
        try {
            writer = new BufferedWriter(new FileWriter(chatPath));
            writer.write(String.join(",", headers.keySet()));
            writer.newLine();

            for (Chat chat : chats.values()) {
                String line = (
                        String.valueOf(chat.getId())+","+
                        String.valueOf(chat.getSender_id())+","+
                        String.valueOf(chat.getReceiver_id())+","+
                        chat.getTime()+","+
                        chat.getContent());
                writer.write(line);
                writer.newLine();
            }

            writer.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void commentsWriter(Map<Integer, Comment> comments, String commentPath) {
        Map<String, Integer> headers = new LinkedHashMap<>();
        headers.put("id", 0);
        headers.put("user_id", 1);
        headers.put("time", 2);
        headers.put("content", 3);
        BufferedWriter writer;
        try {
            writer = new BufferedWriter(new FileWriter(commentPath));
            writer.write(String.join(",", headers.keySet()));
            writer.newLine();

            for (Comment comment : comments.values()) {
                String line = (
                        String.valueOf(comment.getId())+","+
                        comment.getUserId()+","+
                        comment.getTime()+","+
                        comment.getContent());
                writer.write(line);
                writer.newLine();
            }

            writer.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
