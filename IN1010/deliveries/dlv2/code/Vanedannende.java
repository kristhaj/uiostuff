// Vanedannende er subklasse til Legemiddel
public class Vanedannende extends Legemiddel{

    public final int styrke;

    // Instansier variabler arvet av superklasse og egen instansvariabel
    public Vanedannende(String navn, int pris, int mengdeVirkestoff, int styrke) {
        super(navn,pris,mengdeVirkestoff);
        this.styrke = styrke;
    }

}