abstract class Legemiddel {
    public final int id;
    public final String navn;
    public int pris;
    public final double mengdeVirkestoff;


    public Legemiddel(String navn, int pris, double mengdeVirkestoff) {
        // TODO: make unique
        this.id = 0;
        this.navn = navn;
        this.pris = pris;
        this.mengdeVirkestoff = mengdeVirkestoff;
    }

    public int hentPris() {
        return this.pris;
    }

    public void settNyPris(int nyPris) {
        this.pris = nyPris;
    }



}