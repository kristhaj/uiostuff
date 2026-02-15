public class Verden {
    Rutenett rutenett;
    int genNr;

    public Verden(int antallRader, int antallKolonner) {
        rutenett = new Rutenett(antallRader, antallKolonner);
        rutenett.fyllMedTilfeldigeCeller();
        genNr = 0;
    }

    public void tegn() {
        rutenett.tegnRutenett();
        System.out.printf("Generasjon: %d\nAntall Levende Celler: %d\n", genNr, rutenett.antallLevende());
    }

    public void oppdatering() {
        for (Celle[] rad : rutenett.rutene) {
            for ( Celle celle : rad) {
                celle.tellLevendeNaboer();
                celle.oppdaterStatus();
            }
        }
        genNr += 1;

    }
}