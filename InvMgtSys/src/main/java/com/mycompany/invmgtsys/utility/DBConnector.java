package com.mycompany.invmgtsys.utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;
import java.sql.SQLException;

public class DBConnector {

    public static Connection conn = null;

    public static void main(String[] args) throws SQLException {
        // clearScreen();
        // getDBConnection();
    }

    public static Connection getDBConnection() {
        try (FileInputStream f = new FileInputStream(
                "./InvMgtSys/src/main/java/com/mycompany/invmgtsys/utility/db.properties")) {
            // This will load the MySQL driver, each DB has its own driver
            Properties pro = new Properties();
            pro.load(f);
            Class.forName("com.mysql.cj.jdbc.Driver");
            // create a connection to the database
            conn = DriverManager.getConnection(pro.getProperty("url"), pro.getProperty("user"),
                    pro.getProperty("password"));
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error:");
            System.out.println(e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (conn != null) {
                System.out.println("::");
            }
        }

        return conn;
    }

    static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();

    }
}
