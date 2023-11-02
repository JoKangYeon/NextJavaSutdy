package ch14_jdbc_jsp.service;

import ch14_jdbc_jsp.dao.MemberDAO;
import ch14_jdbc_jsp.dto.MemberDTO;
import ch14_jdbc_jsp.jdbc.ConnectionPool;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

// ConnectionPool로부터 Connection 객체 대여/반납해가며
// DAO의 메소드에 대한 예외처리 담당
public class MemberService {

    private MemberService(){

    }

    private  static MemberService instance = new MemberService();

    public static MemberService getInstance(){
        return instance;
    }

    private ConnectionPool cp = ConnectionPool.getInstance();
    private MemberDAO dao = MemberDAO.getInstance();

    public ArrayList<MemberDTO> getMemberList(){
        Connection conn = cp.getConnection();
        ArrayList<MemberDTO> result;

        try {
            result = dao.getMemberList(conn);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            cp.releaseConnection(conn);

        }
        return result;
    }

    // 회원가입
    public void signUp(MemberDTO member){
        Connection conn = cp.getConnection();

        try {
            dao.signUp(conn, member);
            System.out.println("회원가입에 성공하였습니다.");
        } catch (SQLException e) {
            // 중복된 아이디가 입력되었으면 에러가 발생
            System.out.println("회원가입에 실패하였습니다.");
            System.out.println("아이디가 중복됩니다.");
        } finally {
            cp.releaseConnection(conn);
        }
    }

    // 로그인

    public MemberDTO login(MemberDTO member){
        Connection conn = cp.getConnection();
        MemberDTO result = new MemberDTO();

        try {
            result = dao.login(conn, member);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }   finally {
            cp.releaseConnection(conn);
        }

        return result;

    }


}
