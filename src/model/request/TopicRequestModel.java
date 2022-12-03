package model.request;

import model.RequestModel;
import model.ResponseModel;

import java.util.ArrayList;
import java.util.Map;

public class TopicRequestModel implements RequestModel {
    private String name;
    private String ID;

    private Map<Integer, UserRequestModel> users;

    private Map<Integer, PostRequestModel> posts;


    public TopicRequestModel(String ID, String name, Map<Integer, UserRequestModel> users,
                             Map<Integer, PostRequestModel> posts)
    {
        this.name = name;
        this.ID = ID;
        this.users = users;
        this.posts = posts;
    }

    public TopicRequestModel(String ID, String name, Map<Integer, PostRequestModel> posts)
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
