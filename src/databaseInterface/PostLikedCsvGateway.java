package databaseInterface;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public interface PostLikedCsvGateway {
    /**
     * This method is for reading post_liked.csv file.
     *
     * @param post_likedPath the path of the post_liked.csv file
     * @return a map of liked posts
     */

    default Map<Integer, ArrayList<Integer>> postsLikedReader(String post_likedPath) throws IOException {

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
     *
     * @param posts_likedPath path for the posts liked path
     * @param posts_liked contents we want to write
     */
    default void postsLikedWriter(String posts_likedPath, Map<Integer, ArrayList<Integer>> posts_liked) {

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


}
