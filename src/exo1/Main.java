package exo1;

public class Main {
    public static Compteur[] compteurs = new Compteur[3];

    public static void main(String[] args) {
        for (int i = 0; i < compteurs.length; i++) {
            compteurs[i] = new Compteur("Compteur_" + (i + 1), 5);
        }
    }
}
