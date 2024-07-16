package com.example.singleton;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.sql.DataSource;
import java.awt.image.DataBuffer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@SpringBootApplication
public class SingletonApplication {

    public static void main(String[] args) {
        DatabaseConnection dbConnection1 = DatabaseConnection.getInstance();
        Connection connection1 = dbConnection1.getConnection();

        try (PreparedStatement statement = connection1.prepareStatement("SELECT * FROM singleton")) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                System.out.println("Data: " + resultSet.getString("column1"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        DatabaseConnection dbConnection2 = DatabaseConnection.getInstance();
        Connection connection2 = dbConnection2.getConnection();

        if (dbConnection1 == dbConnection2) {
            System.out.println("Both instances are the same.");
        } else {
            System.out.println("Different instances are created.");
        }
    }
}
