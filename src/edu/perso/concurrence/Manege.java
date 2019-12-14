package edu.perso.concurrence;

public class Manege {
    private Participant[] participants = new Participant[5];

    synchronized public void addParticipant(Participant participant) {
        for (int i = 0; i < participants.length; i++) {
            if (participants[i] == null) {
                participants[i] = participant;
                break;
            }
        }
        try {
            wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void isFull() {
        boolean plein = true;
        for (Participant participant : participants) {
            if (participant == null) {
                plein &= false;
                break;
            } else {
                plein &= true;
            }
        }
        System.out.println(plein ? "manège plein" : "manège non plein");
    }

    public void tourne() {
        System.out.println("le manège tourne");
        for (Participant participant : participants) {
            System.out.println(participant.toString());
        }
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    synchronized public void reset() {
        for (int i = 0; i < participants.length; i++) {
            participants[i].setHasPlayed(true);
            participants[i] = null;
        }
        notifyAll();
    }
}
