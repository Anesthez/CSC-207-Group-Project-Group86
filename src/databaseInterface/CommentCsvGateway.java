package databaseInterface;

import model.request.CommentRequestModel;
import model.response.CommentResponseModel;

import java.io.*;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public interface CommentCsvGateway {
    /**
     * This method is for reading comments.csv file.
     *
     * @param commentPath the path of the comments.csv file
     * @return a map of comments
     * @throws IOException if the file is not found
     */
    default Map<Integer, CommentRequestModel> commentsReader(String commentPath) throws IOException {
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

    /**
     * This method is for writing comments.csv file.
     *
     * @param commentPath the path of the comments.csv file
     * @param comments a map of comments
     */
    default void commentsWriter(Map<Integer, CommentResponseModel> comments, String commentPath) {

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
