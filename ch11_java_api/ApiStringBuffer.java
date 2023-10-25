package ch11_java_api;

public class ApiStringBuffer {

    public static void main(String[] args) {
        // 문자열하면? String
        // String을 계속 수정하게 되면 힙 메모리 영역에
        // 매번 새로운 String 객체가 만들어지고,
        // 그로인해 가비지 컬렉터가 할 일도 많아지고 비효율적이다.

        // 문자열을 수정해야하는 경우 StringBuffer와 StringBuilder를
        // 이용하는 것이 권장됨

        // StringBuffer
        StringBuffer strBuff = new StringBuffer();
        System.out.println(strBuff);    // "" 와 같음

        // 문자열 추가
        strBuff.append("안녕하세요");
        System.out.println(strBuff);    // "안녕하세요"와 같음

        // 문자열 비우기
        strBuff = new StringBuffer();

        // 선언할 때 문자열 부여
        strBuff = new StringBuffer("새로 태어남");
        System.out.println(strBuff);

        // StringBuffer 객체 -> String 타입으로 변환
        String result = strBuff.toString();
        System.out.println(result);

        // 랜덤 숫자 10개를 추가
        StringBuilder text = new StringBuilder();
        // 몇초 걸리지?
        // String은 30만 => 4초
        // StringBuffer: 3000만 => 1초
        long startTime = System.currentTimeMillis();
        for(int i = 0; i < 3000000; i++){
            // 0~9 사이의 랜덤 수 생성
            int rand = (int)(Math.random() * 10);
            text.append(rand);
        }
        long endTime = System.currentTimeMillis();
        long diff = endTime - startTime;
        long sec = diff / 1000;
        System.out.println(sec + "초 걸림");

        System.out.println("\n================================================\n");

        // StringBuilder 는 StringBuffer와 사용법이 똑같다.
        StringBuilder strBuild = new StringBuilder();

        strBuild.append("추가");

        strBuild.toString();

        // 둘의 차이점은?
        // StringBuffer는 동기화 지원
        // StringBuilder는 동기화 미지원

        // 동기화를 지원한다?
        // 멀티 쓰레드 환경에서 해당 객체가
        // 모든 쓰레드에서 안정적으로 사용 된다.

        // 동기화를 미지원 StringBuilder
        // 쓰레드가 A, B, C 에서 각각의 쓰레드들이
        // 하나의 StringBuilder 객체를 사용할 때
        // 쓰레드 A가 StringBuilder의 값을 바꾸는 경우
        // 다른 쓰레드 B, C에서 이를 모롤 수 있다.
        // 단일 쓰레드에서는 좀 더 좋은 성능

        // 동기화를 지원하는 StringBuffer
        // 쓰레드 A, B, C 에서 각각의 쓰레드들이
        // 하나의 StringBuffer 객체를 사용할 때
        // 쓰레드 A가 StringBuffer의 값을 바꾸는 경우
        // 다른 쓰레드 B, C에서 이를 안다. (안정적)
        // 단일 쓰레드에서 조금 낮은 성능
















































































    }
}
