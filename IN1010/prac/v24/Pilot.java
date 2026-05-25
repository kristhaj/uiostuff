// 5c
package IN1010.prac.v24;

public class Pilot implements Runnable{
    private final Fly mittFly;
    private final Rullebane monitor;

    Pilot(Fly f, Rullebane r) {
        mittFly = f;
        monitor = r;
    }

    @Override
    public void run() {
        monitor.hentStartTillatelse(mittFly);
    }
    
}
