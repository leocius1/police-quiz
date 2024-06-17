package org.example.models;

import java.util.List;
import java.util.Random;

public class GameLogic {

    public GameLogic(List<String> crime, List<Suspect> suspects) {
        this.crimes = crime;
        this.suspects = suspects;
        this.score = 0;
    }

    public List<String> getCrimes() {
        return crimes;
    }

    public void setCrimes(List<String> crimes) {
        this.crimes = crimes;
    }

    public List<Suspect> getSuspects() {
        return suspects;
    }

    public void setSuspects(List<Suspect> suspects) {
        this.suspects = suspects;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void IncrementScore(){
        this.score++;
    }

    public Suspect getRandomSuspect() {
        Random random = new Random();
        int randomNumber = random.nextInt(suspects.size());
        return this.suspects.get(randomNumber);
    }

    public void removeSuspect(Suspect suspect) {
        this.suspects.remove(suspect);
    }

    public String getRandomCrime() {
        Random random = new Random();
        int randomNumber = random.nextInt(crimes.size());
        return this.crimes.get(randomNumber);
    }

    public boolean isCrimeTrue(Suspect suspect, String crime) {
        return suspect.getCrime().equals(crime);
    }

    private List<String> crimes;

   private List<Suspect> suspects;

   private int score;

}
