package ch10_extends_interface.starcraft;

public class Zealot extends StarUnit{

    private int shield;

    public Zealot() {
        super("질럿", 16, 100, 1, 1, 1, 1, 100);
        this.shield = 60;
    }

    @Override
    public String toString() {
        return "Zealot{" +
                "name='" + getName() + '\'' +
                ", damage=" + getDamage() +
                ", hp=" + getHp() +
                ", shield=" + shield +
                ", armor=" + getArmor() +
                ", attackRange=" + getAttackRange() +
                ", attackSpeed=" + getAttackSpeed() +
                ", moveSpeed=" + getMoveSpeed() +
                ", mineral=" + getMineral() +
                '}';
    }

    public int getShield() {
        return shield;
    }

    public void setShield(int shield) {
        this.shield = shield;
    }


}
