package TruckMgtSystem.InvMgtSys.src.main.java.com.mycompany.invmgtsys.app;

// import java.util.Scanner;
// import TruckMgtSystem.InvMgtSys.src.main.java.com.mycompany.invmgtsys.services.*;
// import TruckMgtSystem.InvMgtSys.src.main.java.com.mycompany.invmgtsys.models.*;
// import TruckMgtSystem.InvMgtSys.src.main.java.com.mycompany.invmgtsys.repository.*;

public class Main {
    public static void main(String[] args) {
        // Scanner sc = new Scanner(System.in);
        // boolean wait_for_input = false;0

        InventoryManager inventoryManager = new InventoryManager();
        inventoryManager.startManager();
        // while (true) {
        // clearScreen();
        // System.out.println("\nInventory Management System:");
        // print("\nMenu\n");
        // print("Press 1 to Register Warehouse");
        // print("Press 2 to Register Section");
        // print("Press 3 to Register Item\n");
        // print("Press 4 to Display Warehouse");
        // print("Press 5 to Display Sections");
        // print("Press 6 to Display Items\n");
        // print("Press 7 to Store Warehouse to file");
        // print("Press 8 to Store Section to file");
        // print("Press 9 to Store Item to file\n");
        // print("Enter 10 to Update WareHouse record");
        // print("Enter 11 to Update Section record");
        // print("Enter 12 to Update Item record\n");
        // // print("Press 7 to Display All");
        // print("Press 0 to quite\n\nChoice: ");

        // if (!(sc.hasNextInt())) {// check if the input has int
        // print("\n\nInvalid Choice!\n");
        // continue;
        // }

        // int choice = Integer.parseInt(sc.nextLine());

        // switch (choice) {
        // case 1 ->
        // registerWareHouse();
        // case 2 ->
        // registerSection();
        // case 3 ->
        // registerItem();
        // case 4 -> {
        // display_warehouse();
        // sc.nextLine();
        // }
        // case 5 -> {
        // display_section();
        // sc.nextLine();
        // }
        // case 6 -> {
        // display_item();
        // sc.nextLine();
        // }
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
        // case 0 ->
        // System.exit(0);
        // }
        // }
    }

    // public static void registerItem() {
    // Scanner sc = new Scanner(System.in);
    // // WareHouse wh;
    // try {
    // Item item = new Item();
    // print("\nRegister Item Record:\n");
    // print("Item Id: ");
    // item.setId(Integer.parseInt(sc.nextLine()));
    // print("Name");
    // item.setName(sc.nextLine());
    // print("Description");
    // item.setDescription(sc.nextLine());

    // itemRepo.addItem(item);

    // print("\nSection registered successfully\n");
    // } catch (NumberFormatException e) {
    // print("Invalid input detected, Please enter again");
    // }

    // sc.nextLine();
    // }

    // public void registerSection() {
    // Scanner sc = new Scanner(System.in);
    // // WareHouse wh;
    // try {
    // print("\nRegister Section Record:\n");
    // print("Section Id: ");
    // int section_id = Integer.parseInt(sc.nextLine());
    // print("Ware House ID: ");
    // int warehouse_id = Integer.parseInt(sc.nextLine());
    // print("Max Capacity: ");
    // int max_capacity = Integer.parseInt(sc.nextLine());
    // print("Current Occupancy");
    // int current_occupancy = Integer.parseInt(sc.nextLine());
    // Section section = new Section(section_id, max_capacity, current_occupancy,
    // warehouse_id);
    // sections.add(section);
    // print("\nSection registered successfully\n");
    // } catch (NumberFormatException e) {
    // print("Invalid input detected, Please enter again");
    // }
    // sc.nextLine();
    // }

    // public static void registerWareHouse() {
    // // String fileName = "warehouses.ser";

    // Scanner sc = new Scanner(System.in);
    // try {
    // print("\nRegister Warehouse Record:\n");
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
    // print("\nWare house registered successfully\n");
    // } catch (NumberFormatException e) {
    // print("Invalid input detected, Please enter again");
    // }
    // sc.nextLine();
    // }

    static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();

    }

    public static void print(String s) {
        System.out.println(s);
    }
}
