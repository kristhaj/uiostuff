class Lesetråd extends Thread implements Runnable {

    private final String filnavn;
    private final Monitor monitor;


    public Lesetråd(String filnavn, Monitor monitor) {
        this.filnavn = filnavn;
        this.monitor = monitor;
    }

    @Override
    public void run() {
        Frekvenstabell f = monitor.les(filnavn);
        monitor.settInn(f);
    }

}