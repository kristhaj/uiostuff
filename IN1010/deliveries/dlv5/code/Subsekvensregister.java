import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

class Subsekvensregister {
    private static final Integer SUBSEKVENSLENGDE = 3;

    private ArrayList<Frekvenstabell> register = new ArrayList<>();

    // Legger til gitt frekvenstabell til slutt i listen
    public void settInn(Frekvenstabell f) {
        register.add(f);
    }

    // Tar ut frekvenstabell på en tilfeldig index innenfor registerets lengde
    public Frekvenstabell taUt() {
        Random tilfeldigTall = new Random();
        return register.remove(tilfeldigTall.nextInt(antall()));
    }

    public Integer antall() {
        return register.size();
    }

    public static Frekvenstabell les(String filnavn) {
        Frekvenstabell f = new Frekvenstabell();
        try {
            Scanner scanner = new Scanner(new File(filnavn));
            while (scanner.hasNextLine()) {
                String sekvens = scanner.nextLine();
                // Iterer gjennom alle substrenger med lengde lik SUBSEKVENSLENGDE i hver linje lest fra angitt fil
                for (int i = 0; i+SUBSEKVENSLENGDE <= sekvens.length(); i++) {
                    String subsekvens = sekvens.substring(i, i+SUBSEKVENSLENGDE);
                    // Legg til subsekvensen i Frekvenstabell f dersom den ikke finnes blant eksisterende nøkler allerede
                    if (!f.containsKey(subsekvens)) {
                        f.put(subsekvens, 1);
                    }
                }

            }
        } catch (FileNotFoundException e) {
            System.err.println(e.toString());
        }
        return f;
        
    }


}