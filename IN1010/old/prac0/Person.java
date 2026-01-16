public class Person {
    Bil3 bil;
    public Person(Bil3 bil3) {
        bil = bil3;
    }
    public void personBil() {
        System.out.println("Denne personen eier bilen med bilnummer: "+bil.hentNummer());
    }
}