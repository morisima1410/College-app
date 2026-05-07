package com.example.projectexpo.model;

public class NotificationModel {

    private String id;
    private String title;
    private String message;
    private String links; // Added links field

    // Default constructor required for Firebase
    public NotificationModel() {
    }

    public NotificationModel(String id, String title, String message, String links) {
        this.id = id;
        this.title = title;
        this.message = message;
        this.links = links;
    }

    // Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getLinks() {
        return links;
    }

    public void setLinks(String links) {
        this.links = links;
    }
}
