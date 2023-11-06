package ch14_jdbc_jsp.dao;

import ch14_jdbc_jsp.dto.BoardDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BoardDAO {

    private BoardDAO(){

    }

    private static BoardDAO instance = new BoardDAO();

    public static BoardDAO getInstance(){
        return instance;
    }

    // 게시글 조회(SELECT) 메소드
    public ArrayList<BoardDTO> getBoardList(Connection conn) throws SQLException {
        StringBuffer query = new StringBuffer();
        query.append("SELECT                    ");
        query.append("     a.bo_no              ");
        query.append("   , a.bo_title           ");
        query.append("   , a.bo_content         ");
        query.append("   , a.bo_id              ");
        query.append("   , a.bo_date            ");
        query.append("   , b.mem_name           ");
        query.append("FROM                      ");
        query.append("   boards a, members b    ");
        query.append("WHERE 1=1                 ");
        query.append("  AND a.bo_id = b.mem_id  ");
        query.append("  AND a.del_yn = 'N'      ");
        query.append("ORDER BY a.bo_no DESC     ");

        PreparedStatement ps = conn.prepareStatement(query.toString());

        ResultSet rs = ps.executeQuery();

        ArrayList<BoardDTO> result = new ArrayList<>();

        while(rs.next()){
            BoardDTO board = new BoardDTO();

            board.setBoNo(rs.getInt("bo_no"));
            board.setBoTitle(rs.getString("bo_title"));
            board.setBoContent(rs.getString("bo_content"));
            board.setBoId(rs.getString("bo_id"));
            board.setBoDate(rs.getString("bo_date"));
            board.setMemName(rs.getString("mem_name"));

            result.add(board);
        }

        rs.close();
        ps.close();

        return result;
    }

    // 글쓰기 (INSERT) 메소드
    public int writeBoard(Connection conn, BoardDTO board) throws SQLException {
        StringBuffer query = new StringBuffer();
        query.append("INSERT INTO               ");
        query.append("     boards (             ");
        query.append("         bo_no            ");
        query.append("       , bo_title         ");
        query.append("       , bo_content       ");
        query.append("       , bo_id            ");
        query.append("       , bo_date          ");
        query.append("       , del_yn           ");
        query.append(" ) VALUES (               ");
        query.append("     seq_board.NEXTVAL    ");
        query.append("   , ?                    ");
        query.append("   , ?                    ");
        query.append("   , ?                    ");
        query.append("   , SYSDATE              ");
        query.append("   , 'N'                  ");
        query.append(")                         ");

        PreparedStatement ps = conn.prepareStatement(query.toString());

        int idx = 1;
        ps.setString(idx++, board.getBoTitle());
        ps.setString(idx++, board.getBoContent());
        ps.setString(idx++, board.getBoId());

        int result = ps.executeUpdate();

        ps.close();

        return result;
    }

    // 글 보기(SELECT, WHERE) 메소드
    public BoardDTO getBoard(Connection conn, int boNo) throws SQLException {
        StringBuffer query = new StringBuffer();
        query.append("SELECT                    ");
        query.append("     a.bo_no              ");
        query.append("   , a.bo_title           ");
        query.append("   , a.bo_content         ");
        query.append("   , a.bo_id              ");
        query.append("   , a.bo_date            ");
        query.append("   , b.mem_name           ");
        query.append("FROM                      ");
        query.append("   boards a, members b    ");
        query.append("WHERE 1=1                 ");
        query.append("  AND a.bo_id = b.mem_id  ");
        query.append("  AND a.bo_no = ?         ");

        PreparedStatement ps = conn.prepareStatement(query.toString());

        ps.setInt(1, boNo);

        ResultSet rs = ps.executeQuery();

        BoardDTO board = new BoardDTO();

        if(rs.next()){
            board.setBoNo(rs.getInt("bo_no"));
            board.setBoTitle(rs.getString("bo_title"));
            board.setBoContent(rs.getString("bo_content"));
            board.setBoId(rs.getString("bo_id"));
            board.setBoDate(rs.getString("bo_date"));
            board.setMemName(rs.getString("mem_name"));
        }

        rs.close();
        ps.close();

        return board;
    }


    // 글 삭제(DELETE) 메소드
    public int deleteBoard(Connection conn, int boNo) throws SQLException {
        StringBuffer query = new StringBuffer();
//        query.append("DELETE FROM boards    ");
//        query.append("WHERE 1=1             ");
//        query.append("AND bo_no = ?         ");

        query.append("UPDATE boards         ");
        query.append("SET del_yn = 'Y'      ");
        query.append("WHERE 1=1             ");
        query.append("AND bo_no = ?         ");


        PreparedStatement ps = conn.prepareStatement(query.toString());

        ps.setInt(1, boNo);

        int result = ps.executeUpdate();

        ps.close();

        return result;

    }






}