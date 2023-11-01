package ch14_jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JdbcDelete {

    public static void main(String[] args) {

        // 1. ojdbc 라이브러리 내 oracleDriver 클래스를 깨우기
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            System.out.println("드라이버 로드 성공");
        } catch (ClassNotFoundException e) {
//            throw new RuntimeException(e);  // 프로그램 멈춤
            System.exit(0); // 프로그램 종료
        }

        // 2. DB 연결을 위한 URL, 계정 ID/PW 준비
        String url = "jdbc:oracle:thin:@nextit.or.kr:1521:xe";
        String id = "std205";
        String pw = "oracle21c";

        Connection conn = null;
        PreparedStatement ps = null;
        // ResultSet은 SELECT문 에서만 사용



        try {
            conn = DriverManager.getConnection(url, id, pw);

            // 4. 쿼리문 작성
            StringBuffer query = new StringBuffer();
            // 문자열 더하기 중에 여백 없이 딱 붙는 경우가 없도록 하기
            query.append("DELETE FROM members   ");
            query.append("WHERE mem_name = ?    ");

            ps = conn.prepareStatement(query.toString());

            // 쿼리문 내 ? 에 값을 채워줌
            // 첫번째 물음표의 인덱스는 0이아니라 1부터 시작
            int idx = 1;
            ps.setString(idx++, "세균맨");
            // insert, update, delete문은 executeUpdate()로 실행
            // 결과는 int 타입이 리턴된다.
            int result = ps.executeUpdate();    // (dbeaver의) update rows 의 값을 리턴

            System.out.println(result);


        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if(ps != null){ try { ps.close(); } catch (SQLException e) { e.printStackTrace(); } }
            if(conn != null){ try { conn.close(); } catch (SQLException e) { e.printStackTrace(); } }
        }


    }
}
