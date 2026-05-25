// 2

package IN1010.prac.v24;

public class SeilFly extends Fly{
    private final int  minSynk;
    
    SeilFly(String id, int motorAntall, int MTOW, int synkehastighet, int trekkraft) {
        super(id,motorAntall,MTOW, trekkraft);
        minSynk = synkehastighet;
    }
}
