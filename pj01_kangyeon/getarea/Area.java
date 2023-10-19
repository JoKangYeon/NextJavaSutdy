package pj01_kangyeon.getarea;

public class Area {
    private int areaNum;
    private String owner;
    private boolean mine;
    protected String shape;

    public Area() {
    }

    public Area(int areaNum) {
        this.areaNum = areaNum;
    }

    public Area(int areaNum, boolean mine, String shape) {
        this.areaNum = areaNum;
        this.mine = mine;
        this.shape = shape;
    }

    public Area(int areaNum, String owner, boolean mine) {
        this.areaNum = areaNum;
        this.owner = owner;
        this.mine = mine;
    }

    public Area(int areaNum, String shape) {
        this.areaNum = areaNum;
        this.shape = shape;
    }

    @Override
    public String toString() {
        return "Area{" +
                "areaNum=" + areaNum +
                ", mine=" + mine +
                ", shape='" + shape + '\'' +
                '}';
    }

    public int getAreaNum() {
        return areaNum;
    }

    public void setAreaNum(int areaNum) {
        this.areaNum = areaNum;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public boolean isMine() {
        return mine;
    }

    public void setMine(boolean mine) {
        this.mine = mine;
    }

    public String getShape() {
        return shape;
    }

    public void setShape(String shape) {
        this.shape = shape;
    }
}
