/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.invmgtsys.repository;

import java.util.ArrayList;
import java.util.List;
import com.mycompany.invmgtsys.models.Warehouse;
/**
 *
 * @author wonde
 */
public class WarehouseRepository {
    private static List<Warehouse> warehouses = new ArrayList<>();

    public void addWarehouse(Warehouse warehouse){
        warehouses.add(warehouse);
    }

    public Warehouse getWarehouseById(int id){
        for (Warehouse warehouse : warehouses) {
            if (warehouse.getWarehouseId() == id) {
                return warehouse;
            }
        }
        return null;
    }

    public void updateWarehouse(Warehouse updatedWarehouse){
        // int updatedWarehouseId = updatedWarehouse.getWarehouseId();
        // Warehouse updatedWarehouseFound = this.getWarehouseById(updatedWarehouseId);
        // if(updatedWarehouseFound != null){
        //     warehouses.set(updatedWarehouseId,updatedWarehouseFound);
        // }

        for (int i = 0; i < warehouses.size(); i++) {
            if (warehouses.get(i).getWarehouseId() == updatedWarehouse.getWarehouseId()) {
                warehouses.set(i, updatedWarehouse);
                return;
            }
        }
    }

    public void deleteWarehouse(int warehouseId){
        Warehouse warehousetoDelete = this.getWarehouseById(warehouseId);
        warehouses.remove(warehousetoDelete);//delete warehouse by id

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

    public List<Warehouse> getAllWarehouses(){
        return warehouses;
    }

}
