package com.example.makefood.databox;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Parsing {

    public static void main(String[] args) throws ParseException {

        String path = System.getProperty("user.dir");
        StringBuilder sb = new StringBuilder();

        try (FileReader reader = new FileReader(path + "/src/file/cookData.txt")) {

            char[] bowl = new char[1];

            while (true) {
                int count = reader.read(bowl);

                if (count == -1) {
                    break;
                }

                String text = new String(bowl);
                sb.append(text);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

//        System.out.println(sb);

        JSONParser jsonParser = new JSONParser();

            JSONObject body = (JSONObject)jsonParser.parse(sb.toString());
//            System.out.println(body);

            JSONObject start = (JSONObject) body.get("COOKRCP01");

            JSONArray row = (JSONArray)start.get("row");

            System.out.println(row.size());

//            for(int i = 0; i < row.size(); i++){
//                System.out.println(row.get(i));
//            }

        ArrayList<FoodDTO> FoodList = new ArrayList<>();

        for(int i = 0; i < row.size(); i++) {
            JSONObject food = (JSONObject) row.get(i);

            String foodName = (String) food.get("RCP_NM");
            String foodRecipe = (String) food.get("RCP_WAY2");
            String foodIngredient = (String) food.get("RCP_PARTS_DTLS");
            String foodImage = (String) food.get("ATT_FILE_NO_MAIN");
            String infoWgt = (String) food.get("INFO_WGT");
            String infoEng = (String) food.get("INFO_ENG");
            String infoCar = (String) food.get("INFO_CAR");
            String infoPro = (String) food.get("INFO_PRO");
            String infoFat = (String) food.get("INFO_FAT");
            String infoNa = (String) food.get("INFO_NA");


            FoodDTO menu = new FoodDTO(foodName, foodRecipe, foodIngredient, foodImage, infoWgt, infoEng,infoCar, infoPro, infoFat, infoNa);




            // 음식을 DB에 저장
//            MemberService.insertFood(menu);
        }











    }
}
