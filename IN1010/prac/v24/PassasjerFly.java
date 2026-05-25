// 2
package IN1010.prac.v24;

public class PassasjerFly extends MotorFly{
    private final int maksPassasjerer;

    PassasjerFly(String id, int motorAntall, int MTOW, int trekkraft, int passasjerer) {
        super(id,motorAntall,MTOW,trekkraft);
        maksPassasjerer = passasjerer;
    }
}
