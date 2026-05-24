// 2
class MotorSeilfly implements Motordrevet extends Seilfly {
    final int minTrekkraft;
    final String minMotortype;

    MotorSeilfly(String id, int glidetall, int vingespenn, int trekkraft, String motortype) {
        super(id,glidetall,vingespenn);
        this.trekkraft = trekkraft;
        this.motortype = motortype;
    }

    public int trekkraft() {
        return trekkraft;
    }

    public String motortype() {
        return motortype;
    }
}