package databaseInterface;

import model.request.*;
import model.response.*;

import java.io.*;
import java.util.*;

/**
 * <p>The csvInterface class is a class that will be used to read and write csv files.</p>
 * <p>The class will be used to read and write csv files for the user, post, comment, and chat objects.</p>
 *
 * @Author: Yijun(Kevin) Zhao
 * @Modifiedby: Yufei Chen, Chen Jiang
 */

public class csvInterface {

    /**
     * This method is for reading post.csv file.
     *
     * @param postPath the path of the post.csv file
     * @return a map of posts
     */
    public Map<Integer, PostRequestModel> postsReader(String postPath) throws IOException {
        

        File csvFile = new File(postPath);
        Map<String, Integer> headers = new LinkedHashMap<>();
        Map<Integer, PostRequestModel> posts = new HashMap<>();
        createHeader(headers);
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
            String topic = String.valueOf(col[headers.get("topic")]);
            String[] userIds = list_user_id.split(" ");
            String[] commentIds = list_comment_id.split(" ");
            ArrayList<Integer> iList_comment_id = new ArrayList<>();
            ArrayList<Integer> iList_user_id = new ArrayList<>();
            if (!list_user_id.equals("")) {
                for (String userId :
                        userIds) {
                    iList_comment_id.add(Integer.parseInt(userId));
                }
            }
            if (!list_comment_id.equals("")) {
                for (String commentId :
                        commentIds) {
                    iList_user_id.add(Integer.parseInt(commentId));
                }
            }


            PostRequestModel post = new PostRequestModel(post_title,
                    userid,
                    id,
                    content,
                    time,
                    num_liked,
                    num_viewed,
                    iList_user_id,
                    iList_comment_id,

                    topic);
            posts.put(id, post);
        }

        reader.close();
        return posts;
    }

    private void createHeader(Map<String, Integer> headers) {
        headers.put("post_title", 0);
        headers.put("userid", 1);
        headers.put("id", 2);
        headers.put("content", 3);
        headers.put("time", 4);
        headers.put("num-viewed", 5);
        headers.put("num-liked", 6);
        headers.put("user-liked", 7);
        headers.put("list_comment_id", 8);
        headers.put("topic", 9);
    }

    /**
     * This method is for reading post_liked.csv file.
     *
     * @param post_likedPath the path of the post_liked.csv file
     * @return a map of liked posts
     */
    
    public Map<Integer, ArrayList<Integer>> postsLikedReader(String post_likedPath) throws IOException{
        
        Map<Integer, ArrayList<Integer>> postsLiked = new HashMap<>();
        File csvFile = new File(post_likedPath);
        Map<String, Integer> headers = new LinkedHashMap<>();
        headers.put("list-userId", 0);
        headers.put("postId", 1);
        BufferedReader reader = new BufferedReader(new FileReader(csvFile));
        reader.readLine(); // skip header

        String row;
        while ((row = reader.readLine()) != null) {
            String[] col = row.split(",");
            int userid = Integer.parseInt(col[headers.get("postId")]);
            String list_post_id = String.valueOf(col[headers.get("list-userId")]);
            toLists(postsLiked, userid, list_post_id);
        }
        reader.close();
        return postsLiked;
    }

    /**
     * This method is for reading users.csv file.
     *
     * @param userPath the path of the users.csv file
     * @return a map of users
     * @throws IOException if the file is not found
     */
    public Map<Integer, UserRequestModel> usersReader(String userPath) throws IOException {
        
        File csvFile = new File(userPath);
        Map<String, Integer> headers = new LinkedHashMap<>();
        Map<Integer, UserRequestModel> users = new HashMap<>();
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


            UserRequestModel user = new UserRequestModel(id, userType, name, password, time);
            users.put(id, user);
        }

        reader.close();
        return users;
    }
    /**
     * This method is for reading friends.csv file.
     *
     * @param friendsPath the path of the friends.csv file
     * @return a map of friends
     * @throws IOException if the file is not found
     */
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
            String list_friend_id = String.valueOf(col[headers.get("list-friendIds")]);
            toLists(friends, userid, list_friend_id);
        }
        reader.close();
        return friends;
    }

    private void toLists(Map<Integer, ArrayList<Integer>> friends, int userid, String list_friend_id) {
        String[] friendIds = list_friend_id.split(" ");
        ArrayList<Integer> iList_friend_id = new ArrayList<>();
        if (!list_friend_id.equals("")) {
            for (String friendId :
                    friendIds) {
                iList_friend_id.add(Integer.parseInt(friendId));
            }
        }
        friends.put(userid, iList_friend_id);
    }

    /**
     * This method is for reading blocks.csv file.
     *
     * @param blocksPath the path of the blocks.csv file
     * @return a map of blocks
     * @throws IOException if the file is not found
     */
    public Map<Integer, ArrayList<Integer>> blocksReader(String blocksPath) throws IOException {
        
        Map<Integer, ArrayList<Integer>> blocks = new HashMap<>();
        File csvFile = new File(blocksPath);
        Map<String, Integer> headers = new LinkedHashMap<>();
        headers.put("userid", 0);
        headers.put("list-blockedIds", 1);
        BufferedReader reader = new BufferedReader(new FileReader(csvFile));
        reader.readLine(); // skip header

        String row;
        while ((row = reader.readLine()) != null) {
            String[] col = row.split(",");
            int userid = Integer.parseInt(col[headers.get("userid")]);
            String list_blocked_id = String.valueOf(col[headers.get("list-blockedIds")]);
            toLists(blocks, userid, list_blocked_id);
        }
        reader.close();
        return blocks;
    }

    /**
     * This method is for reading chats.csv file.
     *
     * @param chatPath the path of the chats.csv file
     * @return a map of chats
     * @throws IOException if the file is not found
     */
    public Map<Integer, ChatRequestModel> chatsReader(String chatPath) throws IOException {
        Map<Integer, ChatRequestModel> chats = new HashMap<>();
        

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

            ChatRequestModel chat = new ChatRequestModel(id, user_id1, user_id2, content, time);
            chats.put(id, chat);
        }
        reader.close();
        return chats;
    }

    /**
     * This method is for reading comments.csv file.
     *
     * @param commentPath the path of the comments.csv file
     * @return a map of comments
     * @throws IOException if the file is not found
     */
    public Map<Integer, CommentRequestModel> commentsReader(String commentPath) throws IOException {
        Map<Integer, CommentRequestModel> comments = new HashMap<>();
        

        File csvFile = new File(commentPath);
        Map<String, Integer> headers = new LinkedHashMap<>();
        headers.put("id", 0);
        headers.put("user_id", 1);
        headers.put("time", 2);
        headers.put("content", 3);
        headers.put("post_id", 4);

        BufferedReader reader = new BufferedReader(new FileReader(csvFile));
        reader.readLine(); // skip header
        String row;
        while ((row = reader.readLine()) != null) {
            String[] col = row.split(",");
            int id = Integer.parseInt(col[headers.get("id")]);
            int user_id = Integer.parseInt(col[headers.get("user_id")]);
            String content = String.valueOf(col[headers.get("content")]);
            String time = String.valueOf(col[headers.get("time")]);
            int post_id = Integer.parseInt(col[headers.get("post_id")]);

            CommentRequestModel comment = new CommentRequestModel(user_id, id, content, time, post_id);
            comments.put(id, comment);
        }
        reader.close();
        return comments;
    }

    // Author: Chen jiang
    /**
     * This method is for reading topics.csv file.
     *
     * @param topicPath the path of the topics.csv file
     * @return a map of topics
     * @throws IOException if the file is not found
     */
    public Map<Integer, TopicRequestModel> topicsReader(String topicPath) throws IOException {
        Map<Integer, TopicRequestModel> topics = new HashMap<>();
        
        File csvFile = new File(topicPath);
        Map<String, Integer> headers = new LinkedHashMap<>();
        headers.put("id", 0);
        headers.put("name",1);
        headers.put("posts", 2);
        headers.put("users", 3);
        BufferedReader reader = new BufferedReader(new FileReader(csvFile));
        reader.readLine();
        String row;
        while((row = reader.readLine()) != null)
        {
            String[] col = row.split(",");
            String id = String.valueOf(col[headers.get("id")]);
            String name = String.valueOf(col[headers.get("name")]);
            Map<Integer, PostRequestModel> postsMap = postsReader("database/post.csv");
            Set<Integer> postsMapKeys = postsMap.keySet();
            Map<Integer, PostRequestModel> postList = new HashMap<>();
            for (Integer p : postsMapKeys)
            {
                if (postsMap.get(p).get().get(9).equals(name))
                {
                    postList.put((Integer)postsMap.get(p).get().get(2), postsMap.get(p));
                }
            }

            TopicRequestModel topic = new TopicRequestModel(id, name, postList);
            topics.put(topics.size()+1, topic);
        }

        return topics;
    }

    /**
     * This method is for writing post.csv file.
     *
     * @param postsPath the path of the post.csv file
     * @param posts a map of posts
     */

    public void postsWriter(String postsPath, Map<Integer, PostResponseModel> posts) {
        

        Map<String, Integer> headers = new LinkedHashMap<>();
        createHeader(headers);

        BufferedWriter writer;
        try {
            writer = new BufferedWriter(new FileWriter(postsPath));
            writer.write(String.join(",", headers.keySet()));
            writer.newLine();
            for (PostResponseModel post : posts.values()) {
                StringBuilder userLiked = new StringBuilder();
                StringBuilder listComment = new StringBuilder();
                ArrayList<Integer> userlikes = (ArrayList<Integer>)post.get().get(7);
                ArrayList<Integer> listComments = (ArrayList<Integer>)post.get().get(8);
                if(userlikes.size() > 0){
                    userLiked = new StringBuilder(String.valueOf(userlikes.get(0)));
                    for (int i = 1; i < userlikes.size(); i++) {
                        userLiked.append(" ").append(userlikes.get(i));
                    }
                }
                if(listComments.size() > 0) {
                    listComment = new StringBuilder(String.valueOf(listComments.get(0)));
                    for (int i = 1; i < listComments.size(); i++) {
                        listComment.append(" ").append(listComments.get(i));
                    }
                }

                String line = (
                        post.get().get(0) +","+
                        post.get().get(1) +","+
                        post.get().get(2) +","+
                        post.get().get(3) +","+
                        post.get().get(4) +","+
                        post.get().get(5) +","+
                        post.get().get(6) +","+
                        userLiked+","+
                        listComment+","+
                        post.get().get(9));
                writer.write(line);
                writer.newLine();
            }

            writer.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    /**
     * This method is for writing post_liked.csv file.
     *
     * @param posts_likedPath the path of the post_liked.csv file
     * @param posts_liked a map of posts_liked
     */
    public void postsLikedWriter(String posts_likedPath, Map<Integer, ArrayList<Integer>> posts_liked) {
        
        Map<String, Integer> headers = new LinkedHashMap<>();
        headers.put("list-userId", 0);
        headers.put("postId", 1);

        BufferedWriter writer;
        try {
            writer = new BufferedWriter(new FileWriter(posts_likedPath));
            writer.write(String.join(",", headers.keySet()));
            writer.newLine();

            for (Integer postId: posts_liked.keySet()) {
                StringBuilder listId = new StringBuilder();
                if (posts_liked.get(postId).size() >0) {
                    listId = new StringBuilder(String.valueOf(posts_liked.get(postId).get(0)));
                    for (int i = 1; i < posts_liked.get(postId).size(); i++) {
                        listId.append(" ").append(posts_liked.get(postId).get(i));
                    }
                }
                String line = (
                        listId
                        +","+ postId);
                writer.write(line);
                writer.newLine();
            }

            writer.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    /**
     * This method is for writing users.csv file.
     *
     * @param userPath the path of the users.csv file
     * @param users a map of users
     */

    public void usersWriter(Map<Integer, UserResponseModel> users, String userPath) {
        

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

            for (UserResponseModel user : users.values()) {
                String line = (
                        user.get().get(0)+","+
                        user.get().get(1)+","+
                        user.get().get(3)+","+
                        user.get().get(2)+","+
                        user.get().get(4));

                writer.write(line);
                writer.newLine();
            }

            writer.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    /**
     * This method is for writing friends.csv file.
     *
     * @param friendsPath the path of the friends.csv file
     * @param friends a map of friends
     */
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
                StringBuilder listId = new StringBuilder();
                if (friends.get(userId).size() > 0) {
                    listId = new StringBuilder(String.valueOf(friends.get(userId).get(0)));
                    for (int i = 1; i < friends.get(userId).size(); i++) {
                        listId.append(" ").append(friends.get(userId).get(i));
                    }
                }
                String line = (
                        userId +","+
                        listId);
                writer.write(line);
                writer.newLine();
            }

            writer.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    /**
     * This method is for writing blocks.csv file.
     *
     * @param blocksPath the path of the blocks.csv file
     * @param blocks a map of blocks
     */
    public void blocksWriter(String blocksPath, Map<Integer, ArrayList<Integer>> blocks) {
        
        Map<String, Integer> headers = new LinkedHashMap<>();
        headers.put("userid", 0);
        headers.put("list-blockedIds", 1);
        BufferedWriter writer;
        try {
            writer = new BufferedWriter(new FileWriter(blocksPath));
            writer.write(String.join(",", headers.keySet()));
            writer.newLine();

            for (Integer userId: blocks.keySet()) {
                StringBuilder listId = new StringBuilder();
                if (blocks.get(userId).size() > 0) {
                    listId = new StringBuilder(String.valueOf(blocks.get(userId).get(0)));
                    for (int i = 1; i < blocks.get(userId).size(); i++) {
                        listId.append(" ").append(blocks.get(userId).get(i));
                    }
                }
                String line = (
                        userId +","+
                                listId);
                writer.write(line);
                writer.newLine();
            }

            writer.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //Author: Chen Jiang
    /**
     * This method is for writing topics.csv file.
     *
     * @param topicPath the path of the topics.csv file
     * @param topics a map of topics
     */
    public void topicWriter(Map<Integer, TopicResponseModel> topics, String topicPath){
        

        Map<String, Integer> headers = new LinkedHashMap<>();
        headers.put("id", 0);
        headers.put("name",1);
        headers.put("posts",2);
        headers.put("users",3);
        BufferedWriter writer;
        try {
            writer = new BufferedWriter(new FileWriter(topicPath));
            writer.write(String.join(",", headers.keySet()));
            writer.newLine();
            StringBuilder postLists = new StringBuilder();
            StringBuilder userLists = new StringBuilder();
            for (TopicResponseModel topic : topics.values()) {

                HashMap<Integer, PostRequestModel> posts = (HashMap<Integer, PostRequestModel>) topic.get().get(3);
                if (posts.size()>0)
                {
                    Set<Integer> keys = posts.keySet();
                    for (Integer k : keys)
                    {
                        postLists.append(";").append(k).append(".").append(posts.get(k).get().get(3));
                    }
                }
                HashMap<Integer, UserRequestModel> users = (HashMap<Integer, UserRequestModel>) topic.get().get(2);

                if (users.size() >0)
                {
                    Set<Integer> keys = users.keySet();
                    for (Integer k : keys)
                    {
                        userLists.append(" ").append(k).append(".").append(users.get(k).get().get(2));
                    }
                }


                String line = (
                        topic.get().get(0)+","+
                        topic.get().get(1)+","+
                                postLists+","+
                                userLists);
                writer.write(line);
                writer.newLine();
            }

            writer.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * This method is for writing chats.csv file.
     *
     * @param chatPath the path of the chats.csv file
     * @param chats a map of chats
     */
    public void chatsWriter(Map<Integer, ChatResponseModel> chats, String chatPath) {

        

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


            for (ChatResponseModel chat : chats.values()) {
                String line = (
                        chat.get().get(0)+","+
                        chat.get().get(1)+","+
                        chat.get().get(2)+","+
                        chat.get().get(4)+","+
                        chat.get().get(3));

                writer.newLine();
                writer.write(line);

            }

            writer.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * This method is for writing comments.csv file.
     *
     * @param commentPath the path of the comments.csv file
     * @param comments a map of comments
     */
    public void commentsWriter(Map<Integer, CommentResponseModel> comments, String commentPath) {
        
        Map<String, Integer> headers = new LinkedHashMap<>();
        headers.put("id", 0);
        headers.put("user_id", 1);
        headers.put("time", 2);
        headers.put("content", 3);
        headers.put("post_id", 4);
        BufferedWriter writer;
        try {
            writer = new BufferedWriter(new FileWriter(commentPath));
            writer.write(String.join(",", headers.keySet()));
            writer.newLine();

            for (CommentResponseModel comment : comments.values()) {
                String line = (
                        comment.get().get(1)+","+
                        comment.get().get(0)+","+
                        comment.get().get(3)+","+
                        comment.get().get(2)+","+
                        comment.get().get(4));
                writer.write(line);
                writer.newLine();
            }

            writer.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}