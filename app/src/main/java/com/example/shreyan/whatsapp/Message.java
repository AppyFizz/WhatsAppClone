package com.example.shreyan.whatsapp;

/**
 * Created by AppyFizz on 7/21/2017.
 */

/*
 * This class represents a single message.
 */

public class Message {

    // Contains only message text as a single String for now.
    // Can later be extended to include time-stamps, etc.


    // ATTRIBUTES

    private String message;


    // CONSTRUCTORS

    public Message(String message) {
        this.message = message;
    }


    // COPY CONSTRUCTOR

    public Message(Message m) {
        this.message = m.getMessage();
    }


    // GETTERS AND SETTERS

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


    // TOSTRING

    /**
     * Override the default toString() method.
     *
     * @return The message String.
     */
    @Override
    public String toString() {
        return message;
    }
}
