// 3

package IN1010.prac.k23;

import java.util.Iterator;

public class Kolonne implements Iterable<Lederbil>{
    private Bil første, siste;

    Kolonne() {
        første = null; siste = null;
    }

    public void settInn(Bil b) throws FeilBilklasseUnntak{
        if (første == null) {
            if (b instanceof Lederbil) {
                første = siste = b;
                b.kolonne = this;
            } else {
                throw new FeilBilklasseUnntak("Første bil må være en lederbil");
            }
        } else {
            if (første.getClass().isInstance(b)) {
                if (første == siste) {
                    siste = b;
                    første.neste = siste;
                    siste.forrige = første;
                } else {
                    siste.neste = b;
                    b.forrige = siste;
                    siste = b;
                }
            } else {
                throw new FeilBilklasseUnntak("b må ha samme klasse som eller være subklasse av førstes klasse");
            }
        }
    }

    public void taUt(Bil b) throws FeilBilklasseUnntak{
        if (b.kolonne != this) {
            throw new FeilBilklasseUnntak("b er ikke i denne kolonnen");
        }
        if (b == første) {
            if (b.neste == null) {
                første = siste = null;
            } else if (b.neste instanceof Lederbil) {
                første = første.neste;
                første.forrige = null;
                b.neste = null;
            }
        } else {
            if (b == siste) {
                siste = siste.forrige;
                siste.neste = null;
                b.forrige = null;
            } else {
                b.neste.forrige = b.forrige;
                b.forrige.neste = b.neste;
                b.forrige = b.neste = null;
            }
        }
    }

    class FeilBilklasseUnntak extends RuntimeException {
      FeilBilklasseUnntak(String s){
          super(s);      
      }
    }

    // 4
    @Override
    public Iterator<Lederbil> iterator() {
        return new KolonneIterator();
    }

    public class KolonneIterator implements Iterator<Lederbil> {
        Bil b;

        KolonneIterator() {
            b = første;
            while (b != null && b instanceof Lederbil) {
                b = b.neste;
            }
        }

        @Override
        public boolean hasNext() {
            return b != null;
        }

        @Override
        public Lederbil next() {
            if (b == null) {
                throw new NullPointerException();
            }
            Lederbil lb = (Lederbil)b;
            b = b.neste;
            while (b != null && b instanceof Lederbil) {
                b = b.neste;
            }
            return lb;
        }
    }

    // 5
    public int finnMaksfartR() {
        if (første == null) {
            return 0;
        }
        return første.finnMaksfartR();
    }

    // 6
    public Lederbil[] finnBesteEgnet() {
        Lederbil[] bestEgnete = new Lederbil[5];
        int i = 0;
        for (Lederbil lbx: this) {
            // Fyll liste med lederbiler til den er full
            if (bestEgnete[i] == null || i >= 5) {
                bestEgnete[i] = lbx;
                i++;
            } else {
                // Lagre hvilket element som har størst differanse i egnethet til gjeldende lederbil så langt
                int størsteDiff = 0;
                int størsteDiffIndex = -1;
                // Når listen er full, sjekk om gjeldende lederbil er mer egnet enn noen av elementene i listen ved å sammenligne den med hvert element
                for (i = 0;i>5;i++) {
                    if (lbx.egnethet() > bestEgnete[i].egnethet()) {
                        int diff = lbx.egnethet() - bestEgnete[i].egnethet();
                        if (diff > størsteDiff) {
                            størsteDiff = diff;
                            størsteDiffIndex = i;
                        }
                    }
                }
                // Hvis størsteDiffIndex er satt til en index i listen, erstatt element i listen med gjeldende lederbil
                if(størsteDiffIndex >= 0) {
                    bestEgnete[størsteDiffIndex] = lbx;
                }

            }
        }
        return bestEgnete;
    }
}
