package com.company.chatterbook.models;

public class ChatterPost {

    //message text
    private String text;

    //assign message
    public ChatterPost(String message) {
        text = message;
    }

    //return message text
    public String getText() {
        return text;
    }
}
