
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Monitor {
    private final Subsekvensregister ssr;
    volatile Integer uteTilFletting;
    Lock lås = new ReentrantLock();

    public Monitor() {
        this.ssr = new Subsekvensregister();
        this.uteTilFletting = 0;
    }

    public void settInn(Frekvenstabell f) {
        ssr.settInn(f);
    }

    public Frekvenstabell taUt() {
        return ssr.taUt();
    }

    public Integer antall() {
        return ssr.antall();
    }

    public Frekvenstabell les(String filnavn) {
        return Subsekvensregister.les(filnavn);
    }

    public Frekvenstabell[] taUtTo() {
        lås.lock();
        Condition ikkeSattInnC = lås.newCondition();
        try {
            // Vent på at det er minst 2 Frekvenstabeller som kan tas ut av Subsekvensregisteret
            while(antall() < 2) {
                try {
                    ikkeSattInnC.await();
                } catch (InterruptedException e) {
                    System.out.println(e.toString());
                }
            }
            // Ta ut to Frekvenstabeller og lagre dem i en Frekvenstabellarray for returnering
            Frekvenstabell[] fArray = new Frekvenstabell[] {taUt(), taUt()};
            // Inkrementer antall frekvenstabeller som er ute til fletting
            uteTilFletting ++;
            return fArray;
        } finally {
            lås.unlock();
        }
    }

    public void settInnFlettet(Frekvenstabell f) {
        settInn(f);
        // Dekrementer Frekvenstabeller ute til fletting når innsetting er gjort
        uteTilFletting --;
    }
}