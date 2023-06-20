package com.company.chatterbook.models;

import java.util.ArrayList;
import java.util.List;

public class User {

    //user name
    public String name;

    //list of chatterPosts
    List<ChatterPost> chatterPosts = new ArrayList<ChatterPost>();

    public User(String username) {
        this.name = username;
    }

    public void setChatterPosts(List<ChatterPost> asList) {
        chatterPosts = asList;
    }

    public List<ChatterPost> getChatterPosts() {
        return chatterPosts;
    }

    public String getName() {
        return name;
    }
}
