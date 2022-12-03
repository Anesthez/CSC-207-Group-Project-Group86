package databaseInterface;

import model.request.ChatRequestModel;
import model.response.ChatResponseModel;

import java.io.*;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public interface ChatCsvGateway {

    /**
     * This method is for reading chats.csv file.
     *
     * @param chatPath the path of the chats.csv file
     * @return a map of chats
     * @throws IOException if the file is not found
     */
    default Map<Integer, ChatRequestModel> chatsReader(String chatPath) throws IOException {
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
     * This method is for writing chats.csv file.
     *
     * @param chatPath the path of the chats.csv file
     * @param chats a map of chats
     */
    default void chatsWriter(Map<Integer, ChatResponseModel> chats, String chatPath) {



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
}
