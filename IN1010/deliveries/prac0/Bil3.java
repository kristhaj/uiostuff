public class Bil3 {

    String bilNummer;

    public Bil3(String nummer) {
        bilNummer = nummer;
    }   
    public void bil3() {
        System.out.println("Jeg er en bil, med bilnummer "+bilNummer);
    }
    public String hentNummer() {
        return bilNummer;
    }

}