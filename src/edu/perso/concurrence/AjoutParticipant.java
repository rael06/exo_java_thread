package edu.perso.concurrence;

public class AjoutParticipant implements Runnable {
    private Manege manege;
    private Participant participant;

    public AjoutParticipant(Manege manege, Participant participant) {
        this.manege = manege;
        this.participant = participant;
    }

    @Override
    public void run() {
        while (!participant.isHasPlayed()) {
            manege.addParticipant(participant);
        }
    }
}
