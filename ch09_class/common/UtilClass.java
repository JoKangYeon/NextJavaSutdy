package ch09_class.common;

// 유용한 함수들을 제공하는 클래스
public class UtilClass {

    /**
     * 입력한 소수를 소수 n번째 자리로 반올림하여 리턴해주는 함수
     * @param num 반올림하고자 하는 소수
     * @param n 소수 n번째 자리를 지정하는 정수
     * @return 반올림 된 소수 리턴
     */
    public static double myRound(double num, int n){

        // num 에 10^n 곱한 후 Math.round()를 적용한 값에
        // 10^n 나누기
        int random = 1;
        for(int i = 0; i < n; i++){
            random *= 10;
        }
        return (double)(Math.round(num * random)) / random;
    }

}
