package com.example.shreyan.whatsapp;

/**
 * Created by AppyFizz on 7/21/2017.
 */

public class Contact {

    private int imgResource;
    private String username;
    private String preview;

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
        this.preview = preview;
    }

    public Contact(int imgResource, String username, String preview) {
        this.imgResource = imgResource;
        this.username = username;
        this.preview = preview;
    }

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

    public void setPreview(String preview) {
        this.preview = preview;
    }
}
