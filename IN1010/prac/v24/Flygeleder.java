// 5b
package IN1010.prac.v24;

public class Flygeleder implements Runnable {
    private Rullebane monitor;

    Flygeleder(Rullebane rullebane) {
        monitor = rullebane;
    }

    @Override
    public void run() {
        while(true) {
            monitor.sjekkAvganger();
            try {
                Thread.sleep(60*1000);
            } catch (InterruptedException e) {
                return;
            }
        }
    }
    
}
