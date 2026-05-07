package com.example.projectexpo;


public class FeedbackModel {

    String name, enroll;
    float rating;

    public FeedbackModel() {
    }

    public FeedbackModel(String name, String enroll, float rating) {
        this.name = name;
        this.enroll = enroll;
        this.rating = rating;
    }

    public String getName() { return name; }
    public String getEnroll() { return enroll; }
    public float getRating() { return rating; }
}
