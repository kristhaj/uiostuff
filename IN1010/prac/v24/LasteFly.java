// 2
package IN1010.prac.v24;

public class LasteFly extends MotorFly{
    private final int maksLast;

    LasteFly(String id, int motorAntall, int MTOW, int trekkraft, int lastevekt) {
        super(id,motorAntall,MTOW,trekkraft);
        maksLast = lastevekt;
    }
}
