package edu.curso;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection { 
    private final static String DB_CLASS = "org.mariadb.jdbc.Driver";
    private final static String DB_URL = "jdbc:mariadb://localhost:3306/alunos";
    private final static String DB_USER = "root";
    private final static String DB_PASS = "123456";
    private Connection connection = null;
    private static DBConnection dbConnection = null;

    private DBConnection() throws ClassNotFoundException {     
        Class.forName(DB_CLASS);
    }

    public static DBConnection getInstance() throws Exception { 
        if (dbConnection == null){ 
            dbConnection = new DBConnection();
        }
        return dbConnection;
    }

    public Connection getConnection() throws SQLException { 
        if (connection == null || !connection.isValid(3000)) { 
            connection = 
               DriverManager.getConnection(
                    DB_URL, DB_USER, DB_PASS);
        }
        return this.connection;       
    }

}