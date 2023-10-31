package ch13_thread;

public class MakeString {

    public static void main(String[] args) {
        // 문자열을 아주 길~~~게 만들기

        // 동기화 지원
        // 스레드 A가 strBuff를 건드리면 스레드B랑 C가 이를 안다.
        StringBuffer strBuff = new StringBuffer();

        // 동기화 미지원
        // 스레드 A가 strBuild를 건드리면 스레드 B, C가 이를 모를수도 있다.
        StringBuilder strBuild = new StringBuilder();

        Thread threadA = new Thread(()->{
            for(int i = 0; i < 50000000; i++){
                strBuild.append((int)(Math.random()*10));
            }
            System.out.println(strBuild.length());
        });
        threadA.start();

        Thread threadB = new Thread(()->{
            for(int i = 0; i < 50000000; i++){
                strBuild.append((int)(Math.random()*10));
            }
            System.out.println(strBuild.length());
        });
        threadB.start();











    }
}
