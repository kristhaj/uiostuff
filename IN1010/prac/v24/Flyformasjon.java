// 3
package IN1010.prac.v24;

import java.util.Iterator;

public class Flyformasjon implements Iterable<Fly> {
    // 3a
    public Fly første;

    Flyformasjon() {
        første = null;
    }

    // 3b
    public void leggTil(Fly f) {
        f.neste = første;
        første = f;
    }

    // 3c
    public boolean erMed(String id) {
        Fly sjekkFly = første;
        while(sjekkFly != null) {
            if(sjekkFly.hentId() == id) {
                return true;
            }
            sjekkFly = sjekkFly.neste;
        }
        return false;
    }

    // 3d
    public Fly taUt(String id) {
        Fly sjekkFly = første;
        Fly forrigeFly = null;
        while(sjekkFly != null) {
            if(sjekkFly.hentId() == id) {
                // første fly i formasjonen
                if(forrigeFly == null) {
                    første = første.neste;
                    return sjekkFly;
                } else {
                    forrigeFly.neste = sjekkFly.neste;
                    return sjekkFly;
                }
            } else {
                forrigeFly = sjekkFly;
                sjekkFly = første.neste;
            }
        }
        return null;
    }
    // 3e

    @Override
    public FlyIterator iterator() {
        return new FlyIterator();
    }

    public class FlyIterator implements Iterator<Fly> {
        Fly detteFly;

        FlyIterator() {
            detteFly = første;
        }

        @Override
        public boolean hasNext() {
            return detteFly != null;
        }

        @Override
        public Fly next() {
            Fly res = detteFly;
            detteFly = detteFly.neste;
            return res;
        }
    }

    // 3f
    public PassasjerFly[] hentPassasjerFly() {
        int antallPassasjerFly = 0;
        for(Fly fx: this) {
            if (fx instanceof PassasjerFly) {
                antallPassasjerFly++;
            }
        }
        PassasjerFly[] passasjerFlyListe = new PassasjerFly[antallPassasjerFly];
        int i = 0;
        for(Fly fx: this) {
            if(fx instanceof PassasjerFly) {
                passasjerFlyListe[i] = (PassasjerFly)fx;
                i++;
            }
        }
        return passasjerFlyListe;
    }

    // 4a
    public int totalVekt() {
        int sum = 0;
        for(Fly fx: this) {
            sum += fx.hentMTOW();
        }
        return sum;
    }

    // 4b
    public int maksVekt() {
        if (første == null) {
            return 0;
        }
        return første.finnMaksVekt();
    }


}
