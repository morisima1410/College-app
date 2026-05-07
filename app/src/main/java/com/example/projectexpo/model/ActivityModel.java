package com.example.projectexpo.model;

public class ActivityModel {

    private String uid;      // User ID
    private String name;     // User Name
    private String action;   // Action performed
    private long time;       // Timestamp

    // Empty constructor for Firebase
    public ActivityModel() {}

    // Full constructor
    public ActivityModel(String uid, String name, String action, long time) {
        this.uid = uid;
        this.name = name;
        this.action = action;
        this.time = time;
    }

    // Getters & Setters
    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }
}
