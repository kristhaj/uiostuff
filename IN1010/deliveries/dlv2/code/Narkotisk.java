// Narkotisk er subklasse til Legemiddel
public class Narkotisk extends Legemiddel{

    public final int styrke;

    // Instansier variabler arvet av superklasse og egen instansvariabel
    public Narkotisk(String navn, int pris, int mengdeVirkestoff, int styrke) {
        super(navn,pris,mengdeVirkestoff);
        this.styrke = styrke;
    }

}