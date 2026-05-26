// 2
package IN1010.prac.k23;

public class Lastebil extends Bil{
    private final int maksLast;

    Lastebil(int fart, int lastevekt) {
        super(fart);
        maksLast = lastevekt;
    }

    public int hentMaksLast() {
        return maksLast;
    }
}
