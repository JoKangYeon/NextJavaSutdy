package ch11_java_api;

import org.json.simple.JSONObject;

public class ApiJson {

    public static void main(String[] args) {
        // JSON 객체란?
        // JavaScript Object Notation
        // 자바스크립트에서의 객체

        // 자바에서의 객체
        // Student -> name, kor, eng, math, avg
        // Student hodong = new Student("호동이", 90, 80 ,70, 80)
        // Student horang = new Student("호랑이", 90, 80 ,70, 80)
        // Student hodol = new Student("호돌이", 90, 80 ,70, 80)

        // JSON이라면
        // let hodong = { name : "호동이", kor : 90, eng : 80, math : 70, avg : 80}
        // let horang = { name : "호랑이", kor : 90, eng : 80, math : 70, avg : 80}
        // let hodol = { name : "호돌이", kor : 90, eng : 80, math : 70, avg : 80}

        // 자바라면
        // hodong.getName(); , hodong.name => "호동이"

        // 자바스크립트라면
        // hodong.name -> "호동이"

        // 클라이언트와 서버간 데이터 통신

        // 자바에서 JSON 객체를 생성하고, JSON String 으로 변환하기 -> 서버에 요청가능
        // 자바에서 JSON String 을 JSON 객체로 변환하기 -> 응답 데이터를 사용할 수 있음

        // 위 두가지를 가능하게 하는 라이브러리를 가지고 와야 한다.
        // maven repository 에서 json simple 검색해서 .jar 파일 다운로드

        // .jar 파일을 프로젝트 내부에서 불러올 수 있도록 설정
        // Menu - Project Structure - Libraries 에서 추가
        JSONObject jsonObject = new JSONObject();




















    }
}
