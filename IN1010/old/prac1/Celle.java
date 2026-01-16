public class Celle {
    Boolean levende;
    Celle[] naboer;
    int antNaboer;
    int antLevendeNaboer;

    public Celle() {
        levende = false;
        naboer = new Celle[8];
        antNaboer = 0;
        antLevendeNaboer = 0;
    }

    public void settLevende() {
        levende = true;
    }

    public void settDød() {
        levende = false;
    }

    public Boolean erLevende() {
        return levende;
    }

    public char hentStatusTegn() {
        if (levende) {
            return 'O';
        } else {
            return '.';
        }
    }
    public void leggTilNabo(Celle celle) {
        naboer[antNaboer] = celle;
        antNaboer+=1;
    }

    public void tellLevendeNaboer() {
        antLevendeNaboer = 0;
        for (int i = 0; i < antNaboer; i++) {
            if (naboer[i].levende) {
                antLevendeNaboer+=1;
            }
        }
    }
    public void oppdaterStatus() {
        if (levende && (antLevendeNaboer < 2 || antLevendeNaboer > 3)) {
            levende = false;
        } else if (!levende && antLevendeNaboer == 3) {
            levende = true;
        }
    }
}