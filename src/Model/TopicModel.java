package Model;

import Layer1.Entity.Post;
import Layer1.Entity.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class TopicModel implements Model {
    private String name;
    private String ID;

    private Map<Integer, User> users;

    private Map<Integer, Post> posts;


    public TopicModel (String name, String ID, Map<Integer, User> users, Map<Integer, Post> posts)
    {
        this.name = name;
        this.ID = ID;
        this.users = users;
        this.posts = posts;
    }

    public ArrayList<Object> get(){
        ArrayList<Object> contents = new ArrayList<>();
        contents.add(name);
        contents.add(ID);
        contents.add(users);
        contents.add(posts);
        return contents;
    }
}
