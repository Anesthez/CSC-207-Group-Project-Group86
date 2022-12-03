package useCases;

import entity.Topic;

import java.util.ArrayList;

public class GetMaxTopicUseCase {
    /**
     * <p>
     *     The getMaxTopic method is a method that is used to get the maximum topic.
     * </p>
     * @param topic the topics to be compared
     * @return the maximum topic
     */
    public Integer getMaxTopic (ArrayList<Topic> topic)
    {
        Integer maxPop = 0;
        for (Topic t: topic)
        {
            if (t.getPopularity() > maxPop)
            {
                maxPop = t.getPopularity();
            }
        }

        return maxPop;
    }
}
