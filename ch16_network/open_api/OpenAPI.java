package ch16_network.open_api;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileWriter;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.io.BufferedReader;
import java.io.IOException;

public class OpenAPI {

    public static void main(String[] args) throws IOException, ParseException {
        // 요청 url 생성
        StringBuilder urlBuilder = new StringBuilder("http://apis.data.go.kr/1471000/DrbEasyDrugInfoService/getDrbEasyDrugList"); /*URL*/
        urlBuilder.append("?" + URLEncoder.encode("serviceKey", "UTF-8") + "=" + "kPToYfbfLh1lRNrHrB8sCwIr89RwKFZfgVAvDb7tPXwqJ1rAFRHTTnx1jNTBkiAJxKBCsW%2FS9WLJwegn6gWYdg%3D%3D"); /*Service Key*/
        urlBuilder.append("&" + URLEncoder.encode("pageNo", "UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*페이지번호*/
        urlBuilder.append("&" + URLEncoder.encode("numOfRows", "UTF-8") + "=" + URLEncoder.encode("100", "UTF-8")); /*한 페이지 결과 수*/
        urlBuilder.append("&" + URLEncoder.encode("type", "UTF-8") + "=" + URLEncoder.encode("json", "UTF-8")); /*응답데이터 형식(xml/json) Default:xml*/

        // 위에서 작성한 url 주소를 가지는 URL 객체 생성
        URL url = new URL(urlBuilder.toString());

        // url 주소에 대한 연결
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();

        // 연결 요청 방식 (GET/POST)
        conn.setRequestMethod("GET");

        // 연결 요청시 데이터 타입(json)
        conn.setRequestProperty("Content-type", "application/json");

        // 요청에 대한 응답 코드 확인
        System.out.println("Response code: " + conn.getResponseCode());
        BufferedReader rd;
        // 응답이 정상인지 확인 (응답 코드가 200번대)
        if (conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
            // BufferedReader 에 응답 데이터 담음
            rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        } else {
            rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
        }
        StringBuilder sb = new StringBuilder();
        String line;
        // BufferedReader에 기록된 데이터를 한줄씩(\n 기준)
        // line에 담아 StringBuilder에 추가
        while ((line = rd.readLine()) != null) {
            sb.append(line);
        }
        rd.close();
        conn.disconnect();

        // 최종적으로 응답데이터가 담겨있는 StringBuilder 내용 출력
        System.out.println(sb.toString());

        // JSON String 이므로 JSON 객체로 parsing 해주기
        JSONParser jsonParser = new JSONParser();
        JSONObject jsonResp = (JSONObject) jsonParser.parse(sb.toString());

        System.out.println(jsonResp);

        JSONObject body = (JSONObject) jsonResp.get("body");
        System.out.println(body);

        // 매너상 서버에 불필요한 요청을 지속적으로 보내는 것은 좋지않다.
        // 현재의 응답 데이터를 로컬에 저장하도록 한다.
        String path = System.getProperty("user.dir");
        try(FileWriter writer = new FileWriter(path  + "/src/files/mediData.txt")){
            writer.write(body.toString());
        }









    }
}
