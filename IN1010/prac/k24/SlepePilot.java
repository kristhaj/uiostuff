// 5c
class SlepePilot implements Runnable {
    public KlarTilStart monitor;

    SlepePilot(KlarTilStart monitor) {
        this.monitor = monitor;
    }

    @Override
    public void run() {
        while(true) {
            Seilfly fly = monitor.nesteSeilfly();
            try {
                Thread.sleep(6*60*1000);
            } catch(InterruptedException e) {
                return;
            }
        }
    }
}