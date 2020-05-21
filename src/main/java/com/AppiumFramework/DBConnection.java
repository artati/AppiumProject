package com.AppiumFramework;

import java.sql.*;

/**
 * Created by Tatiana on 5/19/2020.
 */
public class DBConnection {
    public static void main(String[] args) throws SQLException {

        String host = "localhost";
        String port = "3306";

        Connection con = DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/AppiumDB", "root", "root");
        Statement s = con.createStatement();
        ResultSet names = s.executeQuery("Select name from Employeeinfo");
        System.out.println(names);

    }
}
