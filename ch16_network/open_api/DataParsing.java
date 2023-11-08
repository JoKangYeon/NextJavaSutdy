package ch16_network.open_api;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class DataParsing {

    public static void main(String[] args) throws FileNotFoundException, ParseException {
        String path = System.getProperty("user.dir");
        StringBuilder sb = new StringBuilder();

        try(FileReader reader = new FileReader(path  + "/src/files/mediData.txt")){

            char[] bowl = new char[1];

            while (true){
                int count = reader.read(bowl);

                if(count == -1){
                    break;
                }

                String text = new String(bowl);
                sb.append(text);
            }




        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println(sb);

        JSONParser jsonParser = new JSONParser();

        JSONObject body = (JSONObject)jsonParser.parse(sb.toString());

        System.out.println(body);

        JSONArray items = (JSONArray)body.get("items");

        System.out.println(items.size());

//        MedicineService medicineService = MedicineService.getInstance();

       /* for(int i = 0; i < items.size(); i++) {
            JSONObject item = (JSONObject) items.get(i);

            String entpName = (String) item.get("entpName");
            String itemName = (String) item.get("itemName");
            String efcyQesitm = (String) item.get("efcyQesitm");

            MedicineDTO medicine = new MedicineDTO(entpName, itemName, efcyQesitm);

            // 100개의 약들을 데이터베이스에 저장
            MedicineService.insertMedicine(medicine);

            // ConnectionPool 이 있기에 반복문에 DB통신 코드를 박아도 괜찮음
            // 만약 ConnectionPool이 없었다면 -> Thread.sleep(10)으로 실행시간에 텀을 준다.

        }*/

        Scanner scan = new Scanner(System.in);

        System.out.println("증상을 말해주세요 [종료 : q]");
        System.out.print(">>> ");
        String a = scan.nextLine();

        ArrayList<MedicineDTO> medicineDTOList = MedicineService.getInstance().getMedicineList(a);
        for(int i = 0; i < medicineDTOList.size(); i++){
            System.out.println(medicineDTOList.get(i).getItemName());
        }









    }
}
