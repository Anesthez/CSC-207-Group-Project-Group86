package Layer1.Entity.factories;

import Layer1.Entity.Post;
import Layer1.Entity.Topic;

import java.util.Map;

public class TopicFactory {
    public Topic create(String name, String ID, Map<Integer, Post> posts)
    {
        return new Topic(name, ID, posts);
    }
}
