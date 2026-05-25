// 5a

import java.util.ArrayList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class KlarTilStart {
    ArrayList<Seilfly> seilflyKø = new ArrayList<>();
    Lock lås = new ReentrantLock();
    Condition venterPåSeilfly = lås.newCondition();

    public void seilflyKlar(Seilfly fly) {
        lås.lock();
        try {
            seilflyKø.add(fly);
            venterPåSeilfly.signalAll();
        } finally {
            lås.unlock();
        }
    }

    public Seilfly nesteSeilfly() {
        lås.lock();
        try {
            while (seilflyKø.size() == 0) {
                venterPåSeilfly.await();
            }
            return seilflyKø.remove(0);
        } catch (InterruptedException e) {
            return null;
        } finally {
            lås.unlock();
        }
    }
}