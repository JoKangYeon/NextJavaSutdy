package ch16_network.open_api;

import ch14_jdbc_jsp.dto.BoardDTO;
import ch14_jdbc_jsp.jdbc.ConnectionPool;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public class MedicineService {
    private MedicineService(){

    }

    private static MedicineService instance = new MedicineService();

    public static MedicineService getInstance() {
        return instance;
    }

    private static ConnectionPool cp = ConnectionPool.getInstance();
    private static MedicineDAO dao = MedicineDAO.getInstance();


    // 약품 넣기
    public static void insertMedicine(MedicineDTO medicineDTO){
        Connection conn = cp.getConnection();

        try {
            dao.insertMc(conn, medicineDTO);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            cp.releaseConnection(conn);
        }
    }

    // 약품 보기
    public ArrayList<MedicineDTO> getMedicineList(String symptom){
        Connection conn = cp.getConnection();
        ArrayList<MedicineDTO> result = new ArrayList<>();

        try {
            result = dao.readMc(conn, symptom);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally{
            cp.releaseConnection(conn);
        }

        return result;
    }




}
