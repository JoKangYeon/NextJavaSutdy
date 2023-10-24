package ch09_class.school;

import ch09_class.common.UtilClass;

public class Student {
    // 필두변수를 private으로 두고
    // 필드변수에 대해 Getter, Setter를 만드는 행위
    // 캡슐화 (Encapsulation) => 국룰

    private String name;
    private int kor;
    private int eng;
    private int math;
    private double avg;

    // 값을 입력받는 생성자
    // 단축키 {Alt + Insert] - constructor
    // 접근제어자
    // public : 해당 필수변수, 메소드, 생상자를 다른 패키지(폴더)에서 사용 가능
    // private : 현재 파일 내에서만 사용 가능
    // (default) : 접근 제어자 기입안한 상태, 같은 패키지 내에서만 사용 가능
    // protected : 같은 패키지 내에서만 사용 가능


    public Student(String name, int kor, int eng, int math) {
//        this.name = name;
//        this.kor = kor;
//        this.eng = eng;
//        this.math = math;
//        this.avg = (kor + eng + math) / 3.0;
        this(name, kor, eng, math, (kor + eng + math) / 3.0);
    }

    public Student(){
    }

    public Student(String name, int kor, int eng, int math, double avg) {
        this.name = name;
        this.kor = kor;
        this.eng = eng;
        this.math = math;
        calAvg();
    }

    @Override
    public String toString() {
        return name + ", 국어:" + kor +
                ", 영어" + eng +
                ", 수학" + math +
                ", 평균 = " + avg;
    }

    // 값을 넘겨주는 메소드
    public int getMath(){
        return this.math; // math도 된다
    }

    // kor, eng, math로부터 평균을 계산하여 avg에 적용 메소드
    private void calAvg(){
        this.avg = UtilClass.myRound((kor + eng + math) / 3.0, 2);
    }


    // 값을 수정하는 메소드
    public void setMath(int math){
        this.math = math;
        this.avg = (kor + eng + math) / 3.0;
    }

    // private 인 필드변수에 대한 get메소드 set메소드를
    // Getter Setter 라고 부른다.
    // [Alt + Insert] 를 이용하여 자동으로 만들 수 있다.


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        calAvg();
    }

    public int getKor() {
        return kor;
    }

    public void setKor(int kor) {
        this.kor = kor;
        calAvg();
    }

    public int getEng() {
        return eng;
    }

    public void setEng(int eng) {
        this.eng = eng;
        calAvg();
    }

    public double getAvg() {
        return avg;
    }



}
