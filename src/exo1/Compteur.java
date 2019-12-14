package exo1;

import java.util.Date;

public class Compteur extends Thread {
    private static int position = 0;
    private String name;
    private int limit;
    private int index = 0;

    public Compteur(String name, int limit) {
        this.name = name;
        this.limit = limit;
        System.out.println(name + " commence à compter");
        start();
    }

    public Compteur(String name) {
        this.name = name;
        limit = (int) (Math.random() * 10);
        System.out.println(name + " commence à compter jusqu'à " + limit);
        start();
    }

    @Override
    public void run() {
        long temps = new Date().getTime();
        for (int i = 0; i < limit; i++) {
            index = i + 1;
            int ms = (int) (Math.random() * 1000) + 5000;
            int allie = (int) Math.floor(Math.random() * Main.compteurs.length);
            try {
                sleep(ms);
                synchronized (Main.compteurs[allie]) {
                    Main.compteurs[allie].interrupt();
                }
            } catch (InterruptedException e) {
                System.out.println(name + " a sauté " + index);
            }
        }
        temps = new Date().getTime() - temps;
        System.out.println(name + " a fini en position " + ++position + " de compter jusqu'à " + limit + " en : " + temps + " ms, au lieu d'au moins " + limit * 5000 + " ms.");
    }
}
