// 2
abstract class Seilfly {
    final String id;
    final int glidetall;
    final int vingespenn;
    Seilfly forrige = null;
    Seilfly neste = null; 

    Seilfly(String id, int glidetall, int vingespenn) {
        this.id = id;
        this.glidetall = glidetall;
        this.vingespenn = vingespenn;
    }

    public String hentId() {
        return id;
    }

    public int hentGlidetall() {
        return glidetall;
    }

    public int hentVingespenn() {
        return vingespenn;
    }
}