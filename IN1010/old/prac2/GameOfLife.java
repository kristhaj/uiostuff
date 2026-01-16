import java.util.Scanner;

public class GameOfLife {
    
    public static void main(String[] args) {
        //Ta input fra bruker for å definere en startverden
        Scanner brukerInput = new Scanner(System.in);
        System.out.println("Angi ønsket antall rader:");
        // rad input
        int rader = brukerInput.nextInt();
        System.out.println("Angi ønsket antall kolonner:");
        // kolonne input
        int kolonner = brukerInput.nextInt();

        Verden verden = new Verden(rader, kolonner);
        System.out.printf("Startverden (%d x %d):", rader, kolonner);
        verden.tegn();

        System.out.println("Angi hvor mange generasjoner som skal simuleres:");
        // generasjoner input
        int generasjoner = brukerInput.nextInt();
        for (int i=1; i<=generasjoner; i++) {
            verden.oppdatering();
            System.out.printf("\n%d generasjon(er) simulert.\nVerden:", i);
            verden.tegn();
        }
    }
}