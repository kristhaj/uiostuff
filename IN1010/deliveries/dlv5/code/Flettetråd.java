
class Flettetråd extends Thread implements Runnable {

    private final Monitor monitor;

    public Flettetråd(Monitor monitor) {
        this.monitor = monitor;
    }

    @Override
    public void run() {
        try {
            // Kjør fletting frem til det bare er èn frekvenstabell igjen
            while(monitor.antall() + monitor.uteTilFletting != 1) {
                Frekvenstabell[] frekvenstabellerTilFletting = monitor.taUtTo();
                Frekvenstabell flettetF = Frekvenstabell.flett(frekvenstabellerTilFletting[0], frekvenstabellerTilFletting[1]);
                monitor.settInnFlettet(flettetF);
            }
            if (Thread.interrupted())  // Håndterer avbrudd
                throw new InterruptedException();
        } catch (InterruptedException i) {
            System.err.println("Flettetråd avbrutt"+i.toString());
        }
        
    }



}