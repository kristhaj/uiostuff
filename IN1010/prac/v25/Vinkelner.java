// 3
class Vinkelner extends Ansatt implements Sommelier{
    private final String spesialitet;

    Vinkelner(String navn, String spesialitet) {
        super(navn);
        this.spesialitet = spesialitet;
    }

    @Override
    public String spesialitet() {
        return spesialitet;
    }
}