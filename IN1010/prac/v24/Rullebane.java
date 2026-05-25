// 5a
package IN1010.prac.v24;

import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class Rullebane {
    int antallVentendeFly;
    Lock lås = new ReentrantLock();
    Condition avventStartTillatelse = lås.newCondition();

    Rullebane() {
        antallVentendeFly = 0;
    }

    // 5d
    Condition avventFly = lås.newCondition();

    public void sjekkAvganger() {
        lås.lock();
        try {
            while (antallVentendeFly == 0) {
                avventFly.await();
            }
            avventStartTillatelse.signal();
            antallVentendeFly--;
        } catch(InterruptedException e ) {
            return;
        } finally {
            lås.unlock();
        }
    }

    public void hentStartTillatelse(Fly f) {
        lås.lock();
        try {
            antallVentendeFly++;
            avventFly.signalAll();
            avventStartTillatelse.await();
        } catch (InterruptedException e) {
            return;
        } finally {
            lås.unlock();
        }
    }
    
}
