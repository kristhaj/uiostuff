// 3
class Bord {
    public int antallPlasser;
    public Gjestegruppe sittendeGruppe;
    public Kelner ansvarligKelner;

    public Bord(int antallPlasser) {
        this.antallPlasser = antallPlasser;
    }

    public void taIBruk(Gjestegruppe gjestegruppe, Kelner kelner) {
        sittendeGruppe = gjestegruppe;
        ansvarligKelner = kelner;
    }

    public void gjørKlarTilBruk() {
        ansvarligKelner.bordSamling.fjern(this);
        sittendeGruppe = null;
        ansvarligKelner = null;
    }

    public boolean erLedig() {
        return sittendeGruppe == null;
    }
}