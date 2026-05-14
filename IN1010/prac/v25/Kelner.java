// 3
class Kelner extends Ansatt {
    public Samling<Bord> bordSamling;

    Kelner(String navn) {
        super(navn);
        bordSamling = new Samling<>(10);
    }

    // 6
    public int servererAntallGjester() {
        int antallGjester = 0;
        for(Bord b: bordSamling) {
            antallGjester += b.sittendeGruppe.antallGjester();
        }
        return antallGjester;
    }
}