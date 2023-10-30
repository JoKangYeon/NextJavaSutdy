package kangyeon.review.review01.q01;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Q01 {

    public static void main(String[] args)  {

        String response = "{ \"city\" : [\"서울\", \"광주\", \"대구\", \"대전\", \"부산\", \"울산\", " +
                "\"인천\"], \"fields\": [{\"id\": \"자장면\"},{\"id\": \"냉면\"}, {\"id\": \"김밥\"}," +
                " {\"id\": \"칼국수\"}], \"records\": [{\"시도명\": \"서울\", \"자장면\": 7069, " +
                "\"냉면\": 11308, \"김밥\": 3215, \"칼국수\": 8962}, {\"시도명\": \"광주\", \"자장면\": 6800, " +
                "\"냉면\": 9400, \"김밥\": 3160, \"칼국수\": 8400}, {\"시도명\": \"대구\", \"자장면\": 6250, \"냉면\": 10417, \"김밥\": 2750, " +
                "\"칼국수\": 6750}, { \"시도명\": \"대전\", \"자장면\": 6700, \"냉면\": 10400, \"김밥\": 3000, " +
                "\"칼국수\": 7800}, {\"시도명\": \"부산\", \"자장면\": 6143, \"냉면\": 10857, \"김밥\": 2786," +
                " \"칼국수\": 6986}, { \"시도명\": \"울산\", \"자장면\": 6500, \"냉면\": 9900, \"김밥\": 3300, " +
                "\"칼국수\": 8400}, {\"시도명\": \"인천\", \"자장면\": 6500, \"냉면\": 10667, \"김밥\": 3050, \"칼국수\": 8000}]}";



        // 냉면값이 가장 저렴한 곳과 그 가격 확인

        // JSONParser 소환
        JSONParser jsonParser = new JSONParser();

        // response을 JSONObject로 변환
        JSONObject list = null;
        try {
            list = (JSONObject) jsonParser.parse(response);
        } catch (ParseException e) {

        }

        // 도시목록확인
        JSONArray city = (JSONArray) list.get("city");
        System.out.println(city);

        // 매뉴확인
        JSONArray fields = (JSONArray) list.get("fields");
        System.out.println(fields);

        // 자료확인
        JSONArray records = (JSONArray) list.get("records");
        System.out.println(records);

        System.out.println("\n===============================================\n");

    /*    // 가장 저렴한 냉면가격과 도시 찾기 (버블정렬)
        for(int k = 0; k < records.size() - 1; k++){
            for(int i = 0; i < records.size() - 1; i++){
                JSONObject getObject = (JSONObject) records.get(i);
                JSONObject getObject2 = (JSONObject) records.get(i+1);
                if((long)getObject.get("냉면") > (long)getObject2.get("냉면")){
                    JSONObject temp = getObject;
                    records.set(i, records.get(i+1));
                    records.set(i+1, temp);
                }
            }
        }

        // 냉면이 가장 저렴한 곳과 가격
        System.out.println(records.get(0));*/

        long minPrice = (long)((JSONObject)records.get(0)).get("냉면");
        for(int i = 0; i < records.size(); i++){
            JSONObject getObject = (JSONObject) records.get(i);
            if(minPrice > (long)getObject.get("냉면")){
                minPrice = (long)getObject.get("냉면");
            }
        }
        System.out.println("냉면 최소값: " + minPrice);

        for(int i = 0; i < records.size(); i++){
            JSONObject getObject = (JSONObject) records.get(i);
            if(minPrice == (long)getObject.get("냉면")){
                System.out.println("냉면이 가장 저렴한 도시: " + getObject.get("시도명"));
            }
        }



        System.out.println("\n===============================================\n");

        // 7개 도시 자장면 평균 가격
        long sum = 0;
        for(int i = 0; i < records.size(); i++){
            JSONObject getObject = (JSONObject) records.get(i);
            sum += (long)getObject.get("자장면");
        }

        System.out.println("7개 도시 자장면 평균 가격: " + sum / 7 + "원");


        System.out.println("\n===============================================\n");




























    }
}
