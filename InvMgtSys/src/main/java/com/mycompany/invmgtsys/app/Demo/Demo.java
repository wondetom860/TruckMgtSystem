package com.mycompany.invmgtsys.app.Demo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.mycompany.invmgtsys.utility.*;

public class Demo {
    public static void main(String[] args) throws SQLException {
        DBConnector dbConnector = new DBConnector();
        Connection conn = dbConnector.getDBConnection();
        if (conn != null) {
            System.out.println("Connection Successfull, Connection string: " + conn);

            String queryString = "SELECT * FROM warehouse";
            PreparedStatement stmt = conn.prepareStatement(queryString);
            try {
                // stmt.setString(1, item_name);
                ResultSet rs = stmt.executeQuery();
                System.out.println("_____________________________________________");
                while (rs.next()) {
                    System.out.println("Warehouse ID: \t\t" + rs.getString(1));
                    System.out.println("Location: \t\t" + rs.getString(2));
                    System.out.println("Max Capacity: \t\t" + rs.getString(4));
                    System.out.println("Current Capacity: \t" + rs.getString(3));
                    System.out.println("_________________________________________________");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                stmt.close();
            }
        } else {
            System.out.println("Connecting to MySQL server failed.");
        }
        // try {
        //     System.out.println(5/0);
        //     int[] nums = new int[] { 1, 2, 3, 4, 5 };
        //     nums[7] = 18;
        // } catch (IndexOutOfBoundsException e) {
        //     System.out.println("Error: Something wrong happened." + e.getMessage());
        // } catch (ArithmeticException e) {
        //     System.out.println("Error: Arithmatic exception happened." + e.getMessage());
        // }catch(Exception e){
        //     System.out.println("Error: Arithmatic exception happened." + e.getMessage());
        // }

        // Rectangle rec = new Rectangle(55.5, 22.2);
        // System.out.println("Rectangle:\nSides: " + rec.getSides());
        // System.out.println("Lenght:" + rec.lenght);
        // System.out.println("Width:" + rec.width);
        // System.out.println("Area: " + rec.calculateArea());
        // System.out.println("Perimeter: " + rec.calculatePerimeter());

        // Circle cc = new Circle(19.25);

        // System.out.println("\n\nCircle:\nSides: " + cc.getSides());
        // System.out.println("Radious:" + cc.radious);
        // System.out.println("Area: " + cc.calculateArea());
        // System.out.println("Perimeter: " + cc.calculatePerimeter());

    }
}
