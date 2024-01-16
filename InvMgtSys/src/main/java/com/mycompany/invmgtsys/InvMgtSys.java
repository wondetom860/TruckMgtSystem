/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.invmgtsys;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author wonde
 */
public class InvMgtSys {

    static List<WareHouse> warehouses = new ArrayList<>();
    static List<Section> sections = new ArrayList<>();
    static List<Item> items = new ArrayList<>();

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        // boolean wait_for_input = false;0

        while (true) {
            clearScreen();
            System.out.println("\nInventory Management System:");
            print("\nMenu\n");
            print("Press 1 to Register Warehouse");
            print("Press 2 to Register Section");
            print("Press 3 to Register Item\n");
            print("Press 4 to Display Warehouse");
            print("Press 5 to Display Sections");
            print("Press 6 to Display Items\n");
            print("Press 7 to Store Warehouse to file");
            print("Press 8 to Store Section to file");
            print("Press 9 to Store Item to file\n");
            print("Enter 10 to Update WareHouse record");
            print("Enter 11 to Update Section record");
            print("Enter 12 to Update Item record\n");
            // print("Press 7 to Display All");
            print("Press 0 to quite\n\nChoice: ");

            if (!(sc.hasNextInt())) {// check if the input has int
                print("\n\nInvalid Choice!\n");
                continue;
            }

            int choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1 ->
                    registerWareHouse();
                case 2 ->
                    registerSection();
                case 3 ->
                    registerItem();
                case 4 -> {
                    display_warehouse();
                    sc.nextLine();
                }
                case 5 -> {
                    display_section();
                    sc.nextLine();
                }
                case 6 -> {
                    display_item();
                    sc.nextLine();
                }
                case 7 -> {
                    storeWarehouseToFile();
                }
                case 8 -> {
                    storeSectionToFile();
                }
                case 9 -> {
                    storeItemToFile();
                }
                case 10 -> {
                    updateWarehouseRecord();
                }
                case 11 -> {
                    updateSectionRecord();
                }
                case 0 ->
                    System.exit(0);
            }
            // case 4 :display_warehouse();

        }

    }

    static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();

    }

    private static WareHouse fidWareHouse(int whid) {
        if (warehouses.isEmpty()) {
            return null;
        } else {
            for (WareHouse wHouse : warehouses) {
                if (wHouse.warehouse_id == whid) {
                    return wHouse;
                }
            }

            return null;
        }
    }

    private static Section findSection(int sId) {
        if (sections.isEmpty()) {
            return null;
        } else {
            for (Section section : sections) {
                if (section.section_id == sId) {
                    return section;
                }
            }
            return null;
        }
    }

    public static void updateSectionRecord() {
        Scanner sc = new Scanner(System.in);

        print("Enter Section ID: ");
        int sId = Integer.parseInt(sc.nextLine());
        Section secf = findSection(sId);

        if (secf != null) {
            try {

                print("\nUpdate Section Record:\n");
                print("Section Id (" + secf.section_id + "): ");
                int section_id = Integer.parseInt(sc.nextLine());
                print("Ware House ID (" + secf.warehouse_id + "): ");
                int warehouse_id = Integer.parseInt(sc.nextLine());
                print("Max Capacity (" + secf.max_capacity + "): ");
                int max_capacity = Integer.parseInt(sc.nextLine());
                print("Current Occupancy (" + secf.current_occupancy + "): ");
                int current_occupancy = Integer.parseInt(sc.nextLine());

                // WareHouse wh = new WareHouse(warehouse_id, capacity, sections_count,
                // location);
                // warehouses.add(wh);
                secf.section_id = section_id;
                secf.warehouse_id = warehouse_id;
                secf.max_capacity = max_capacity;
                secf.current_occupancy = current_occupancy;

                print("\nSection updated successfully\n");
            } catch (NumberFormatException e) {
                print("Invalid input detected, Please try again");
            }
            sc.nextLine();
        } else {
            print("Section with such ID not found.");
            sc.nextLine();
        }
    }

    public static void updateWarehouseRecord() {
        Scanner sc = new Scanner(System.in);

        print("Enter Warehouse ID: ");
        int whId = Integer.parseInt(sc.nextLine());
        WareHouse whf = fidWareHouse(whId);

        if (whf != null) {
            try {
                print("\nUpdate Warehouse Record:\n");
                print("Warehouse Id(" + whf.warehouse_id + "):");
                int warehouse_id = Integer.parseInt(sc.nextLine());
                print("Capacity(" + whf.capacity + "):");
                int capacity = Integer.parseInt(sc.nextLine());
                print("Location(" + whf.location + "):");
                String location = sc.nextLine();
                print("Sections Count(" + whf.sections_count + "):");
                int sections_count = Integer.parseInt(sc.nextLine());
                // WareHouse wh = new WareHouse(warehouse_id, capacity, sections_count,
                // location);
                // warehouses.add(wh);
                whf.capacity = capacity;
                whf.location = location;
                whf.sections_count = sections_count;
                whf.warehouse_id = warehouse_id;

                print("\nWare house updated successfully\n");
            } catch (NumberFormatException e) {
                print("Invalid input detected, Please enter again");
            }
            sc.nextLine();
        } else {
            print("Warehouse with such ID not found.");
            sc.nextLine();
        }
    }

    public static void storeWarehouseToFile() {
        if (warehouses.isEmpty()) {
            print("Object Value is empity");
        }
        try (
                FileOutputStream fout = new FileOutputStream("warehouses.ser", true);
                ObjectOutputStream oos = new ObjectOutputStream(fout);) {
            oos.writeObject(warehouses);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void storeItemToFile() {
        if (items.isEmpty()) {
            print("Object Value is empity");
        }
        try (
                FileOutputStream fout = new FileOutputStream("items.ser", true);
                ObjectOutputStream oos = new ObjectOutputStream(fout);) {
            oos.writeObject(items);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void storeSectionToFile() {
        if (sections.isEmpty()) {
            print("Object Value is empity");
        }
        try (
                FileOutputStream fout = new FileOutputStream("sections.ser", true);
                ObjectOutputStream oos = new ObjectOutputStream(fout);) {
            oos.writeObject(sections);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void display_warehouse() {
        if (!warehouses.isEmpty()) {
            print("\nWarehouses:\n");
            for (WareHouse warehouse : warehouses) {
                print("\nWareHouse ID: " + warehouse.warehouse_id);
                print("Capacity: " + warehouse.capacity);
                print("Location: " + warehouse.location);
                print("Sections Count: " + warehouse.sections_count);
            }
        } else {
            print("Warehouse List empty");
        }
    }

    public static void display_section() {
        if (!sections.isEmpty()) {
            print("\nSections:\n");
            for (Section section : sections) {
                print("\nSection ID: " + section.section_id);
                print("Warehouse ID: " + section.warehouse_id);
                print("Max Capacity: " + section.max_capacity);
                print("Current Occupancy: " + section.current_occupancy);
            }
        } else {
            print("Section List empty");
        }
    }

    public static void display_item() {
        if (!items.isEmpty()) {
            print("\nItems:\n");
            for (Item item : items) {
                print("\nItem ID: " + item.item_id);
                print("Quantity: " + item.quantity);
                print("Section ID: " + item.section_id);
                print("Description: " + item.description);
                print("Price: " + item.price);
            }
        } else {
            print("Item List empty");
        }
    }

    public static void registerItem() {
        Scanner sc = new Scanner(System.in);
        // WareHouse wh;
        try {
            print("\nRegister Item Record:\n");
            print("Item Id: ");
            int item_id = Integer.parseInt(sc.nextLine());
            print("Name");
            String name = sc.nextLine();
            print("Quantity: ");
            int quantity = Integer.parseInt(sc.nextLine());
            print("Section ID: ");
            int section_id = Integer.parseInt(sc.nextLine());
            print("Description");
            String desctiption = sc.nextLine();
            print("Price: ");
            double price = sc.nextDouble();
            Item item = new Item(item_id, quantity, section_id, desctiption, price, name);
            items.add(item);
            print("\nSection registered successfully\n");
        } catch (NumberFormatException e) {
            print("Invalid input detected, Please enter again");
        }

        sc.nextLine();
    }

    public static void registerSection() {
        Scanner sc = new Scanner(System.in);
        // WareHouse wh;
        try {
            print("\nRegister Section Record:\n");
            print("Section Id: ");
            int section_id = Integer.parseInt(sc.nextLine());
            print("Ware House ID: ");
            int warehouse_id = Integer.parseInt(sc.nextLine());
            print("Max Capacity: ");
            int max_capacity = Integer.parseInt(sc.nextLine());
            print("Current Occupancy");
            int current_occupancy = Integer.parseInt(sc.nextLine());
            Section section = new Section(section_id, max_capacity, current_occupancy, warehouse_id);
            sections.add(section);
            print("\nSection registered successfully\n");
        } catch (NumberFormatException e) {
            print("Invalid input detected, Please enter again");
        }
        sc.nextLine();
    }

    public static void registerWareHouse() {
        // String fileName = "warehouses.ser";

        Scanner sc = new Scanner(System.in);
        try {
            print("\nRegister Warehouse Record:\n");
            print("Warehouse Id: ");
            int warehouse_id = Integer.parseInt(sc.nextLine());
            print("Capacity: ");
            int capacity = Integer.parseInt(sc.nextLine());
            print("Location");
            String location = sc.nextLine();
            print("Sections Count: ");
            int sections_count = Integer.parseInt(sc.nextLine());
            WareHouse wh = new WareHouse(warehouse_id, capacity, sections_count, location);
            warehouses.add(wh);
            print("\nWare house registered successfully\n");
        } catch (NumberFormatException e) {
            print("Invalid input detected, Please enter again");
        }
        sc.nextLine();
    }

    public static void print(String s) {
        System.out.println(s);
    }
}

/**
 * WareHouse
 */
class WareHouse {

    int warehouse_id, capacity, sections_count;
    String location;

    public WareHouse(int warehouse_id, int capacity, int sections_count, String location) {
        this.capacity = capacity;
        this.warehouse_id = warehouse_id;
        this.sections_count = sections_count;
        this.location = location;
    }
}

class Section {

    int section_id, max_capacity, current_occupancy, warehouse_id;

    // String
    public Section(int section_id, int max_capacity, int current_occupancy, int warehouse_id) {
        this.section_id = section_id;
        this.max_capacity = max_capacity;
        this.current_occupancy = current_occupancy;
        this.section_id = section_id;
        this.warehouse_id = warehouse_id;
    }
}

/**
 * Item
 */
class Item {

    int item_id, quantity, section_id;
    double price;
    String name, description;

    public Item(int item_id, int quantity, int section_id, String description, double price, String name) {
        this.item_id = item_id;
        this.quantity = quantity;
        this.section_id = section_id;
        this.description = description;
        this.price = price;
        this.name = name;
    }

}
