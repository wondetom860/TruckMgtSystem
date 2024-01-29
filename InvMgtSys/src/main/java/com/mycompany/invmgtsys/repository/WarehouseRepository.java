/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.invmgtsys.repository;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.mycompany.invmgtsys.models.Warehouse;
import com.mycompany.invmgtsys.utility.DBConnector;

/**
 *
 * @author wonde
 */
public class WarehouseRepository {
    public static List<Warehouse> warehouses = new ArrayList<>();

    public void addWarehouse(Warehouse warehouse) {
        // first add to DB
        String insertQuery = "INSERT INTO warehouse(location,currentQuantity,maxCapacity) values(?,?,?)";
        Connection conn = DBConnector.getDBConnection();
        try (PreparedStatement pStatement = conn.prepareStatement(insertQuery,1)) {
            // pStatement.setInt(1, warehouse.getId());
            pStatement.setString(1, warehouse.getLocation());
            pStatement.setInt(2, warehouse.getCurrentQuantity());
            pStatement.setInt(3, warehouse.getMaxCapacity());

            pStatement.executeUpdate();
            ResultSet rs = pStatement.getGeneratedKeys();
            int key = rs.next() ? rs.getInt(1) : 0;

            if (key != 0) {
                warehouse.setWarehouseId(key);
                warehouse.display();
                warehouses.add(warehouse);
                System.out.println("Insertion success");
            } else {
                System.out.println("Insertion failed.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // public static Warehouse findWarehouse(int warehouse_id){
    // return getWarehouseById(warehouse_id);
    // }

    public int getId(Warehouse wh) {
        return wh.getWarehouseId();
    }

    public Warehouse getById(int id) {
        return this.getWarehouseById(id);
    }

    public Warehouse getWarehouseById(int id) {

        // get warehouse by id from DB:
        String queryString = "SELECT * from warehouse where warehouseId=?";
        Warehouse whf = new Warehouse();
        Connection conn = DBConnector.getDBConnection();
        try {
            PreparedStatement pStatement = conn.prepareStatement(queryString);
            pStatement.setInt(1, id);
            ResultSet rs = pStatement.executeQuery();
            while (rs.next()) {
                whf.setWarehouseId(rs.getInt(1));
                whf.setLocation(rs.getString(2));
                whf.setCapacity(rs.getInt(3));
                whf.setCurrentQuantity(rs.getInt(3));
                whf.setMaxCapacity(rs.getInt(4));
            }
        } catch (SQLException e) {

            e.printStackTrace();
        }

        return whf;

        // for (Warehouse warehouse : warehouses) {
        // if (warehouse.getWarehouseId() == id) {
        // return warehouse;
        // }
        // }
        // return null;
    }

    protected int updateWarehouseDB(Warehouse warehouse) {
        // DBConnector dbConnector = new DBConnector();
        Connection conn = DBConnector.getDBConnection();
        String queryString = "update warehouse set warehouseId=?,location=?,maxCapacity=?,currentQuantity=? where warehouseID=?";
        try {
            PreparedStatement pstmt = conn.prepareStatement(queryString);
            pstmt.setInt(1, warehouse.getId());
            pstmt.setString(2, warehouse.getLocation());
            pstmt.setInt(3, warehouse.getMaxCapacity());
            pstmt.setInt(4, warehouse.getCurrentQuantity());
            pstmt.setInt(5, warehouse.getId());
            int affectedRows = pstmt.executeUpdate();

            if (affectedRows > 0) {
                System.out.println("Update success");
            } else {
                System.out.println("Update failed");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return 0;

    }

    public int updateWarehouse(Warehouse updatedWarehouse) {
        // int updatedWarehouseId = updatedWarehouse.getWarehouseId();
        // Warehouse updatedWarehouseFound = this.getWarehouseById(updatedWarehouseId);
        // if(updatedWarehouseFound != null){
        // warehouses.set(updatedWarehouseId,updatedWarehouseFound);
        // }

        for (int i = 0; i < warehouses.size(); i++) {
            if (warehouses.get(i).getWarehouseId() == updatedWarehouse.getWarehouseId()) {
                warehouses.set(i, updatedWarehouse);
                return updateWarehouseDB(updatedWarehouse);
            }
        }

        return 0;
    }

    public void deleteWarehouse(int warehouseId) {
        Warehouse warehousetoDelete = this.getWarehouseById(warehouseId);
        warehouses.remove(warehousetoDelete);// delete warehouse by id

        for (int i = 0; i < warehouses.size(); i++) {
            if (warehouseId == warehouses.get(i).getWarehouseId()) {
                warehouses.remove(i);
            }
        }
    }

    public void displayWarehouse(Warehouse whf) {
        System.out.println("\nWarehouses:");
        System.out.println("\nWareHouse ID: " + whf.getWarehouseId());
        System.out.println("Capacity: " + whf.getCapacity());
        System.out.println("Location: " + whf.getLocation());
    }

    public List<Warehouse> readFromDb() throws SQLException {
        // DBConnector dbConnector = new DBConnector();
        Connection conn = DBConnector.getDBConnection();
        List<Warehouse> warehouses2 = new ArrayList<>();
        if (conn != null) {
            String queryString = "SELECT * FROM warehouse";
            PreparedStatement stmt = conn.prepareStatement(queryString);
            try {
                // stmt.setString(1, item_name);
                ResultSet rs = stmt.executeQuery();
                while (rs.next()) {
                    Warehouse warehouse = new Warehouse();
                    warehouse.setWarehouseId(rs.getInt(1));
                    warehouse.setLocation(rs.getString(2));
                    warehouse.setCapacity(rs.getInt(3));
                    warehouse.setCurrentQuantity(rs.getInt(3));
                    warehouse.setMaxCapacity(rs.getInt(4));
                    warehouses2.add(warehouse);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                stmt.close();
            }
        }
        warehouses = warehouses2;
        return warehouses;
    }

    public List<Warehouse> getAllWarehouses() throws SQLException {
        return this.readFromDb();

        // return this.warehouses
    }

}
