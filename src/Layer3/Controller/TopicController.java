package Layer3.Controller;

import Layer2.UseCases.TopicUseCases;
import Layer4.Interface.csvInterface;
import Model.Request.TopicRequestModel;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

public class TopicController {
    public ArrayList<TopicRequestModel> getHottestTopics() throws IOException {
        csvInterface csvInterface = new csvInterface();
        Map<Integer, TopicRequestModel> topics = csvInterface.topicsReader("database/topics.csv");
        TopicUseCases topicManager = new TopicUseCases();
        ArrayList<TopicRequestModel> topicRequestModels = new ArrayList<TopicRequestModel>();
        for (TopicRequestModel topic : topics.values()) {
            topicRequestModels.add(topic);
        }
        return topicManager.getTopTopics(topicRequestModels);
    }
}
