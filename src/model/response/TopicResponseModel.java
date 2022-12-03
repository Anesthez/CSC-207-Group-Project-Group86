package model.response;

import model.Model;

import java.util.ArrayList;
import java.util.Map;

public class TopicResponseModel implements Model {
    private String name;
    private String ID;

    private Map<Integer, UserResponseModel> users;

    private Map<Integer, PostResponseModel> posts;


    public TopicResponseModel(String ID, String name, Map<Integer, UserResponseModel> users,
                              Map<Integer, PostResponseModel> posts)
    {
        this.name = name;
        this.ID = ID;
        this.users = users;
        this.posts = posts;
    }

    public TopicResponseModel(String ID, String name, Map<Integer, PostResponseModel> posts)
    {
        this.name = name;
        this.ID = ID;
        this.posts = posts;
    }

    public ArrayList<Object> get(){
        ArrayList<Object> contents = new ArrayList<>();
        contents.add(ID);
        contents.add(name);
        contents.add(users);
        contents.add(posts);
        return contents;
    }
}
