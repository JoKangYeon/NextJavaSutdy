package ch05_controll;

public class Conditional {

    static String today = "월요일";

    public static void main(String[] args) {

        // 조건문

        // if문
        int price = 30000;
        int myMoney = 10000;

        // myMoney가 price보다 작으면 "돈이 부족합니다" 문구를 출력
        // 조건 안에는 boolean 타입의 결과가 들어간다.
        // 프로그래밍에서 괄호가 열렸으면 닫히는 부분이 있어야한다
        // if문의 소괄호 안 조건이 true면 중괄호 내부 코드 실행
        // false면 중괄호 내부 코드가 실행되지 않음
        if(myMoney < price){
            System.out.println("돈이 부족합니다.");
        }

        // 괄호만 잘 지키면 한줄로 써도 된다.
        if(myMoney < price){ System.out.println("돈이 부족합니다."); }

        // 중괄호 블록 {} 안 명령어가 한줄뿐이라면
        // 중괄호 블록을 생력할 수 있다.
        if(myMoney < price)
            System.out.println("돈이 부족합니다.");

        System.out.println("\n===========================================\n");

        // 변수의 사용범위(Scope)
        // 증괄호 블록{} 안에 선언된 변수는 (지역 변수)
        // 해당 중괄호 블록{} 밖에서 사용할 수 없다.
        String review = "맛있어요~";
        if (review.length() < 10){
            // warning이 메모리에 등록
            String warning = "리뷰는 10글자 이상 작성해주세요";
        } // 메모리에서 warning은 삭제

        // warning의 존재를 모른다.
//        System.out.println(warning);

        // 전역 변수
        // class 중괄호 블록 안에 선언된 변수
        // 해당 클래스 내 어디서든 사용이 가능하다.
        System.out.println(today);

        // 조건에 따른 변수 값 변화
        // 리뷰 길이가 10글자 이상이면 warning에는 "통과" 담기

        String warning = "통과";
        if(review.length() < 10){
            warning = "리뷰는 10글자 이상 작성해주세요";
        }
        System.out.println(warning);

        // 삼항연산자는 조건에 따른 변수 값 변화시 사용하면 좋다.
       warning = (review.length() < 10) ? ("리뷰는 10글자 이상 작성해주세요") : ("통과");


        System.out.println("\n===========================================\n");

        // else와 else if
        int numZero = 0;

        if(numZero < 0){
            System.out.println("numZero가 0보다 작다");
        }else{
            // 위 if문 조건이 false면 else 내부 코드가 실행
            System.out.println("numZero가 0보다 같거나 크다.");
        }

        // 주민번호 뒷자리의 첫번째 숫자가 홀수면 남성, 짝수면 여성
        int idBack = 1;
        if(idBack % 2 == 1){
            // 홀수
            System.out.println("남성");
        }else{
            // 짝수
            System.out.println("여성");
        }

        numZero = 0;
        if(numZero < 0){
            System.out.println("numZero가 0보다 작다");
        }else if(numZero == 0){
            System.out.println("numZero가 0이다");
        }else{
            System.out.println("numZero가 0보다 크다");
        }

        System.out.println("\n================================================\n");

        // 세상 모든 가전제품에는 프로그래밍 코드가 들어가있다.
        // 리모콘은 전원 버튼하나로 on/of 가 가능하다.

        // isPowerOn은 전원이 켜져있으면 true, 꺼져있으면 false
        boolean isPowerOn = false;

        // 전원버튼 누르기
        if(isPowerOn == false) { //isPowerOn은 true/false 두가지 케이스뿐
            System.out.println("TV를 켭니다");
            isPowerOn = true;
        }else if(isPowerOn = true){
            System.out.println("TV를 끕니다.");
            isPowerOn = false;
        }



        if(!isPowerOn) { //isPowerOn은 true/false 두가지 케이스뿐
            System.out.println("TV를 켭니다");
        }else {
            System.out.println("TV를 끕니다.");
        }
        isPowerOn = !isPowerOn;

        // boolean 타입의 true/false 성징을 마치 스위치의 on/off처럼
        // 사용하는 변수를 토글(toggle) 혹은 플래그(flag) 라고 부른다.

        System.out.println("\n================================================\n");

        // 이중 삼항연산자로 점수에 따른 등급 표현 - > if문으로
        int score = 85;
        String grade = "";

        // if, else if, else 를 이용하여
        // score가 90 이상이면 grade는 "A"
        // score가 80 이상이면 grade는 "B"
        // 나머지 grade는 "C"

        if(score >= 90) {
            grade = "A";
        }else if(score >= 80) {
            grade = "B";
        }else {
            grade = "C";
        }
        System.out.println(grade);

        // 코드라인 줄이기
        grade = "C";
        if(score >= 90) {
            grade = "A";
        }else if(score >= 80) {
            grade = "B";
        }

        // 순서에 유의하거나 범위를 명확히 해야 한다.
        score = 92;
        if(score >= 80) { // && score < 90
            grade = "B";
        }else if (score >= 90) {
            grade = "A";
        }else{
            grade = "C";
        }
        System.out.println(grade); // B가 나와버림 ..

        System.out.println("\n================================================\n");

        // 회원가입 조건체크
        // 이름은 한글자 이상
        // 나이는 14세 이상
        // 휴대폰 번호는 10자리 또는 11자리
        String name = "길똥이";
        int age = 20;
        String phone = "01073987322";

        if(name.length() > 0){

            // 이름 조건 통과
            if(age >= 14){
                // 나이 조건 통과
                if(phone.length() == 10 || phone.length() == 11){
                    // 휴대폰 조건 통과
                    System.out.println("회원가입 성공");
                }else{
                    //후대폰 조건 불통과
                    System.out.println("회원가입 불가");
                }

            }else{
                // 나이 조건 불통과
                System.out.println("회원가입 불가");
            }
        }else{
            // 이름 조건 불통과
            System.out.println("회원가입 불가");
        }

        // 논리연산자를 이용하여 개선
        if(name.length() > 0
                && age >= 14
                && (phone.length() == 10 || phone.length() == 11)){
            System.out.println("회원가입 성공");
        }else{
            System.out.println("회원가입 실패");
        }

        System.out.println("\n================================================\n");

        // switch문
        // 특정 변수에 대한 값이 따라 다른 구문을 실행하는 경우 사용

        // 교육기간(단위: 월)
        int month = 2;

        if(month == 0){
            System.out.println("자바, DB 배우는 중");
        }else if(month == 1){
            System.out.println("자바, 화면구현 배우는 중");
        }else if(month == 2){
            System.out.println("자바FX 프로젝트(우웩)");
        }else if(month == 3){
            System.out.println("JSP-스프링, SPA 배우는 중");
        }else if(month == 4) {
            System.out.println("팀 프로젝트 하는중");
        }else{
            System.out.println("취업, 수료");
        }

        // 위의 if문을 switch문으로 변경
        // switch() 소괄호 안에 변수를 넣는다
        switch(month){
            case 0:
                System.out.println("자바, DB 배우는 중");
                break;  //이후 나머지 case 내용이 실행되지 않도록 막아준다.
            case 1:
                System.out.println("자바, 화면구현 배우는 중");
                break;
            case 2:
                System.out.println("자바FX 프로젝트(우웩)");
                break;
            case 3:
                System.out.println("JSP-스프링, SPA 배우는 중");
                break;
            case 4:
                System.out.println("팀 프로젝트 하는중");
                break;
            default:    //if문의 else에 해당
                System.out.println("취업, 수료");
            break;
        }

        // month에 대한 계절을 출력해주는 switch문 만들어보기
        month = 9;
        switch(month){
            case 12:
            case 1:
            case 2:
                System.out.println("겨울");
                break;
            case 3:
            case 4:
            case 5:
                System.out.println("봄");
                break;
            case 6:
                break;
            case 7:
                break;
            case 8:
                System.out.println("여름");
                break;
            default:
                System.out.println("가을");
                break;
        }







    }




}
