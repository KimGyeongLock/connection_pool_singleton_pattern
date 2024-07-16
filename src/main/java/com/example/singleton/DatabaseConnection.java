package com.example.singleton;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static DatabaseConnection instance; //클래스 내부에서만 접근 가능
    private Connection connection;
    private String url = "jdbc:mysql://localhost:3306/singleton"; // 데이터베이스 URL
    private String username = "root"; // 데이터베이스 사용자 이름
    private String password = "kkl7445468"; // 데이터베이스 비밀번호

    // 생성자를 private으로 선언
    private DatabaseConnection() {
        try {
            // JDBC 드라이버를 로드합니다.
            Class.forName("com.mysql.cj.jdbc.Driver");
            // 데이터베이스 연결을 생성합니다.
            this.connection = DriverManager.getConnection(url, username, password);
            System.out.println("Database connected.");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace(); // 예외 발생 시 스택 트레이스를 출력합니다.
            throw new RuntimeException("Database connection failed!");
        }
    }
    //synchronized: 멀티스레드 환경에서도 안전하게 인스턴스를 생성
    // 인스턴스에 접근할 수 있는 정적 메소드 제공
    public static synchronized DatabaseConnection getInstance() { //Instance 변수를 사용하지 않는다?, 생성하지 않고
        if (instance == null) {
            instance = new DatabaseConnection();
        }
        return instance;
    }

    // 데이터베이스 연결 객체를 반환하는 메소드
    public Connection getConnection() {
        return connection;
    }
}
