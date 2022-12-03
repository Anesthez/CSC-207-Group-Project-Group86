package databaseInterface;

import model.request.PostRequestModel;
import model.response.PostResponseModel;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public interface PostCsvGateway {
    /**
     * This method is for reading posts.csv file.
     *
     * @param postPath the path of the posts.csv file
     * @return a map of posts
     * @throws IOException if the file is not found
     */

    default Map<Integer, PostRequestModel> postsReader(String postPath) throws IOException {
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
     * This method is for writing post.csv file.
     *
     * @param postsPath the path of the post.csv file
     * @param posts a map of posts
     */

    default void postsWriter(String postsPath, Map<Integer, PostResponseModel> posts) {


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
}
