package edu.perso.concurrence;

public class Main {

    public static void main(String[] args) {

        Manege manege = new Manege();

        for (int i=0; i<100; i++) {
            Participant p = new Participant("Participant n°" + i);
            Thread t = new Thread(new AjoutParticipant(manege, p));
            t.start();
        }

        while (true) {
            manege.tourne();
            manege.reset();
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
