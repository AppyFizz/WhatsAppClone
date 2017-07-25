package com.example.shreyan.whatsapp.Contact;

import com.example.shreyan.whatsapp.Message.Message;
import com.example.shreyan.whatsapp.R;

/**
 * Created by AppyFizz on 7/21/2017.
 */

/*
 * This class represents a single contact.
 */

public class Contact {

    // Contains only contact's username, picture, and a preview of their last message for now.
    // Can later be extended to include contact's details (such as name, age, gender, etc.),
    // and maybe even the user's messaging history with this particular contact.


    // ATTRIBUTES

    private int imgResource;
    private String username;
    private String preview;


    // CONSTRUCTORS

    public Contact(String username) {
        // Default image resource
        this.imgResource = R.drawable.wonder_woman_silhouette;
        this.username = username;
        // Default text preview
        this.preview = "";
    }

    public Contact(int imgResource, String username) {
        this.imgResource = imgResource;
        this.username = username;
        // Default text preview
        this.preview = "";
    }

    public Contact(String username, String preview) {
        // Default image resource
        this.imgResource = R.drawable.wonder_woman_silhouette;
        this.username = username;
        setPreview(preview);
    }

    public Contact(int imgResource, String username, String preview) {
        this.imgResource = imgResource;
        this.username = username;
        setPreview(preview);
    }

    public Contact(String username, Message message) {
        // Default image resource
        this.imgResource = R.drawable.wonder_woman_silhouette;
        this.username = username;
        setPreview(message);
    }

    public Contact(int imgResource, String username, Message message) {
        this.imgResource = imgResource;
        this.username = username;
        setPreview(message);
    }


    // COPY CONSTRUCTOR

    public Contact(Contact contact) {
        this.imgResource = contact.getImgResource();
        this.username = contact.getUsername();
        this.preview = contact.getPreview();
    }


    // GETTERS AND SETTERS

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getImgResource() {
        return imgResource;
    }

    public void setImgResource(int imgResource) {
        this.imgResource = imgResource;
    }

    public String getPreview() {
        return preview;
    }

    // TODO: Enforce character limit, and add dots at end if message exceeds limit
    public void setPreview(String preview) {
        this.preview = preview;
    }

    public void setPreview(Message message) {
        this.preview = message.getMessage();
    }


    // TOSTRING

    /**
     * Override the default toString() method.
     *
     * @return The contact's username.
     */
    @Override
    public String toString() {
        return username;
    }
}
