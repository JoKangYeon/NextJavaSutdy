package ch16_network.open_api;

import ch14_jdbc_jsp.dto.BoardDTO;
import ch14_jdbc_jsp.dto.MemberDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MedicineDAO {

    private MedicineDAO(){

    }

    private static MedicineDAO instance = new MedicineDAO();

    public static MedicineDAO getInstance() {
        return instance;
    }

    // 약 데이터 추가(INSERT)
    public int insertMc(Connection conn, MedicineDTO medicineDTO) throws SQLException {
        StringBuffer query = new StringBuffer();
        query.append("INSERT INTO                ");
        query.append("         medicines (       ");
        query.append("         entp_name         ");
        query.append("       , item_name         ");
        query.append("       , efcyqesitm        ");
        query.append(" )       VALUES (          ");
        query.append("         ?                 ");
        query.append("       , ?                 ");
        query.append("       , ?                 ");
        query.append(" )                         ");

        PreparedStatement ps = conn.prepareStatement(query.toString());

        int idx = 1;
        ps.setString(idx++, medicineDTO.getEntpName());
        ps.setString(idx++, medicineDTO.getItemName());
        ps.setString(idx++, medicineDTO.getEfcyQesitm());

        int result = ps.executeUpdate();

        ps.close();

        return result;
    }

    // 약품 보기

    public ArrayList<MedicineDTO> readMc(Connection conn, String symptom) throws SQLException {
        StringBuffer query = new StringBuffer();
        query.append("SELECT                     ");
        query.append("         entp_name         ");
        query.append("       , item_name         ");
        query.append("       , efcyqesitm        ");
        query.append("FROM     medicines         ");
        query.append("WHERE   1=1                ");
        query.append("  AND efcyqesitm LIKE   ?  ");

        PreparedStatement ps = conn.prepareStatement(query.toString());

        ps.setString(1, "%" + symptom + "%");

        ResultSet rs = ps.executeQuery();

        ArrayList<MedicineDTO> result = new ArrayList<>();

        while (rs.next()) {
            String entpName = rs.getString("entp_name");
            String itemName = rs.getString("item_name");
            String efcyQesitm = rs.getString("efcyqesitm");

            // 데이터의 컬럼값을 담을 수 있는 객체 생성(MemberDTO)
            MedicineDTO medicineDTO = new MedicineDTO(entpName, itemName, efcyQesitm);
            result.add(medicineDTO);
        }

        rs.close();
        ps.close();

        return result;
    }


}
