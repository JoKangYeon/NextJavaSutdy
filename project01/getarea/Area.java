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
        String state = "점령지번호: " + areaNum +
                ", 오너: " + owner +
                ", 지뢰여부: 안전" +
                ", 지역모양: " + shape;
        if(mine == true){
            state = "점령지번호: " + areaNum +
                    ", 오너: " + owner +
                    ", 지뢰여부: 지뢰" +
                    ", 지역모양: " + shape;
        }
        return state;
    }

    /*public String toMakeString() {
        String state = green + "⏹" + exit;
        if(mine == true){
            state = red +"☢" +exit;
        }
        return state;
    }*/

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

//    public static final String black    = "\u001B[30m" ;
//    public static final String red      = "\u001B[31m" ;
//    public static final String green    = "\u001B[32m" ;
//    public static final String yellow   = "\u001B[33m" ;
//    public static final String blue     = "\u001B[34m" ;
//    public static final String purple   = "\u001B[35m" ;
//    public static final String cyan     = "\u001B[36m" ;
//    public static final String white     = "\u001B[37m" ;
//
//    public static final String exit     = "\u001B[0m" ;



}
