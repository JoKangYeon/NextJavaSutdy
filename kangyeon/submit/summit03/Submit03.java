package summit03;

public class Submit03 {

    public static void main(String[] args) {

        // for문을 사용해서 10팩토리얼의 값을 출력해주세요

        int a = 1;
        for(int i = 1; i <= 10; i++){
            System.out.println(i);
            a = a * i;
        }
        System.out.println(a);

        // 15 팩토리얼의 값을 출력해주세요.

        long b = 1l;
        for(int i = 1; i <= 15; i++){
            System.out.println(i);
            b = i * b;
        }
        System.out.println(b);

        /* 월리를 찾아라!!

        아래의 문자열 변수 findWally 중에 월리가 몇개 들어있는지 콘솔에 출력해주세요.

        String findWally = "윌리울리일리울리울리일리월리일리윌리월리울리일리일리월리일리윌리일리윌리일리월리월리윌리울리윌리울리일리울리울리윌리일리";
*/
        System.out.println("\n=================================================\n");

        String findWally = "윌리울리일리울리울리일리월리일리윌리월리울리일리일리월리일리윌리일리윌리일리월리월리윌리울리윌리울리일리울리울리윌리일리";
        String wally = "";
        int count = 0;
        for(int i = findWally.length(); i >= 2; i -= 2){
            wally = findWally.substring(i - 2, i);
            System.out.println(wally);
            if(wally.equals("월리")){
                System.out.println(wally);
                count += 1;
            }
        }
        System.out.println(count);

        System.out.println("\n=================================================\n");

//        String stars = "*****";
//        for문을 5번 반복하면서 stars를 아래와 같이 나오도록 잘라서 출력해보세요


        String stars = "*****";
        String s = "";
        for(int i = 5; i >= 1; i -= 1){
            s = stars.substring(0, i);
            System.out.println(s);
        }


        // 로꾸꺼 로꾸꺼

        String text = "로꾸꺼 로꾸꺼";
        String sub = "";
        String ha = "";
        String q = "";
        String w = "";

        for(int i = 0; i < 7; i++){
            sub = text.substring(i, i + 1);
            ha += sub;
        }
        System.out.println(ha);

        for(int i = text.length(); i > 0; i--) {
            q = text.substring(i - 1, i);
            w += q;
        }
        System.out.println(w);



//        for(int i = 0 ; i < text.length(); i++) {
//            q = text.substring(9 - i , 10 - i);
//            w += q;












    }
}
