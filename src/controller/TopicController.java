package controller;

import useCases.UseCaseFacade.TopicUseCasesFacade;
import databaseInterface.CsvInterface;
import model.request.TopicRequestModel;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

public class TopicController {
    public ArrayList<TopicRequestModel> getHottestTopics() throws IOException {
        CsvInterface csvInterface = new CsvInterface();
        Map<Integer, TopicRequestModel> topics = csvInterface.topicsReader("database/topic.csv");
        TopicUseCasesFacade topicManager = new TopicUseCasesFacade();
        ArrayList<TopicRequestModel> topicRequestModels = new ArrayList<>(topics.values());
        return topicManager.getTopTopics(topicRequestModels);
    }
}
