package databaseInterface;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public interface BlockCsvGateway {
    /**
     * This method is for reading blocks.csv file.
     *
     * @param blocksPath the path of the blocks.csv file
     * @return a map of blocks
     * @throws IOException if the file is not found
     */
    default Map<Integer, ArrayList<Integer>> blocksReader(String blocksPath) throws IOException {

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
     * This method is for writing blocks.csv file.
     *
     * @param blocksPath the path of the blocks.csv file
     * @param blocks a map of blocks
     */
    default void blocksWriter(String blocksPath, Map<Integer, ArrayList<Integer>> blocks) {

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
}
