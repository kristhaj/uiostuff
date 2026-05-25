// 3a

import java.util.Iterator;

class Konkurransegruppe implements Iterable<Seilfly> {
    Seilfly første, siste;

    Konkurransegruppe() {
        første = null;
        siste = null;
    }

    //3b
    public void leggTil(Seilfly fly) {
        if (siste == null) {
            første = fly;
            siste = fly;
        } else {
            siste.neste = fly;
            fly.forrige = siste;
            siste = fly;
        }
    }

    //3c
    public boolean erMed(String flyId) {
        Seilfly sjekkFly = første;
        while(sjekkFly != null) {
            if (sjekkFly.hentId() == flyId) {
                return true;
            }
            sjekkFly = sjekkFly.neste;
        }
        return false;
    }

    //3d
    public Seilfly taUt(String flyId) {
        Seilfly sjekkFly = første;
        while(sjekkFly != null) {
            if (sjekkFly.hentId() == flyId) {
                // eneste fly i gruppen
                if (sjekkFly == første && sjekkFly == siste) {
                    første = null;
                    siste = null;
                // første men ikke eneste fly i gruppen
                } else if (sjekkFly == første) {
                    første = første.neste;
                    første.forrige = null;
                // siste men ikke eneste fly i gruppen
                } else if (sjekkFly == siste) {
                    siste = siste.forrige;
                    siste.neste = null;
                // i gruppen, men ikke først eller sist
                } else {
                    sjekkFly.forrige.neste = sjekkFly.neste;
                    sjekkFly.neste.forrige = sjekkFly.forrige;
                }
                sjekkFly.forrige = null;
                sjekkFly.neste = null;
                return sjekkFly;
            }
        }
        return null;
    }

    //3e
    @Override
    public SeilflyIterator iterator() {
        return new SeilflyIterator();
    }

    public class SeilflyIterator implements Iterator<Seilfly> {
        Seilfly detteSeilfly = første;

        @Override
        public boolean hasNext() {
            return detteSeilfly != null;
        }

        @Override
        public Seilfly next() {
            Seilfly res = detteSeilfly;
            detteSeilfly = detteSeilfly.neste;
            return res;
        }
    }

    //3f
    public Seilfly[] hentEkteSeilfly() {
        int antallEkteSeilfly = 0;
        for (Seilfly sf: this) {
            if(sf instanceof EkteSeilfly) {
                antallEkteSeilfly++;
            }
        }
        Seilfly[] ekteSeilflyListe = new Seilfly[antallEkteSeilfly];
        int i = 0;
        for (Seilfly sf: this) {
            if(sf instanceof EkteSeilfly) {
                ekteSeilflyListe[i++] = sf;
            }
        }
        return ekteSeilflyListe;
    }

    //4a
    public int besteGlidetall() {
        if (siste == null) {
            return 0;
        } else {
            int bestGlidetall = 0;
            for (Seilfly sf: this) {
                bestGlidetall = Math.max(sf.hentGlidetall(), bestGlidetall);
            }
            return bestGlidetall;
        }
    }

    //4b
    public int størstVingespenn() {
        if (første == null) {
            return 0;
        } else {
            return første.finnStørsteVingespenn();
        }
    }

    //4c
    public int[] histogramSpennvidde() {
        int[] histogram = new int[100];
        for(Seilfly sf: this) {
            int vingespenn = sf.hentVingespenn();
            if (vingespenn >= 10 && vingespenn <= 99) {
                ++histogram[vingespenn];
            }
        }
        return histogram;
    }


}