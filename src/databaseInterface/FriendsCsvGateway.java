package databaseInterface;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public interface FriendsCsvGateway {
    /**
     * This method is for reading friends.csv file.
     *
     * @param friendsPath the path of the friends.csv file
     * @return a map of friends
     * @throws IOException if the file is not found
     */
    default Map<Integer, ArrayList<Integer>> friendsReader(String friendsPath) throws IOException {

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
     * This method is for writing friends.csv file.
     *
     * @param friendsPath the path of the friends.csv file
     * @param friends a map of friends
     */
    default void friendsWriter(String friendsPath, Map<Integer, ArrayList<Integer>> friends) {

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
}
