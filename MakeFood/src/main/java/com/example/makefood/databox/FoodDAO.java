package com.example.makefood.databox;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class FoodDAO {
    // 싱글톤 적용
    private FoodDAO(){
    }
    private static FoodDAO instance = new FoodDAO();
    public static FoodDAO getInstance(){
        return instance;
    }

    // 음식 데이터 추가(INSERT)

    public int insertFood(Connection conn, FoodDTO foodDTO) throws SQLException {
        StringBuffer query = new StringBuffer();
        query.append("INSERT INTO                  ");
        query.append("         Foods (             ");
        query.append("         food_name           ");
        query.append("       , food_recipe         ");
        query.append("       , food_ingredient     ");
        query.append("       , food_image          ");
        query.append("       , info_wgt            ");
        query.append("       , info_eng            ");
        query.append("       , info_car            ");
        query.append("       , info_pro            ");
        query.append("       , info_fat            ");
        query.append("       , info_na             ");
        query.append("       ) VALUES (            ");
        query.append("          ?                  ");
        query.append("       ,  ?                  ");
        query.append("       ,  ?                  ");
        query.append("       ,  ?                  ");
        query.append("       ,  ?                  ");
        query.append("       ,  ?                  ");
        query.append("       ,  ?                  ");
        query.append("       ,  ?                  ");
        query.append("       ,  ?                  ");
        query.append("       ,  ?                  ");
        query.append("       )                     ");


        PreparedStatement ps = conn.prepareStatement(query.toString());

        int idx = 1;
        ps.setString(idx++, foodDTO.getFoodName());
        ps.setString(idx++, foodDTO.getFoodRecipe());
        ps.setString(idx++, foodDTO.getFoodIngredient());
        ps.setString(idx++, foodDTO.getFoodImage());
        ps.setString(idx++, foodDTO.getInfoWgt());
        ps.setString(idx++, foodDTO.getInfoEng());
        ps.setString(idx++, foodDTO.getInfoCar());
        ps.setString(idx++, foodDTO.getInfoPro());
        ps.setString(idx++, foodDTO.getInfoFat());
        ps.setString(idx++, foodDTO.getInfoNa());

        int result = ps.executeUpdate();

        ps.close();

        return result;

    }

    // 음식 보기
    public ArrayList<FoodDTO> showFood(Connection conn, String food) throws SQLException {
        StringBuffer query = new StringBuffer();
        query.append("SELECT                           ");
        query.append("         food_name               ");
        query.append("       , food_recipe             ");
        query.append("       , food_ingredient         ");
        query.append("       , food_image              ");
        query.append("       , info_wgt                ");
        query.append("       , info_eng                ");
        query.append("       , info_car                ");
        query.append("       , info_pro                ");
        query.append("       , info_fat                ");
        query.append("       , info_na                 ");
        query.append("FROM     Foods                   ");
        query.append("WHERE   1=1                      ");
        query.append("  AND food_ingredient LIKE   ?   ");

        PreparedStatement ps = conn.prepareStatement(query.toString());

        ps.setString(1, "%" + food + "%");

        ResultSet rs = ps.executeQuery();

        ArrayList<FoodDTO> result = new ArrayList<>();

        while (rs.next()) {
            String foodName = rs.getString("food_name");
            String foodRecipe = rs.getString("food_recipe");
            String foodIngredient = rs.getString("food_ingredient");
            String foodImage = rs.getString("food_image");
            String infoWgt = rs.getString("info_wgt");
            String infoEng = rs.getString("info_eng");
            String infoCar = rs.getString("info_car");
            String infoPro = rs.getString("info_pro");
            String infoFat = rs.getString("info_fat");
            String infoNa = rs.getString("info_na");

            // 데이터의 컬럼값을 담을 수 있는 객체 생성(MemberDTO)
            FoodDTO foodDTO = new FoodDTO(foodName, foodRecipe, foodIngredient, foodImage, infoWgt, infoEng, infoCar, infoPro, infoFat, infoNa);
            result.add(foodDTO);
        }

        rs.close();
        ps.close();

        return result;
    }








}
