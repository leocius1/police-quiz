package org.example.models;

public class Suspect {

    public Suspect(String crime, String firstName, String surName, String imgUrl) {
        this.firstName = firstName;
        this.surName = surName;
        this.imgUrl = imgUrl;
        this.crime = crime;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getCrime() {
        return crime;
    }

    public void setCrime(String crime) {
        this.crime = crime;
    }

    private String firstName;

    private String surName;

    private String imgUrl;

    private String crime;

}
