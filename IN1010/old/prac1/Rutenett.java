public class Rutenett {
    int antRader;
    int antKolonner;
    Celle[][] rutene;
    
    public Rutenett(int rad, int kolonne) {
        antRader = rad;
        antKolonner = kolonne;
        rutene = new Celle[antRader][antKolonner];
    }

    public void lagCelle(int rad, int kolonne) {
        rutene[rad][kolonne] = new Celle();
        if (Math.random() <= 0.3333) {
            rutene[rad][kolonne].settLevende();
        }
    }

    public void fyllMedTilfeldigeCeller() {
        for (int i = 0; i < antRader; i++) {
            for (int j = 0; j < antKolonner; j++) {
                lagCelle(i, j);
            }
        }
        kobleAlleCeller();
    }

    public Celle hentCelle(int rad, int kolonne) {
        if (rad >= 0 && rad < antRader && kolonne >= 0 && kolonne < antKolonner ) {
            return rutene[rad][kolonne];
        } else {
            return null;
        }
    }

    public void tegnRutenett() {
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n+"+"---+".repeat(antKolonner));
        for (Celle[] rad : rutene) {
            System.out.print("|");
            for (Celle celle : rad) {
                System.out.print(" "+celle.hentStatusTegn()+" |");
            }
            System.out.println("\n+"+"---+".repeat(antKolonner));

        }
    }

    public void settNaboer(int rad, int kolonne) {
        Celle hovedCelle = hentCelle(rad, kolonne);
        // iterere gjennom raden over, gitt rad og raden under
        for (int i = rad-1; i <= rad+1; i++) {
            /// ignorer rad utenfor brettet
            if (i >= 0) {
                // iterere gjennom kolonnen til venstre, gitt kolonne og kolonnen til høyre
                for (int j = kolonne-1; j <= kolonne+1; j++) {
                    // ignorer kolonne utenfor brettet
                    if (j >= 0) {
                        // hovedCelle kan ikke være nabo til seg selv
                        if (i != rad || j != kolonne) {
                            Celle muligNaboCelle = hentCelle(i, j);
                            if (muligNaboCelle != null) {
                                hovedCelle.leggTilNabo(muligNaboCelle);
                            }
                        }
                    }
                    
                }
            }
            
        }
    }

    public void kobleAlleCeller() {
        for (int i = 0; i < antRader; i++) {
            for (int j = 0; j < antKolonner; j++) {
                settNaboer(i, j);
            }
        }
    }

    public int antallLevende() {
        int antallLevende = 0;
        for (Celle[] rad : rutene) {
            for (Celle celle : rad) {
                if (celle.levende) {
                    antallLevende += 1;
                }
            }
        }
        return antallLevende;
    }
}