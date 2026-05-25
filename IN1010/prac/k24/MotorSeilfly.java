// 2
class MotorSeilfly extends Seilfly implements Motordrevet {
    final int minTrekkraft;
    final String minMotortype;

    MotorSeilfly(String id, int glidetall, int vingespenn, int trekkraft, String motortype) {
        super(id,glidetall,vingespenn);
        minTrekkraft = trekkraft;
        minMotortype = motortype;
    }

    public int trekkraft() {
        return minTrekkraft;
    }

    public String motortype() {
        return minMotortype;
    }
}