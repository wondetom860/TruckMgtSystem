package com.mycompany.invmgtsys.utility;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.mycompany.invmgtsys.models.*;

public class ReadFile {
    public static void main(String[] args) {
        // InventoryManager inventoryManager = new InventoryManager();
        // // InventoryService inventoryService = new InventoryService();
        // String path =
        // "C:/Users/wonde/Documents/NetBeansProjects/InvMgtSys/src/main/java/com/mycompany/invmgtsys/app/File/warehouse.csv";
        // List<Warehouse> warehouses = readFilWarehouses(path);
        // WarehouseRepository.warehouses = warehouses;
        // // initiate inventory manager
        // inventoryManager.startManager();
        // for (Warehouse warehouse : warehouses) {
        // System.out.println("_________________________________________");
        // warehouse.display();
        // // inventoryService.addWarehouse(warehouse);
        // }
        // System.out.println("___________________________________________");
    }

    // Section
    public List<Section> readFileSections(String path) {
        List<Section> sections = new ArrayList<Section>();
        try {
            FileReader fileReader = new FileReader(path);
            try (BufferedReader bfreader = new BufferedReader(fileReader)) {
                String texString = bfreader.readLine();
                while (texString != null) {
                    Section section = extractSection(texString);
                    sections.add(section);
                    section.display();
                    texString = bfreader.readLine();
                }
                Scanner sc = new Scanner(System.in);
                sc.nextLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sections;
    }

    public Section extractSection(String text) {
        String[] sectionData = text.split(",");
        Section section = new Section();
        section.setSectionId(Integer.parseInt(sectionData[0]));
        section.setMaxCapacity(Integer.parseInt(sectionData[2]));
        section.setCurrentCapacity(Integer.parseInt(sectionData[3]));
        section.setWarehouseId(Integer.parseInt(sectionData[4]));
        section.setShelfNumber(Integer.parseInt(sectionData[5]));
        section.setAisleName(sectionData[1]);

        return section;
    }

    // Warehouse
    public List<Warehouse> readFilWarehouses(String path) {
        List<Warehouse> warehouses = new ArrayList<Warehouse>();
        try {
            FileReader fileReader = new FileReader(path);
            try (BufferedReader bfreader = new BufferedReader(fileReader)) {
                String texString = bfreader.readLine();
                while (texString != null) {
                    warehouses.add(extractWareHouse(texString));
                    texString = bfreader.readLine();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return warehouses;
    }

    public Warehouse extractWareHouse(String text) {
        String[] warehouseData = text.split(",");
        Warehouse warehouse = new Warehouse();
        warehouse.setWarehouseId(Integer.parseInt(warehouseData[0]));
        warehouse.setLocation(warehouseData[1]);
        warehouse.setMaxCapacity(Integer.parseInt(warehouseData[2]));
        warehouse.setCapacity(Integer.parseInt(warehouseData[2]));
        warehouse.setCurrentQuantity(Integer.parseInt(warehouseData[3]));

        return warehouse;
    }
}
