package com.mycompany.invmgtsys;

import java.util.ArrayList;
// import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Warehouse {
    int warehouse_id, capacity, sections_count;
    String location;

    // List<Warehouse> warehouses = new ArrayList<Warehouse>();

    // constructor class
    public Warehouse(int warehouse_id, int capacity, int sections_count, String location) {
        this.capacity = capacity;
        this.warehouse_id = warehouse_id;
        this.sections_count = sections_count;
        this.location = location;
    }

    public static void main(String[] args) {
        List<Warehouse> warehouses = new ArrayList<Warehouse>();
        Warehouse wh = new Warehouse(1, 2, 2, new String("Addis Abeba"));
        wh.displayMenu(new Scanner(System.in), warehouses);
    }

    public void displayMenu(Scanner sc, List<Warehouse> warehouses) {
        while (true) {
            System.out.println("\tManage Warehouse:");
            System.out.println("1.Register New Warehouse");
            System.out.println("2.Update Warehouse");
            System.out.println("3.List All Warehouses");
            System.out.println("4.View a Warehouse");
            System.out.println("0. Go back");
            // sc.nextLine();
            if (sc.hasNextInt()) {
                int choice = Integer.parseInt(sc.nextLine());
                switch (choice) {
                    case 1:
                        registerWarehouse(sc, warehouses);
                        break;
                    case 2:
                        updateWarehouseRecord(sc, warehouses);
                        break;
                    case 3:
                        listAllWarehouse(warehouses);
                        break;
                    case 4:
                        viewWarehause(sc, warehouses);
                        break;
                    case 0:
                        return;
                    default:
                        listAllWarehouse(warehouses);
                        break;
                }
            } else {
                System.out.println("Invalid input detected, Please ry again");
                return;
            }
        }
    }

    protected void viewWarehause(Scanner sc, List<Warehouse> warehouses) {
        System.out.println("Enter Warehouse ID: ");
        int whId = Integer.parseInt(sc.nextLine());
        Warehouse whf = fidWareHouse(warehouses, whId);

        if(whf != null){
            displayWarehouse(whf);
        }else{
            System.out.println("Such warehouse not found!");
        }
    }

    protected void displayWarehouse(Warehouse whf) {
        System.out.println("\nWarehouses:" + whf.warehouse_id);
        System.out.println("\nWareHouse ID: " + whf.warehouse_id);
        System.out.println("Capacity: " + whf.capacity);
        System.out.println("Location: " + whf.location);
        System.out.println("Sections Count: " + whf.sections_count);
    }

    protected void registerWarehouse(Scanner sc, List<Warehouse> warehouses) {
        // wareHouses.add()
        System.out.println("WareHouse registration: ");
        System.out.println("\nRegister Warehouse Record:\n");
        System.out.println("Warehouse Id: ");
        int warehouse_id = Integer.parseInt(sc.nextLine());
        System.out.println("Capacity: ");
        int capacity = Integer.parseInt(sc.nextLine());
        System.out.println("Location");
        String location = sc.nextLine();
        System.out.println("Sections Count: ");
        int sections_count = Integer.parseInt(sc.nextLine());
        Warehouse wh = new Warehouse(warehouse_id, capacity, sections_count, location);
        warehouses.add(wh);
        System.out.println("\nWare house registered successfully\n");

    }

    public void updateWarehouseRecord(Scanner sc, List<Warehouse> warehouses) {
        System.out.println("Enter Warehouse ID: ");
        int whId = Integer.parseInt(sc.nextLine());
        Warehouse whf = fidWareHouse(warehouses, whId);

        if (whf != null) {
            try {
                System.out.println("\nUpdate Warehouse Record:\n");
                System.out.println("Warehouse Id(" + whf.warehouse_id + "):");
                int warehouse_id = Integer.parseInt(sc.nextLine());
                System.out.println("Capacity(" + whf.capacity + "):");
                int capacity = Integer.parseInt(sc.nextLine());
                System.out.println("Location(" + whf.location + "):");
                String location = sc.nextLine();
                System.out.println("Sections Count(" + whf.sections_count + "):");
                int sections_count = Integer.parseInt(sc.nextLine());
                // WareHouse wh = new WareHouse(warehouse_id, capacity, sections_count,
                // location);
                // warehouses.add(wh);
                whf.capacity = capacity;
                whf.location = location;
                whf.sections_count = sections_count;
                whf.warehouse_id = warehouse_id;

                System.out.println("\nWare house updated successfully\n");
            } catch (NumberFormatException e) {
                System.out.println("Invalid input detected, Please enter again");
            }
            sc.nextLine();
        } else {
            System.out.println("Warehouse with such ID not found.");
            sc.nextLine();
        }
    }

    protected void listAllWarehouse(List<Warehouse> warehouses) {
        if (!warehouses.isEmpty()) {
            System.out.println("\nWarehouses:\n");
            for (Warehouse warehouse : warehouses) {
                displayWarehouse(warehouse);
            }
        } else {
            System.out.println("Warehouse List empty");
        }
    }

    private Warehouse fidWareHouse(List<Warehouse> warehouses, int whid) {
        if (warehouses.isEmpty()) {
            return null;
        } else {
            for (Warehouse wHouse : warehouses) {
                if (wHouse.warehouse_id == whid) {
                    return wHouse;
                }
            }
            return null;
        }
    }
}
