package com.example.projectexpo.model;

public class PlacementUser {

    private String id;
    private String enrollment;
    private String fullName;
    private String gender;
    private String dob;
    private String phStatus;
    private String mobile;
    private String branch;
    private String email;
    private String cgpa;

    // FireBase child key holder (for update/delete)
    private String firebaseKey;

    // Required empty constructor
    public PlacementUser() { }

    public PlacementUser(String id, String enrollment, String fullName, String gender,
                         String dob, String phStatus, String mobile, String branch,
                         String email, String cgpa) {

        this.id = id;
        this.enrollment = enrollment;
        this.fullName = fullName;
        this.gender = gender;
        this.dob = dob;
        this.phStatus = phStatus;
        this.mobile = mobile;
        this.branch = branch;
        this.email = email;
        this.cgpa = cgpa;
    }

    // ==========================
    // All Getters & Setters
    // ==========================

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEnrollment() {
        return enrollment;
    }

    public void setEnrollment(String enrollment) {
        this.enrollment = enrollment;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getGender() { return gender; }

    public void setGender(String gender) { this.gender = gender; }

    public String getDob() { return dob; }

    public void setDob(String dob) { this.dob = dob; }

    public String getPhStatus() { return phStatus; }

    public void setPhStatus(String phStatus) { this.phStatus = phStatus; }

    public String getMobile() { return mobile; }

    public void setMobile(String mobile) { this.mobile = mobile; }

    public String getBranch() { return branch; }

    public void setBranch(String branch) { this.branch = branch; }

    public String getEmail() { return email; }

    public void setEmail(String email) { this.email = email; }

    public String getCgpa() { return cgpa; }

    public void setCgpa(String cgpa) { this.cgpa = cgpa; }

    // ==========================
    // Firebase Key setter/getter
    // ==========================

    public String getFirebaseKey() {
        return firebaseKey;
    }

    public void setFirebaseKey(String firebaseKey) {
        this.firebaseKey = firebaseKey;
    }

}
