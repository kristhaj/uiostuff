// 5b
class Plassjef implements Runnable {
    public int antallSlepefly;
    public Konkurransegruppe konkGruppe;
    public KlarTilStart monitor;

    Plassjef(int antall, Konkurransegruppe gruppe, KlarTilStart monitor) {
        antallSlepefly = antall;
        konkGruppe = gruppe;
        this.monitor = monitor;
    }


    @Override
    public void run() {
        for (int i = 0; i < antallSlepefly; i++) {
            SlepePilot pilot = new SlepePilot(monitor);
            new Thread(pilot).start();
        }
        for (Seilfly sf: konkGruppe) {
            monitor.seilflyKlar(sf);
        }
    }
}