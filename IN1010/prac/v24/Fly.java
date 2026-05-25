// 2
package IN1010.prac.v24;

public class Fly  implements Motordrevet{
    private final String id;
    private final int motorAntall;
    private final int MTOW;
    private final int minTrekkraft;
    public Fly neste = null;

    Fly(String id, int motorAntall, int MTOW, int trekkraft) {
        this.id = id;
        this.motorAntall = motorAntall;
        this.MTOW = MTOW;
        minTrekkraft = trekkraft;
    }

    public String hentId() {
        return id;
    }

    public int hentMotorAntall() {
        return motorAntall;
    }

    public int hentMTOW() {
        return MTOW;
    }

    @Override
    public int trekkraft() {
        return minTrekkraft;
    }

    // 4b
    public int finnMaksVekt() {
        if (neste == null) {
            return hentMTOW();
        }
        return Math.max(neste.finnMaksVekt(), hentMTOW());
    }
}
