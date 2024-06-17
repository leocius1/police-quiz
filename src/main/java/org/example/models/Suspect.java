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

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Suspect suspect = (Suspect) o;
        return this.crime.equals(suspect.crime) && this.firstName.equals(suspect.firstName);
    }

    private String firstName;

    private String surName;

    private String imgUrl;

    private String crime;

}
