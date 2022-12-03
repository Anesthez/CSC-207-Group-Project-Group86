package useCases;

import entity.Post;
import entity.Topic;
import model.request.PostRequestModel;
import model.request.TopicRequestModel;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class GetTopTopicsUseCase {
    /**
     * <p>
     * The getTopTopics method is a method that is used to get the top topics.
     * </p>
     *
     * @param topic the topic user chose
     * @return the top topics
     */
    public ArrayList<TopicRequestModel> getTopTopics(ArrayList<TopicRequestModel> topic) throws IOException {

        ArrayList<Topic> topTopics = new ArrayList<>();
        ArrayList<Topic> temp = new ArrayList<>();
        for (TopicRequestModel t : topic) {
            Map<Integer, Post> posts = new HashMap<>();
            Map<Integer, PostRequestModel> postR = (Map<Integer, PostRequestModel>) t.get().get(3);
            for (Integer p : postR.keySet()) {
                posts.put(p, new Post((String) postR.get(p).get().get(0),
                        (Integer) postR.get(p).get().get(1),
                        (Integer) postR.get(p).get().get(2),
                        (String) postR.get(p).get().get(3),
                        (String) postR.get(p).get().get(4),
                        (Integer) postR.get(p).get().get(5),
                        (Integer) postR.get(p).get().get(6),
                        (ArrayList<Integer>) postR.get(p).get().get(7),
                        (ArrayList<Integer>) postR.get(p).get().get(8),
                        (String) postR.get(p).get().get(9)));
            }
            temp.add(new Topic(t.get().get(0).toString(), (String) t.get().get(1), posts));
        }

        if (temp.size() == 0) {
            temp.add(new Topic("0", "topic", new HashMap<>()));
            topTopics.add(temp.get(0));
            topTopics.add(temp.get(0));
            topTopics.add(temp.get(0));
        }
        if (temp.size() == 1) {
            topTopics.add(temp.get(0));
            topTopics.add(temp.get(0));
            topTopics.add(temp.get(0));
        }
        if (temp.size() == 2) {
            topTopics.add(temp.get(0));
            topTopics.add(temp.get(0));
            topTopics.add(temp.get(1));
        }
        if (temp.size() == 3) {
            topTopics.add(temp.get(0));
            topTopics.add(temp.get(1));
            topTopics.add(temp.get(2));
        }
        if (temp.size() > 3) {
            Topic first = new Topic();
            Topic second = new Topic();
            Topic third = new Topic();
            int max1 = 0;
            for (Topic t : temp) {
                if (t.getPosts().size() > max1) {
                    max1 = t.getPosts().size();
                }
            }
            for (Topic t : temp) {
                if (t.getPosts().size() == max1) {
                    first = t;
                }
            }


            int max2 = 0;
            for (Topic t : temp) {
                if (t.getPosts().size() > max2 && t.getPosts().size() <= max1) {
                    max2 = t.getPosts().size();
                }
            }
            for (Topic t : temp) {
                if (t.getPosts().size() == max2) {
                    second = t;
                }
            }

            int max3 = 0;
            for (Topic t : temp) {
                if (t.getPosts().size() > max3 && t.getPosts().size() <= max2) {
                    max3 = t.getPosts().size();
                }
            }
            for (Topic t : temp) {
                if (t.getPosts().size() == max3) {
                    third = t;
                }
            }
            topTopics.add(first);
            topTopics.add(second);
            topTopics.add(third);
        }

        ArrayList<TopicRequestModel> hottestTopics = new ArrayList<>();
        for (Topic t : topTopics) {
            Map<Integer, PostRequestModel> posts = new HashMap<>();
            for (Post p : t.getPosts().values()) {
                posts.put(p.getId(), new PostRequestModel(p.getPostTitle(), p.getUserId(), p.getId(), p.getContent(),
                        p.getTimes(), p.getViews(), p.getNumLikes(), p.getUserLiked(), p.getListComment(), p.getTopic()));
            }
            hottestTopics.add(new TopicRequestModel(t.getName(), t.getID(), posts));
        }
        return hottestTopics;
    }
}