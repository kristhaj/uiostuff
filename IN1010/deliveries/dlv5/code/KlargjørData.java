
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

class KlargjørData {
    public static void main(String[] args) {
        Monitor smittetMonitor = new Monitor();
        Monitor ikkeSmittetMonitor = new Monitor();
        
        String filnavn = args[0];
        File fil = new File(filnavn);
        String mappe = fil.getParent() + "/";

        final Integer ANTALL_TRÅDER = 8;

        ArrayList<Lesetråd> lesetråder = new ArrayList<>();
        ArrayList<Flettetråd> flettetråder= new ArrayList<>();

        try {
            Scanner scanner = new Scanner(fil);
            while(scanner.hasNextLine()) {
                // Les hver linje i filen, og splitt linjen i hvert felt på "," separator
                String[] linjeFelt = scanner.nextLine().split(",");
                String filSti = ""+mappe+linjeFelt[0];
                Lesetråd lesetråd;
                if (linjeFelt[1].equals("True")) {
                    lesetråd = new Lesetråd(filSti, smittetMonitor);
                    
                } else {
                    lesetråd = new Lesetråd(filSti, ikkeSmittetMonitor);
                }
                lesetråder.add(lesetråd);
            }
        } catch (FileNotFoundException e) {
            System.err.println(e.toString());
        }

        for (Lesetråd lesetråd : lesetråder) {
            lesetråd.start();
            try {
                lesetråd.join();
            } catch (InterruptedException i) {
                System.err.println("Lesetråd avbrutt i HovedTråd"+i.toString());
            }
        }
        for (int i = 0; i < ANTALL_TRÅDER; i++) {
            flettetråder.add(new Flettetråd(smittetMonitor));
            flettetråder.add(new Flettetråd(ikkeSmittetMonitor));
        }

        for (Flettetråd flettetråd : flettetråder) {
            flettetråd.start();
            try {
                flettetråd.join();
            } catch (InterruptedException i) {
                System.err.println("Flettetråd avbrutt i HovedTråd"+i.toString());
            }
        }

        smittetMonitor.taUt().skrivTilFil("smittet");
        ikkeSmittetMonitor.taUt().skrivTilFil("ikke_smittet");
        







    }
}