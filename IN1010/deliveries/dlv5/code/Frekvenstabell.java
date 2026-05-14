
import java.io.IOException;
import java.io.PrintWriter;
import java.util.TreeMap;

class Frekvenstabell extends TreeMap<String, Integer> {
    
    @Override 
    public String toString() {
        // Stringbuilder variabel for å bygge formatert streng til utskrift
        StringBuilder utskriftBygger = new StringBuilder();
        // Iterer gjennom vært par av nøkler og verdi og bygg utskriften linje for linje
        this.entrySet().forEach(par -> {
            utskriftBygger
                .append(par.getKey())
                .append(" ")
                .append(String.valueOf(par.getValue()))
                .append(System.lineSeparator());
        });
        return utskriftBygger.toString();
    }

    public static Frekvenstabell flett(Frekvenstabell f1, Frekvenstabell f2) {
        Frekvenstabell flettet = new Frekvenstabell();
        // Kopier alle nøkkel og verdipar fra f1 til flettet
        flettet.putAll(f1);
        // Iterer gjennom og flett alle nøkler n og verdier v fra f2 til flettet, og summer verdiene v1 og v2 ved matchende nøkler
        f2.forEach((n, v) -> 
            flettet.merge(n, v, (v1, v2) -> v1+v2));
                
        return flettet;
    }

    public void skrivTilFil(String filnavn) {
        PrintWriter filSkriver = null;
        try {
            filSkriver = new PrintWriter(filnavn);
        } catch (IOException e) {
            System.err.println(e.toString());
        }
        filSkriver.print(this.toString());
        filSkriver.close();
    }
}