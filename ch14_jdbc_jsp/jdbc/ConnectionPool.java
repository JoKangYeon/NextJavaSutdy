package ch14_jdbc_jsp.jdbc;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

// 미리 Connection 객체들을 생성해서 보관하는 클래스
public class ConnectionPool {
    private ConnectionPool(){
        initPool();
    }

    private static ConnectionPool instance = new ConnectionPool();

    public static ConnectionPool getInstance(){
        return instance;
    }

    // Vertor는 동기화를 지원하는 ArrayList라 보면된다. (사용법 같음)
    Vector<Connection> pool = new Vector<>();

    // ConnectionFactory로부터 Connection 객체를 생성해서
    // pool에 담는 메소드

    private void initPool(){
        ConnectionFactory cf = ConnectionFactory.getInstance();
        int maxConn = cf.getMaxConn();
        for(int i = 0; i < maxConn; i++){
            try {
                pool.add(cf.getConnection());
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    // pool 에 보관된 Connection 객체 빌려주는 메소드
    public synchronized Connection getConnection(){

        // pool에 Connection 객체가 비어있는 경우 wait 시키기
        if(pool.size() == 0){
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        // 인덱스 0번째인 Connection 객체를 리턴해주고
        // pool에서 해당 Connection 객체를 지운다.
        Connection conn = pool.get(0);
        pool.remove(0);
        return conn;
    }

    // 빌려간 Connection 객체를 pool에 반납하는 메소드
    public synchronized void  releaseConnection(Connection conn){
        pool.add((conn));
        notify();
    }



}
