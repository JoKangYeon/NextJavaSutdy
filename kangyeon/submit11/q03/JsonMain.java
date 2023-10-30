package kangyeon.submit11.q03;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class JsonMain {

    public static void main(String[] args) {

        String resp = "{\"success\": true, \"timeseries\": true, \"base\": \"USD\", \"start_date\": \"2020-08-01\"," +
                " \"end_date\": \"2022-08-01\", \"rates\": {\"2020-08-01\": {\"JPY\": 105.65, \"KES\": 107.57," +
                " \"KGS\": 76.52, \"KHR\": 4092.64, \"KMF\": 417.5, \"KPW\": 898.38, \"KRW\": 1192.25}," +
                " \"2020-08-02\": {\"JPY\": 105.74, \"KES\": 107.69, \"KGS\": 76.62, \"KHR\": 4100," +
                " \"KMF\": 418.06, \"KPW\": 899.58, \"KRW\": 1193.46}}}";

        // 2020년 8월 2일의 한국 환율(KRW) 값 꺼내기

        JsonParser jsonParser = new JsonParser();

        // resp를 JsonObject로 변환
        JsonObject rate = (JsonObject)jsonParser.parse(resp);
        System.out.println(rate);

        // Key를 통한 값꺼내기 -> rates
        JsonObject augustRate = (JsonObject) rate.get("rates");

        System.out.println(augustRate);

        // Key를 통한 값꺼내기 -> 2020-08-02
        JsonObject augustRate2 = (JsonObject)augustRate.get("2020-08-02");
        System.out.println(augustRate2);
        // 접근한 상태에서 KRW의 value찾기
        System.out.println(augustRate2.get("KRW"));














































    }
}
