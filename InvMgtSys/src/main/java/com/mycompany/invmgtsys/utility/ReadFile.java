package com.mycompany.invmgtsys.utility;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.mycompany.invmgtsys.app.InventoryManager;
import com.mycompany.invmgtsys.models.*;
import com.mycompany.invmgtsys.repository.WarehouseRepository;
import com.mycompany.invmgtsys.services.InventoryService;

public class ReadFile {
    public static void main(String[] args) {
        InventoryManager inventoryManager = new InventoryManager();
        // InventoryService inventoryService = new InventoryService();
        String path = "C:/Users/wonde/Documents/NetBeansProjects/InvMgtSys/src/main/java/com/mycompany/invmgtsys/app/File/warehouse.csv";
        List<Warehouse> warehouses = readFilWarehouses(path);
        WarehouseRepository.warehouses = warehouses;
        // initiate inventory manager
        inventoryManager.startManager();
        for (Warehouse warehouse : warehouses) {
            System.out.println("_________________________________________");
            warehouse.display();
            // inventoryService.addWarehouse(warehouse);
        }
        System.out.println("___________________________________________");
    }

    public static List<Warehouse> readFilWarehouses(String path) {
        // String path = "warehouse.csv";
        List<Warehouse> warehouses = new ArrayList<Warehouse>();
        int numberofLine = 3;
        // String textData[] = new String[3];
        try {
            FileReader fileReader = new FileReader(path);
            try (BufferedReader bfreader = new BufferedReader(fileReader)) {
                for (int i = 0; i < numberofLine; i++) {
                    warehouses.add(extractWareHouse(bfreader.readLine()));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return warehouses;
    }

    public static Warehouse extractWareHouse(String text) {
        String[] warehouseData = text.split(",");
        Warehouse warehouse = new Warehouse();
        warehouse.setWarehouseId(Integer.parseInt(warehouseData[0]));
        warehouse.setMaxCapacity(Integer.parseInt(warehouseData[2]));
        warehouse.setCapacity(Integer.parseInt(warehouseData[2]));
        warehouse.setCurrentQuantity(Integer.parseInt(warehouseData[3]));
        warehouse.setLocation(warehouseData[1]);

        return warehouse;
    }
}
