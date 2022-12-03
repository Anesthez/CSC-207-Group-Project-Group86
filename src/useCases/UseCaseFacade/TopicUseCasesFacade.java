package useCases.UseCaseFacade;

import entity.Post;
import entity.Topic;
import model.request.PostRequestModel;
import model.request.TopicRequestModel;
//import javafx.geometry.Pos;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
/**
 * <p>
 *     The TopicUserCases class is a class that is used to control Topic and implement some functions with regards to
 *     Topics.
 * </p>
 * <p>
 *     The TopicUserCases contains several methods: addPostsToTopic, getTopPosts, getTopTopics, and a private method
 *     get MaxTopics.
 * </p>
 * @implNote the getMapTopics method is not to be used by the user, thus set as private.
 * @Author: Chen Jiang
 * @Modifiedby: Chen Jiang
 */
public class TopicUseCasesFacade {

    /**
     * <p>
     *     The addPostsToTopic method is a method that is used to add posts to a topic.
     * </p>
     * @param topic the topic that the posts are added to
     * @param post the post to be added to the topic
     */
    public void addPostsToTopic(Topic topic, Post post)
    {
        /*
        Add Posts associated to the Topic in this Topic.
         */
        Map<Integer, Post> update = topic.getPosts();
        update.put(update.size(), post);
        topic.setPosts(update);

    }

    /**
     * <p>
     *     The getTopPosts method is a method that is used to get the top posts in a topic.
     * </p>
     * @param topic
     * @return
     */
    public ArrayList<Post> getTopPosts(Topic topic)
    {
        /*
        Return five Posts with the highest popularity.
         */

        HashMap<Post, Integer> postPopularity = topic.getPostPopularity();

        Post first;
        Post second;
        Post third;
        Post fourth;
        Post fifth;

        /*
        Get the most popular Post.
         */
        Integer max = 0;
        Post maxp = null;
        for (Post p : postPopularity.keySet())
        {
            if (p.getPopularity() > max)
            {
                max = p.getPopularity();
                maxp = p;
            }
        }
        first = maxp;
        postPopularity.remove(maxp);

        /*
        Get the second most popular Post.
         */
        Integer max2 = 0;
        Post maxp2 = null;
        for (Post p : postPopularity.keySet())
        {
            if (p.getPopularity() > max)
            {
                max2 = p.getPopularity();
                maxp2 = p;
            }
        }
        second = maxp2;
        postPopularity.remove(maxp2);

        /*
        Get the third most popular Post.
         */
        Integer max3 = 0;
        Post maxp3 = null;
        for (Post p : postPopularity.keySet())
        {
            if (p.getPopularity() > max)
            {
                max3 = p.getPopularity();
                maxp3 = p;
            }
        }
        third = maxp3;
        postPopularity.remove(maxp3);

        /*
        Get the fourth most popular Post.
         */
        Integer max4 = 0;
        Post maxp4 = null;
        for (Post p : postPopularity.keySet())
        {
            if (p.getPopularity() > max)
            {
                max4 = p.getPopularity();
                maxp4 = p;
            }
        }
        fourth = maxp4;
        postPopularity.remove(maxp4);

        /*
        Get the fifth most popular Post.
         */
        Integer max5 = 0;
        Post maxp5 = null;
        for (Post p : postPopularity.keySet())
        {
            if (p.getPopularity() > max)
            {
                max5 = p.getPopularity();
                maxp5 = p;
            }
        }
        fifth = maxp5;
        postPopularity.remove(maxp5);

        ArrayList<Post> posts = new ArrayList<>();
        posts.add(first);
        posts.add(second);
        posts.add(third);
        posts.add(fourth);
        posts.add(fifth);

        return posts;
    }

    /**
     * <p>
     *     The getTopTopics method is a method that is used to get the top topics.
     * </p>
     * @param topic
     * @return
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

        if (temp.size() == 0)
        {
            temp.add(new Topic("0", "topic", new HashMap<>()));
            topTopics.add(temp.get(0));
            topTopics.add(temp.get(0));
            topTopics.add(temp.get(0));
        }
        if (temp.size() ==1)
        {
            topTopics.add(temp.get(0));
            topTopics.add(temp.get(0));
            topTopics.add(temp.get(0));
        }
        if (temp.size() == 2)
        {
            topTopics.add(temp.get(0));
            topTopics.add(temp.get(0));
            topTopics.add(temp.get(1));
        }
        if (temp.size() == 3)
        {
            topTopics.add(temp.get(0));
            topTopics.add(temp.get(1));
            topTopics.add(temp.get(2));
        }
        if (temp.size() > 3)
        {
            Topic first = new Topic();
            Topic second = new Topic();
            Topic third = new Topic();
            int max1 = 0;
            for (Topic t : temp)
            {
                if (t.getPosts().size() > max1)
                {
                    max1 = t.getPosts().size();
                }
            }
            for (Topic t : temp)
            {
                if (t.getPosts().size() == max1)
                {
                    first = t;
                }
            }


            int max2 = 0;
            for (Topic t : temp)
            {
                if (t.getPosts().size() > max2 && t.getPosts().size() <= max1)
                {
                    max2 = t.getPosts().size();
                }
            }
            for (Topic t : temp)
            {
                if (t.getPosts().size() == max2)
                {
                    second = t;
                }
            }

            int max3 = 0;
            for (Topic t : temp)
            {
                if (t.getPosts().size() > max3 && t.getPosts().size() <= max2)
                {
                    max3 = t.getPosts().size();
                }
            }
            for (Topic t : temp)
            {
                if (t.getPosts().size() == max3)
                {
                    third = t;
                }
            }
            topTopics.add(first);
            topTopics.add(second);
            topTopics.add(third);
        }

        ArrayList<TopicRequestModel> hottestTopics = new ArrayList<>();
        for (Topic t: topTopics)
        {
            Map<Integer, PostRequestModel> posts = new HashMap<>();
            for (Post p: t.getPosts().values())
            {
                posts.put(p.getId(), new PostRequestModel(p.getPostTitle(), p.getUserId(), p.getId(), p.getContent(),
                        p.getTimes(), p.getViews(), p.getNumLikes(), p.getUserLiked(), p.getListComment(), p.getTopic()));
            }
            hottestTopics.add(new TopicRequestModel(t.getName(), t.getID(), posts));
        }
        return hottestTopics;





//        ArrayList<Topic> toptopics = new ArrayList<>();
//        ArrayList<Topic> topicClone = new ArrayList<>();
//        for (TopicRequestModel t : topic) {
//            Map<Integer, Post> posts = new HashMap<>();
//            Map<Integer, PostResponseModel> postR = (Map<Integer, PostResponseModel>) t.get().get(3);
//            for (Integer p : postR.keySet()) {
//                posts.put(p, new Post((String) postR.get(p).get().get(0),
//                        (Integer) postR.get(p).get().get(1),
//                        (Integer) postR.get(p).get().get(2),
//                        (String) postR.get(p).get().get(3),
//                        (String) postR.get(p).get().get(4),
//                        (Integer) postR.get(p).get().get(5),
//                        (Integer) postR.get(p).get().get(6),
//                        (ArrayList<Integer>) postR.get(p).get().get(7),
//                        (ArrayList<Integer>) postR.get(p).get().get(8),
//                        (String) postR.get(p).get().get(9)));
//            }
//            topicClone.add(new Topic(t.get().get(0).toString(), (String) t.get().get(1), posts));
//        }
//        Integer maxPop = 0;
//
//        while (toptopics.size() < 10)
//        {
//            maxPop = getMaxTopic(topicClone);
//            for (Topic t: topicClone)
//            {
//                if (t.getPopularity() == maxPop)
//                {
//                    toptopics.add(t);
//                    topicClone.remove(t);
//                }
//            }
//        }
//        ArrayList<TopicRequestModel> hottestTopics = new ArrayList<>();
//        for (Topic t: toptopics)
//        {
//            Map<Integer, PostRequestModel> posts = new HashMap<>();
//            for (Post p: t.getPosts().values())
//            {
//                posts.put(p.getId(), new PostRequestModel(p.getPostTitle(), p.getUserId(), p.getId(), p.getContent(),
//                        p.getTimes(), p.getViews(), p.getNumLikes(), p.getUserLiked(), p.getListComment(), p.getTopic()));
//            }
//            hottestTopics.add(new TopicRequestModel(t.getName(), t.getID(), posts));
//        }
//        return hottestTopics;
    }

    /**
     * <p>
     *     The getMaxTopic method is a method that is used to get the maximum topic.
     * </p>
     * @param topic
     * @return
     */
    private Integer getMaxTopic (ArrayList<Topic> topic)
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