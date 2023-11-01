package ch14_jdbc;

import java.sql.*;

public class JdbcUpdate {

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
        ResultSet rs = null;

        try {
            conn = DriverManager.getConnection(url, id, pw);

            // 4. 쿼리문 작성
            StringBuffer query = new StringBuffer();
            // 문자열 더하기 중에 여백 없이 딱 붙는 경우가 없도록 하기
            query.append("UPDATE members      ");
            query.append("SET mem_score = ?   ");

            ps = conn.prepareStatement(query.toString());

            // 쿼리문 내 ? 에 값을 채워줌
            // 첫번째 물음표의 인덱스는 0이아니라 1부터 시작
            int idx = 1;
            ps.setInt(idx++, 100);
            // insert, update, delete문은 executeUpdate()로 실행
            // 결과는 int 타입이 리턴된다.
            int result = ps.executeUpdate();    // (dbeaver의) update rows 의 값을 리턴

            System.out.println(result);

            // 추가적으로 SELECT문 실행
            ps.close();
            query = new StringBuffer();

            query.append("SELECT                 ");
            query.append("  mem_id               ");
            query.append("  , mem_pw             ");
            query.append("  , mem_name           ");
            query.append("  , mem_score AS score ");
            query.append("FROM                   ");
            query.append("  members              ");

            ps = conn.prepareStatement(query.toString());

            rs = ps.executeQuery();

            while(rs.next()){
                System.out.println(rs.getString("mem_id"));
                System.out.println(rs.getString("mem_pw"));
                System.out.println(rs.getString("mem_name"));
                // SELECT 문 컬럼에 AS 가 있다면 해당 알리아스에 맞춰주어야 한다.
                System.out.println(rs.getInt("score"));
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if(rs != null){ try { rs.close(); } catch (SQLException e) { e.printStackTrace(); } }
            if(ps != null){ try { ps.close(); } catch (SQLException e) { e.printStackTrace(); } }
            if(conn != null){ try { conn.close(); } catch (SQLException e) { e.printStackTrace(); } }
        }


    }
}
