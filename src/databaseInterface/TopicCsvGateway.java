package databaseInterface;

import model.request.PostRequestModel;
import model.request.TopicRequestModel;
import model.request.UserRequestModel;
import model.response.TopicResponseModel;

import java.io.*;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public interface TopicCsvGateway extends PostCsvGateway{
    /**
     * This method is for reading topics.csv file.
     *
     * @param topicPath the path of the topics.csv file
     * @return a map of topics
     * @throws IOException if the file is not found
     */
    default Map<Integer, TopicRequestModel> topicsReader(String topicPath) throws IOException {
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
     * This method is for writing topics.csv file.
     *
     * @param topicPath the path of the topics.csv file
     * @param topics a map of topics
     */
    default void topicWriter(Map<Integer, TopicResponseModel> topics, String topicPath){


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
}
