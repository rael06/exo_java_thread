package exo4;

public class Main {

    public static void main(String[] args) {
        int[] t = {5, 8, 3, 2, 7, 10, 1};
        Trieur trieur = new Trieur(t);
        try {
            trieur.join();
        } catch (InterruptedException e) {
        }
        for (int i = 0; i < t.length; i++) {
            System.out.print(t[i] + " ; ");
        }
        System.out.println();
    }
}
