package controller;

import useCases.TopicUseCases;
import databaseInterface.csvInterface;
import model.request.TopicRequestModel;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

public class TopicController {
    public ArrayList<TopicRequestModel> getHottestTopics() throws IOException {
        csvInterface csvInterface = new csvInterface();
        Map<Integer, TopicRequestModel> topics = csvInterface.topicsReader("database/topic.csv");
        TopicUseCases topicManager = new TopicUseCases();
        ArrayList<TopicRequestModel> topicRequestModels = new ArrayList<>(topics.values());
        return topicManager.getTopTopics(topicRequestModels);
    }
}