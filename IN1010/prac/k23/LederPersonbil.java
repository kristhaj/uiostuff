// 2
package IN1010.prac.k23;

public class LederPersonbil extends Personbil implements Lederbil {
    private final int minEgnethet;

    LederPersonbil(int fart, int passasjerer, int minEgnethet) {
        super(fart, passasjerer);
        this.minEgnethet = minEgnethet;
    }

    @Override
    public int egnethet() {
        return minEgnethet;
    }
}
