
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;

// 3

class RestaurantMonitor {
    private Samling<Bord> bordSamling;
    private Samling<Ansatt> ansattSamling;

    //10
    Lock lås = new ReentrantLock();
    Condition venterPåLedigBord = lås.newCondition();

    RestaurantMonitor() {
        bordSamling = new Samling<>(15);
        ansattSamling = new Samling<>(25);
    }

    public Kelner finnMinstÅGjøre(boolean erVinkelner) {
        // 10
        lås.lock();
        try {
            Kelner minstÅGjøre = null;
            for(Ansatt a: ansattSamling) {
                if(erVinkelner && a instanceof Vinkelner || !erVinkelner && a instanceof Kelner){
                    Kelner k = (Kelner)a;
                    if (minstÅGjøre == null || k.servererAntallGjester() < minstÅGjøre.servererAntallGjester()) {
                        minstÅGjøre = k;
                    }
                }
            }
            return minstÅGjøre;
        } finally {
            lås.unlock();
        }
    }

    // 8
    public Bord taImotGjester(Gjestegruppe gruppe) {
        // 10
        lås.lock();
        try {
            Bord ledigBord = null;
            for (Bord b:bordSamling) {
                if(b.antallPlasser >= gruppe.antallGjester() && b.erLedig()) {
                    ledigBord = b;
                }
            }
            if (ledigBord != null) {
                Kelner minstÅGjøreKelner = finnMinstÅGjøre(gruppe.noenØnskerVin());

                minstÅGjøreKelner.bordSamling.settInn(ledigBord);
                ledigBord.sittendeGruppe = gruppe;
            }
            return ledigBord;
        } catch(InterruptedException e){
            System.exit(1);
            return null;
        } finally {
            lås.unlock();
        }
        

    }

    // 9
    private void visIngenLedigeBord() {
        try {
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
        } catch (Exception e) {
            System.exit(1);
        }
        JFrame vindu = new JFrame("Fullt");
        vindu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
        vindu.add(panel);

        JLabel varsel = new JLabel("Ingen ledige bord funnet!");
        panel.add(varsel);

        JButton okKnapp = new JButton("OK");
        class Stopper implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(1);
            }
        }
        okKnapp.addActionListener(new Stopper());
        panel.add(okKnapp);

        vindu.pack();
        vindu.setLocationRelativeTo(null);
        vindu.setVisible(true);
    }

    // 10

    public void forlatBordet(Bord bord) {
        lås.lock();
        try {
            bord.gjørKlarTilBruk();
            venterPåLedigBord.signalAll();
        } finally {
            lås.unlock();
        }
    }

}