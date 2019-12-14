package edu.perso.concurrence;

public class Participant {
    private String name;
    private boolean hasPlayed = false;

    public Participant(String name) {
        this.name = name;
    }

    public void setHasPlayed(boolean hasPlayed) {
        this.hasPlayed = hasPlayed;
    }

    public boolean isHasPlayed() {
        return hasPlayed;
    }

    @Override
    public String toString() {
        return "Participant{" +
                "name='" + name + '\'' +
                '}';
    }
}
