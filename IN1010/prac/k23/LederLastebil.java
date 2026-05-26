// 2
package IN1010.prac.k23;

public class LederLastebil extends Lastebil implements Lederbil {
    private final int minEgnethet;

    LederLastebil(int fart, int vekt, int minEgnethet) {
        super(fart, vekt);
        this.minEgnethet = minEgnethet;
    }

    @Override
    public int egnethet() {
        return minEgnethet;
    }
}
