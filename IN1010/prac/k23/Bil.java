// 2

package IN1010.prac.k23;

public abstract class Bil {
    private final int maksFart;
    public Kolonne kolonne = null;
    public Bil neste, forrige = null;

    Bil(int fart) {
        maksFart = fart;
    }

    public int hentFart() {
        return maksFart;
    }

    //5
    public int finnMaksfartR() {
        if (neste == null) {
            return hentFart();
        }
        return Math.min(neste.finnMaksfartR(), hentFart());
    }
    
}
