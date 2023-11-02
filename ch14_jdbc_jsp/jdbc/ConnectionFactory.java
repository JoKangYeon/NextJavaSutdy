package ch14_jdbc_jsp.jdbc;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

// Connection 객체를 생성해주는 메소드를 보유하고 있는 메소드
public class ConnectionFactory {

    private String url;
    private String id;
    private String pw;
    private int maxConn;

    private ConnectionFactory(){
        // .properties 파일을 읽을 수 있는 객체 생성
        Properties prop = new Properties();

        // config 폴더 내 context-db.properties 파일을 읽어오기(텍스트)
        InputStream input = getClass().getClassLoader()
                .getResourceAsStream("config/context-db.properties");

        // 해당 파일의 내용을 key와 value로 사용할 수 있게 세팅됨

        try {
            prop.load(input);

            this.url = prop.getProperty("url");
            System.out.println(prop.getProperty("url"));
            this.id = prop.getProperty("id");
            System.out.println(prop.getProperty("id"));
            this.pw = prop.getProperty("pw");
            System.out.println(prop.getProperty("pw"));
            this.maxConn = Integer.parseInt(prop.getProperty("maxConn"));

            Class.forName("oracle.jdbc.driver.OracleDriver");
            System.out.println("드라이버 로드 성공");
        } catch (ClassNotFoundException e) {
            System.exit(0);  // 프로그램 종료
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static ConnectionFactory instance = new ConnectionFactory();

    public static ConnectionFactory getInstance(){
        return instance;
    }

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, id, pw);
    }

    public int getMaxConn() {
        return maxConn;
    }
}
