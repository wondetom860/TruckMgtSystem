/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.invmgtsys.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.mycompany.invmgtsys.models.Warehouse;
import com.mycompany.invmgtsys.utility.DBConnector;

/**
 *
 * @author wonde
 */
public class WarehouseRepository {
    public static List<Warehouse> warehouses = new ArrayList<>();

    public void addWarehouse(Warehouse warehouse) {
        warehouses.add(warehouse);
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
        for (Warehouse warehouse : warehouses) {
            if (warehouse.getWarehouseId() == id) {
                return warehouse;
            }
        }
        return null;
    }

    public void updateWarehouse(Warehouse updatedWarehouse) {
        // int updatedWarehouseId = updatedWarehouse.getWarehouseId();
        // Warehouse updatedWarehouseFound = this.getWarehouseById(updatedWarehouseId);
        // if(updatedWarehouseFound != null){
        // warehouses.set(updatedWarehouseId,updatedWarehouseFound);
        // }

        for (int i = 0; i < warehouses.size(); i++) {
            if (warehouses.get(i).getWarehouseId() == updatedWarehouse.getWarehouseId()) {
                warehouses.set(i, updatedWarehouse);
                return;
            }
        }
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
        // List <Warehouse> warehouses = new ArrayList<>();
        if (conn != null) {
            String queryString = "SELECT * FROM warehouse";
            PreparedStatement stmt = conn.prepareStatement(queryString);
            try {
                // stmt.setString(1, item_name);
                ResultSet rs = stmt.executeQuery();
                while (rs.next()) {
                    Warehouse warehouse =new Warehouse();
                    warehouse.setWarehouseId(rs.getInt(1));
                    warehouse.setLocation(rs.getString(2));
                    warehouse.setCapacity(rs.getInt(3));
                    warehouse.setMaxCapacity(rs.getInt(4));
                    warehouses.add(warehouse);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                stmt.close();
            }
        }

        return warehouses;
    }

    public List<Warehouse> getAllWarehouses() throws SQLException {
        return this.readFromDb();

        // return this.warehouses
    }

}
