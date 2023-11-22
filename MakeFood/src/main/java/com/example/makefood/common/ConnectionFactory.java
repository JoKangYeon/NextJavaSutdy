package com.example.makefood.common;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;


public class ConnectionFactory {

    private String url;
    private String id;
    private String pw;
    private int maxConn;

    private ConnectionFactory(){
        Properties prop = new Properties();

        InputStream input = ConnectionFactory.class.getResourceAsStream("/config/context-db.properties");

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
