package ch10_extends_interface.starcraft;

// 객체들을 여러개 만드는 과정에서 각 객체들이
// 중복된 필드변수나 메소드를 가지고 있는 경우
// 이들을 묶어줄 수 있는 클래스를 하나 만든다.
public class StarUnit {
    private String name;
    private int damage;
    private int hp;
    private int armor;
    private int attackRange;
    private int attackSpeed;
    private int moveSpeed;
    private int mineral;

    public StarUnit() {
    }

    public StarUnit(String name, int damage, int hp, int armor, int attackRange, int attackSpeed, int moveSpeed, int mineral) {
        this.name = name;
        this.damage = damage;
        this.hp = hp;
        this.armor = armor;
        this.attackRange = attackRange;
        this.attackSpeed = attackSpeed;
        this.moveSpeed = moveSpeed;
        this.mineral = mineral;
    }

    // 이동
    public void move(int x, int y){
        System.out.println(x + ", " + y +  "로 이동");
    }














    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getArmor() {
        return armor;
    }

    public void setArmor(int armor) {
        this.armor = armor;
    }

    public int getAttackRange() {
        return attackRange;
    }

    public void setAttackRange(int attackRange) {
        this.attackRange = attackRange;
    }

    public int getAttackSpeed() {
        return attackSpeed;
    }

    public void setAttackSpeed(int attackSpeed) {
        this.attackSpeed = attackSpeed;
    }

    public int getMoveSpeed() {
        return moveSpeed;
    }

    public void setMoveSpeed(int moveSpeed) {
        this.moveSpeed = moveSpeed;
    }

    public int getMineral() {
        return mineral;
    }

    public void setMineral(int mineral) {
        this.mineral = mineral;
    }
}
