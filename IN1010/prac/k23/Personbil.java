// 2
package IN1010.prac.k23;

public class Personbil extends Bil{
    private final int maksPassasjerer;

    Personbil(int fart, int passasjerer) {
        super(fart);
        maksPassasjerer = passasjerer;
    }

    public int hentMaksPassasjerer() {
        return maksPassasjerer;
    }
}
