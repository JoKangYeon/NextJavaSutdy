package ch10_extends_interface.starcraft;

public class HighTemplar extends StarUnit{

    private int shield;
    private int mp;
    private int gas;

    public HighTemplar() {
        super("하이템플러", 0, 40, 0, 0, 0, 1, 50);
        this.shield = shield;
        this.mp = mp;
        this.gas = gas;
    }

    // 사이오닉 스톰
    public void psionicStorm(){
        System.out.println("파지지지직!!");
        this.mp -= 75;
    }

    // 할루시네이션
    public void hallucination(){
        System.out.println("분신 소환!!");
        this.mp -= 100;
    }

    @Override
    public String toString() {
        return "HighTemplar{" +
                "name='" + getName() + '\'' +
                ", damage=" + getDamage() +
                ", hp=" + getHp() +
                ", shield=" + shield +
                ", armor=" + getArmor() +
                ", attackRange=" + getAttackRange() +
                ", attackSpeed=" + getAttackSpeed() +
                ", moveSpeed=" + getMoveSpeed() +
                ", mineral=" + getMineral() +
                ", mp=" + mp +
                ", gas=" + gas +
                '}';
    }



    public int getShield() {
        return shield;
    }

    public void setShield(int shield) {
        this.shield = shield;
    }

    public int getMp() {
        return mp;
    }

    public void setMp(int mp) {
        this.mp = mp;
    }

    public int getGas() {
        return gas;
    }

    public void setGas(int gas) {
        this.gas = gas;
    }
}
