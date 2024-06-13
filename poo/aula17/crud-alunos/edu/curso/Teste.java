package edu.curso;

import java.sql.Connection;

public class Teste { 
    public static void main(String[] args) throws Exception {
        System.out.print("Teste");
        DBConnection dbConn = DBConnection.getInstance();
        Connection con = dbConn.getConnection();
    }
}