package useCases;

import entity.Post;
import entity.Topic;

import java.util.ArrayList;
import java.util.HashMap;

public class GetTopPostsUseCase {
    /**
     * <p>
     *     The getTopPosts method is a method that is used to get the top posts in a topic.
     * </p>
     * @param topic the topic user chose
     * @return the top posts in the topic
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
}
