package submit05;

public class Submit05 {

    public static void main(String[] args) {


        makeTree(5);
        makeTree(7);

        String example = "로꾸꺼 로꾸꺼";
        String result = reverseStr(example);
        System.out.println(result);

        String myBinaryStr = makeBinary(23);
        System.out.println(myBinaryStr);











    }
    public static void makeTree(int num){

        for(int i = 0; i < num; i++){
            // i=0 공백이 4칸 *은 1개
            // i=1 공백이 3칸 *은 3개
            // i=2 공백이 2칸 *은 5개  (i에 2를 곱한 후 1을 더함)

            String blank = "";
            for(int k = 0; k < num - i; k++){
                blank += " ";
            }

            String stars = "";
            for (int j = 0; j  < (i*2)+1 ; j++){
                stars += "*";

            }
            System.out.println(blank + stars);
        }
    }

    public static String reverseStr(String word){
        String subword = "";
        for(int i = word.length(); i > 0; i = i-1){
            subword += word.substring(i - 1, i);
        }
        return  subword;
    }

    public static String makeBinary(int num) {
        String word = ""; // 빈 문자열 선언
        // num을 2진수로 바꾸기

        while(true){

            word = word + (num % 2);  //나머지를 word에 더하기
            num = num / 2;
            if(num == 1){
                break;
            }
            String reverseWord = "";
        for(int i = word.length(); i > 0; i = i-1){
            reverseWord += word.substring(i - 1, i);
            }

        }
//        return"1" + reverseWord;
    }














}
