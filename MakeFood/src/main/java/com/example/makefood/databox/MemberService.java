package com.example.makefood.databox;

import com.example.makefood.common.ConnectionPool;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public class MemberService {

    private MemberService(){

    }
    private static MemberService instance = new MemberService();
    public static MemberService getInstance(){
        return instance;
    }

    private static ConnectionPool cp = ConnectionPool.getInstance();
    private static FoodDAO dao = FoodDAO.getInstance();
    public String food;

    // 음식 넣기
    public static void insertFood(FoodDTO foodDTO){
        Connection conn = cp.getConnection();

        try {
            dao.insertFood(conn,foodDTO);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            cp.releaseConnection(conn);
        }
    }

    // 음식 보기
    public ArrayList<FoodDTO> getFoodList(String food){
        Connection conn = cp.getConnection();
        ArrayList<FoodDTO> result = new ArrayList<>();

        try {
            result = dao.showFood(conn, food);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            cp.releaseConnection(conn);
        }
        return result;
    }



}
