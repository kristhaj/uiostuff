public class GameOfLife {
    
    public static void main(String[] args) {
        Verden verden = new Verden(8, 12);
        System.out.println("Startverden:");
        verden.tegn();
        for (int i=1; i<=3; i++) {
            verden.oppdatering();
            System.out.printf("\n%d generasjon(er) simulert.\nVerden:", i);
            verden.tegn();
        }
    }
}