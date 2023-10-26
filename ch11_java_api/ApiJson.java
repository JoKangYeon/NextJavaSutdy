package ch11_java_api;

import ch09_class.school.Student;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.util.ArrayList;
import java.util.Arrays;

public class ApiJson {

    public static void main(String[] args) throws ParseException {
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
        System.out.println(jsonObject);

        // JSON 객체는 내부에 Key와 Value 쌍으로 구성된 데이터를 가진다.
        // HashMap<String, Object> 와 유사하다.

        // 데이터 추가

        jsonObject.put("name", "아이유");
        System.out.println(jsonObject);
        jsonObject.put("age", 30);
        System.out.println(jsonObject);

        // 데이터 수정
        jsonObject.put("age", 31);
        System.out.println(jsonObject.toString());

        // Value(값)에 배열 넣기
        // ArrayList와 사용법이 같음
        JSONArray jsonArray = new JSONArray();
        System.out.println(jsonArray);

        jsonArray.add("좋은날");
        jsonArray.add("블루밍");
        jsonArray.add("레옹");
        jsonArray.add(100); //  JSONArray 또한 타입에 자유롭다.
        System.out.println(jsonArray);

        jsonObject.put("songList", jsonArray);
        System.out.println(jsonObject);
        System.out.println(jsonObject.toString());  // String 리턴
        System.out.println(jsonObject.toJSONString());  // String 리턴

        // Value에 JSON 객체 추가
        JSONObject taeyeon = new JSONObject();
        taeyeon.put("name", "태연");
        taeyeon.put("age",34);
        JSONArray songs = new JSONArray();
        songs.add("만약에");
        songs.add("INVU");
        songs.add("사계");

        taeyeon.put("songs", songs);

        // json parser 사이트
        jsonObject.put("태연", taeyeon);
        System.out.println(jsonObject);

        // Key에 대한 Value 꺼내보기
        System.out.println(jsonObject.get("name"));
        // .get으로 꺼낼 시 Object 타입으로 리턴됨
        String name = (String)jsonObject.get("name");
        System.out.println(name);

        int age = (Integer)jsonObject.get("age");
        System.out.println(age);

        JSONArray iuSongs = (JSONArray)jsonObject.get("songList");
        System.out.println(iuSongs);
        for(int i = 0; i < iuSongs.size();i++){
            System.out.println(iuSongs.get(i));
        }
        JSONObject ty = (JSONObject)jsonObject.get("태연");
        String tyName = (String)ty.get("name");
        System.out.println(tyName);

        System.out.println("\n=========================================\n");

        // 서버로 부터 JSON string 을 받았다면
        String serverResponse = "{\"name\":\"아이유\",\"songList\":[\"좋은날\",\"블루밍\",\"레옹\",100],\"age\":31,\"태연\":{\"songs\":[\"만약에\",\"INVU\",\"사계\"],\"name\":\"태연\",\"age\":34}}\n";

        System.out.println(serverResponse);

        // String 을 JSON 객체로 변환해야 Key에 대한 Value를 꺼낼 수 있다.
        // String -> JSON 을 위해 JSONParser 객체 생성
        JSONParser jsonParser = new JSONParser();

        JSONObject jsonResponse =(JSONObject)jsonParser.parse(serverResponse);
        System.out.println(jsonResponse);

        // Key를 이용하여 Value를 꺼내보기
        JSONObject tyResp = (JSONObject)jsonResponse.get("태연");
        System.out.println(tyResp);

        // tyResp 안에 있는 INVU 출력해보기
        JSONArray tyList = (JSONArray)tyResp.get("songs");
        for(int i = 0; i < tyList.size(); i++){
            if(tyList.get(i).equals("INVU")){
                System.out.println(tyList.get(i));
            }
        }

        System.out.println("\n=========================================\n");

        // GSON 라이브러리

        // JsonObject 객체 생성
        JsonObject gsonObj = new JsonObject();
        System.out.println(gsonObj);

        // 값 추가
        gsonObj.addProperty("name", "아이유");
        gsonObj.addProperty("age", 31);
        System.out.println(gsonObj);

        // JsonObject -> String 변환
        String gsonStr = gsonObj.toString();
        System.out.println(gsonStr);

        // GSON 객체 생성
        Gson gson = new Gson();

        // GsonBuilder로 Gson 객체 생성
        GsonBuilder gsonBuilder =new GsonBuilder();
        Gson gson2 = gsonBuilder.create();

        // 몇몇 설정을 추가한 상태로 Gson 객체를 만들 수 있다.
        Gson gsonPretty = gsonBuilder.setPrettyPrinting().create();

        // Gson 객체를 이용한 toString
        String gStr = gson.toJson(gsonObj);
        System.out.println(gStr);
        String pStr = gsonPretty.toJson(gsonObj);
        System.out.println(pStr);
        System.out.println(gsonPretty.toJson(jsonObject));

        // 여기까지는 JSON Simple 라이브러리와 별 차이없음
        Student stu = new Student("호빵맨", 98, 67,32);

        // 자바 객체를 Json String으로 변환
        // = 직렬화(Serialization)
        String stuStr = gson.toJson(stu);
        System.out.println(stuStr);

        // 배열을 Json String으로 변환
        String[] stuArray = {"호빵맨", "찐빵맨", "식빵맨"};
        String strArr = gson.toJson(stuArray);
        System.out.println(strArr);

        // 리스트를 Json String으로 변환
        ArrayList<String> stuList = new ArrayList<>(Arrays.asList("호빵", "찐빵", "식빵"));
        String strList = gson.toJson(stuList);
        System.out.println(strList);

        ArrayList<Student> students = new ArrayList<>();
        students.add(new Student("호빵",90,80,90));
        students.add(new Student("찐빵",30,80,40));
        students.add(new Student("식빵",70,60,50));
        String strStu = gson.toJson(students);
        System.out.println(strStu);

        // Json String인 stuStr -> Student 객체롤 변환하기
        // = 역직렬화(Deserialization)
        // 이와 같은 역직렬화를 위해 스프링 프레임워크에서 jackson 라이브러리를 이용하는
        // 경우도 많다.
        Student comeback = gson.fromJson(stuStr, Student.class);
        System.out.println(comeback);










    }
}
