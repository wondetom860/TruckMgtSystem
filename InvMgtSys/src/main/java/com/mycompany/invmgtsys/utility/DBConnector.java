package com.mycompany.invmgtsys.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
// import com.mysql.jdbc.Driver;

public class DBConnector {
    public static Connection conn = null;

    public static void main(String[] args) {
        getDBConnection();
        System.out.println(conn);
    }

    static void getDBConnection() {
        try {
            // This will load the MySQL driver, each DB has its own driver
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://127.0.0.1:3306/inventorymanagement";
            String user = "root";
            String password = "WT_toma000";
            // create a connection to the database
            conn = DriverManager.getConnection(url, user, password);

        } catch (Exception e) {
            System.out.println("Error:");
            System.out.println(e.getMessage());
        } finally {
            // try {
            //     if (conn != null) {
            //         conn.close();
            //     }

            // } catch (SQLException ex) {
            //     System.out.println(ex.getMessage());
            // }
        }
    }
}
