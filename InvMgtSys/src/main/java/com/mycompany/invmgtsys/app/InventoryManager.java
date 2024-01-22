package com.mycompany.invmgtsys.app;

import java.util.Scanner;

import com.mycompany.invmgtsys.models.*;
import com.mycompany.invmgtsys.repository.ItemRepository;
import com.mycompany.invmgtsys.repository.SectionRepository;
import com.mycompany.invmgtsys.repository.WarehouseRepository;
import com.mycompany.invmgtsys.services.InventoryService;

public class InventoryManager {
    InventoryService inventoryService = new InventoryService();
    Scanner sc = new Scanner(System.in);

    public void startManager() {
        while (true) {
            clearScreen();
            System.out.println("\nInventory Management System:");
            print("\nMenu\n");
            print("Press 1 to Register Warehouse");
            print("Press 2 to Register Section");
            print("Press 3 to Register Item\n");
            print("Press 4 to Display All Warehouses");
            print("Press 5 to Display All Sections");
            print("Press 55 to Display All Sections by Warehouse");
            print("Press 6 to Display All Items\n");
            // print("Press 7 to Store Warehouse to file");
            // print("Press 8 to Store Section to file");
            // print("Press 9 to Store Item to file\n");
            print("Enter 10 to Update WareHouse record");
            print("Enter 11 to Update Section record");
            print("Enter 12 to Update Item record\n");
            // print("Press 7 to Display All");
            print("Press 0 to quite\n\nChoice: ");

            // if (!(sc.hasNextInt())) {// check if the input has int
            // print("\n\nInvalid Choice!\n");
            // continue;
            // }

            try {
                int choice = Integer.parseInt(sc.nextLine());
                switch (choice) {
                    case 1 ->
                        registerWareHouse();
                    case 2 ->
                        registerSection();
                    case 3 ->
                        registerItem();
                    case 4 -> {
                        showAllWareHouses();
                        sc.nextLine();
                    }
                    case 5 -> {
                        showAllSections();
                        sc.nextLine();
                    }
                    case 6 -> {
                        showAllItems();
                        sc.nextLine();
                    }
                    // case 7 -> {
                    // storeWarehouseToFile();
                    // }
                    // case 8 -> {
                    // storeSectionToFile();
                    // }
                    // case 9 -> {
                    // storeItemToFile();
                    // }
                    // case 10 -> {
                    // updateWarehouseRecord();
                    // }
                    // case 11 -> {
                    // updateSectionRecord();
                    // }
                    case 0 ->
                        System.exit(0);
                }
            } catch (Exception e) {
                print("\n\nInvalid Choice!\n");
                continue;
            }
        }

        // if (INVS.getAllWarehouses().isEmpty()) {
        // System.out.println("Warehouse list empty");
        // } else {
        // System.out.println("All Warehouses");
        // for (Warehouse warehouse : INVS.getAllWarehouses()) {
        // System.out.println("\nWarehouses:");
        // System.out.println("\nWareHouse ID: " + warehouse.getWarehouseId());
        // System.out.println("Capacity: " + warehouse.getCapacity());
        // System.out.println("Location: " + warehouse.getLocation());
        // }
        // }

        // Warehouse ws1 = new Warehouse();
        // ws1.setWarehouseId(1);
        // ws1.setCapacity(300);
        // ws1.setCurrentCapacity(3);
        // ws1.setLocation("Addis Abeba");
        // // ws1.set

        // WarehouseRepository wRepository = new WarehouseRepository();
        // wRepository.addWarehouse(ws1);

        // if (INVS.getAllWarehouses().isEmpty()) {
        // System.out.println("Warehouse list empty");
        // } else {
        // System.out.println("All Warehouses");
        // for (Warehouse warehouse : INVS.getAllWarehouses()) {
        // System.out.println("\nWarehouses:");
        // System.out.println("\nWareHouse ID: " + warehouse.getWarehouseId());
        // System.out.println("Capacity: " + warehouse.getCapacity());
        // System.out.println("Location: " + warehouse.getLocation());
        // }
        // }
    }

    public void registerItem() {
        Scanner sc = new Scanner(System.in);
        // WareHouse wh;
        try {

            // Item item, int quantity, Section section, Warehouse warehouse
            Item item = new Item();

            print("Ware House ID: ");
            int warehouse_id = Integer.parseInt(sc.nextLine());
            WarehouseRepository warehouseRepository = new WarehouseRepository();
            Warehouse warehouse = warehouseRepository.getWarehouseById(warehouse_id);
            if (warehouse == null) {
                print("No such Warehouse found!");
                return;
            }
            print("Section ID: ");
            int section_id = Integer.parseInt(sc.nextLine());
            SectionRepository sectionRepository = new SectionRepository(warehouse.getSections());
            Section section = sectionRepository.getSectionById(section_id);

            if (section == null) {
                print("No such Section found!");
                sc.nextLine();// wait for keyboard press
                return;
            }

            print("\nRegister Item Record:\n");
            print("Item Id: ");
            item.setId(Integer.parseInt(sc.nextLine()));
            print("Name");
            item.setName(sc.nextLine());
            print("Description");
            item.setDescription(sc.nextLine());
            print("Quantity");
            int quantity = Integer.parseInt(sc.nextLine());

            // ItemRepository itemRepository = new ItemRepository();
            // addItem(item);

            inventoryService.addItem(item, quantity, section, warehouse);

            print("\nSection registered successfully\n");
        } catch (NumberFormatException e) {
            print("Invalid input detected, Please enter again");
        }

        sc.nextLine();
    }

    public void registerSection() {
        Scanner sc = new Scanner(System.in);
        try {
            print("\nRegister Section Record:\n");
            print("Ware House ID: ");
            int warehouse_id = Integer.parseInt(sc.nextLine());
            WarehouseRepository warehouseRepository = new WarehouseRepository();
            Warehouse warehouse = warehouseRepository.getWarehouseById(warehouse_id);

            if (warehouse != null) {
                Section section = new Section();
                section.setWarehouseId(warehouse_id);
                print("Section Id: ");
                section.setSectionId((Integer.parseInt(sc.nextLine())));
                print("Aisle Name: ");
                section.setAisleName(sc.nextLine());
                print("Max Capacity: ");
                section.setMaxCapacity(Integer.parseInt(sc.nextLine()));
                print("Current Occupancy");
                section.setCurrentCapacity(Integer.parseInt(sc.nextLine()));

                inventoryService.addSection(section, warehouse);

            } else {
                throw new Exception("Invalid input");
            }
            print("\nSection registered successfully\n");
        } catch (Exception e) {
            print("Invalid input detected, Please enter again");
            e.printStackTrace();
        }
        sc.nextLine();
    }

    public void registerWareHouse() {
        // String fileName = "warehouses.ser";

        Scanner sc = new Scanner(System.in);
        try {
            print("\nRegister Warehouse Record:\n");
            sc.nextLine();
            Warehouse warehouse001 = new Warehouse();

            System.out.println("Enter Warehouse ID : ");
            warehouse001.setWarehouseId(sc.nextInt());
            sc.nextLine();
            System.out.println("Enter Warehouse Location : ");
            warehouse001.setLocation(sc.nextLine());

            System.out.println("Enter Warehouse Max Capacity : ");
            warehouse001.setMaxCapacity(sc.nextInt());
            sc.nextLine();

            inventoryService.addWarehouse(warehouse001);

            // print("Warehouse Id: ");
            // int warehouse_id = Integer.parseInt(sc.nextLine());
            // print("Capacity: ");
            // int capacity = Integer.parseInt(sc.nextLine());
            // print("Location");
            // String location = sc.nextLine();
            // print("Sections Count: ");
            // int sections_count = Integer.parseInt(sc.nextLine());
            // WareHouse wh = new WareHouse(warehouse_id, capacity, sections_count,
            // location);
            // warehouses.add(wh);
            print("\nWare house registered successfully\n");
        } catch (NumberFormatException e) {
            print("Invalid input detected, Please enter again");
        }
        sc.nextLine();
    }

    public void showAllItems() {
        if (!inventoryService.getAllItems().isEmpty()) {
            print("______________________________________");
            for (Item item : inventoryService.getAllItems()) {
                displayItem(item);
                print("______________________________________");
            }
        } else {
            System.out.println("You don't have any item");
        }
    }

    public void displayItem(Item item) {
        // int[] itemWarehouseIds =
        // inventoryService.getItemWarehouseIds(item.getItem_id());
        // System.out.println("Warehouse IDs : \t" + itemWarehouseIds.toString());
        System.out.println("Item ID : \t" + item.getId());
        System.out.println("Name : \t\t" + item.getName());
        System.out.println("Description: \t" + item.getDescription());
    }

    public void showAllWareHouses() {
        if (!inventoryService.getAllWarehouses().isEmpty()) {
            print("______________________________________");
            for (Warehouse warehouse : inventoryService.getAllWarehouses()) {
                displayWareHouse(warehouse);
            }
        } else {
            System.out.println("You don't have any warehouses");
        }
    }

    public void displayWareHouse(Warehouse warehouse) {
        // int [] sectioniDs = ;
        System.out.println("Warehouse ID : \t" + warehouse.getWarehouseId());
        System.out.println("Warehouse Location : \t" + warehouse.getLocation());
        System.out.println("Warehouse Maximum Capacity : \t" + warehouse.getMaxCapacity());
        System.out.println("Warehouse Current Quantity : \t" + warehouse.getCurrentQuantity());
        System.out.println("Warehouse has " + (warehouse.getSections() != null ? warehouse.getSections().size() : 0)
                + " Sections,["+warehouse.getSectionsIds().toString()+"]");
        print("______________________________________");

    }

    public void showAllSectionsByWarehouse(int warehouse_id) {
        if (!inventoryService.getAllSectionsByWarehouse(warehouse_id).isEmpty()) {
            for (Section section : inventoryService.getAllSectionsByWarehouse(warehouse_id)) {
                displaySection(section);
            }
        } else {
            System.out.println("You don't have any section");
        }
    }

    public void showAllSections() {
        if (!inventoryService.getAllSections().isEmpty()) {
            print("______________________________________");
            for (Section section : inventoryService.getAllSections()) {
                displaySection(section);
            }
        } else {
            System.out.println("You don't have any section");
        }
    }

    public void displaySection(Section section) {

        System.out.println("Warehouse ID : \t" + section.getWarehouseId());
        System.out.println("Aisle Name : \t" + section.getAisleName());
        System.out.println("Max. Capacity : \t" + section.getMaxCapacity());
        System.out.println("Current Capacity : \t" + section.getCurrentCapacity());
        System.out.println("Maximum Capacity : " + section.getMaxCapacity());
        System.out.println("Section has " + (section.getStorageBins() != null ? section.getStorageBins().size() : 0)
                + " Storage Bins");
        print("______________________________________");
    }

    static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();

    }

    public static void print(String s) {
        System.out.println(s);
    }
}
