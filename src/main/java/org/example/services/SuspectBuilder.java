package org.example.services;

import org.example.models.Suspect;

public class SuspectBuilder {

    private String crime;

    private String surName;

    private String firstName;

    private String imgURL;



    public static SuspectBuilder builder() {
        return new SuspectBuilder();
    }

    private SuspectBuilder() {
    }

    public SuspectBuilder crime(String crime) {
        this.crime = crime;
        return this;
    }

    public SuspectBuilder surName(String surName) {
        this.surName = surName;
        return this;
    }

    public SuspectBuilder firstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public SuspectBuilder imgURL(String imgURL) {
        this.imgURL = imgURL;
        return this;
    }

    public Suspect build() {
        return new Suspect(this.crime,this.surName,this.firstName,this.imgURL);
    }

}
