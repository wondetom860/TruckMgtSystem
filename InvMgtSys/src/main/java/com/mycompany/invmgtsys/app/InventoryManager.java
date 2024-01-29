package com.mycompany.invmgtsys.app;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.mycompany.invmgtsys.models.*;
// import com.mycompany.invmgtsys.repository.ItemRepository;
import com.mycompany.invmgtsys.repository.SectionRepository;
// import com.mycompany.invmgtsys.repository.StorageBinRepository;
import com.mycompany.invmgtsys.repository.WarehouseRepository;
import com.mycompany.invmgtsys.services.InventoryService;
import com.mycompany.invmgtsys.utility.*;

public class InventoryManager {
    InventoryService inventoryService = new InventoryService();
    InventoryComponent ic;
    Scanner sc = new Scanner(System.in);
    String fDBPath = "C:/Users/wonde/Documents/NetBeansProjects/InvMgtSys/src/main/java/com/mycompany/invmgtsys/models/fDB";

    public void startManager() {
        while (true) {
            clearScreen();
            System.out.println("\nInventory Management System:");
            print("\nMenu\n");
            print("Press 1 to Register Warehouse");
            print("Press 11 to Register Warehouse Bulk: ");
            print("Press 2 to Register Section");
            print("Press 3 to Register Item");
            print("Press 7 to Register Storage Bin\n");

            print("Press 4 to Display All Warehouses");
            print("Press 5 to Display All Sections");
            print("Press 55 to Display All Sections by Warehouse");
            print("Press 8 to Display All Storage Bins");
            print("Press 6 to Display All Items\n");

            print("Press 9 to Store Warehouse to file");
            print("Press 99 to Store Sections to file");
            print("Press 999 to Store Storage Bin to file");
            print("Press 909 to Store Items to file\n");

            print("Press 77 to Read Warehouse from file");
            print("Press 78 to Read Sections from file");
            print("Press 79 to Read Items from file");
            print("Press 799 to Read Storage Bins from file\n");

            print("Enter 10 to Update WareHouse record");
            print("Enter 101 to Update Section record");
            print("Enter 12 to Update Item record");
            print("Press 13 to Update Storage Bin\n");
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
                    case 55 -> {
                        showAllSectionsByWarehouse(sc);
                        sc.nextLine();
                    }
                    case 6 -> {
                        showAllItems();
                        sc.nextLine();
                    }
                    case 11 -> {
                        addWarehousesBulk(sc);
                    }
                    case 8 -> {
                        displayAllStorageBins();
                    }
                    case 13 -> {
                        updateStorageBin(sc);
                    }
                    case 101 -> {
                        updateSectionRecord(sc);
                    }
                    case 10 -> {
                        updateWarehouseRecord(sc);
                    }
                    case 77 -> {
                        warehousesDataSplitted(sc);
                    }
                    case 799 -> {
                        sbinsDataSplitted();
                    }
                    case 79 -> {
                        itemsDataSplitted();
                    }
                    case 78 -> {
                        sectionsDataSplitted(sc);
                    }
                    case 7 -> {
                        registerStorageBin(sc);
                    }
                    case 9 -> {
                        writeWarehouseStringToFile(sc);
                    }
                    case 99 -> {
                        writeSectionStringToFile(sc);
                    }
                    case 999 -> {
                        writeStorageBinStringToFile();
                    }
                    case 909 -> {
                        writeItemStringToFile();
                    }
                    case 0 ->
                        System.exit(0);
                }
            } catch (Exception e) {
                print("\n\nInvalid Choice!\n");
                continue;
            }
        }
    }

    public void writeItemStringToFile() {
        WriteFile wf = new WriteFile();
        String path = fDBPath + "/item.csv";
        wf.writeItemFile(inventoryService.getAllItems(), path);
    }

    public void writeStorageBinStringToFile() throws SQLException {
        WriteFile wf = new WriteFile();
        String path = fDBPath + "/sbin.csv";
        wf.writeStorageBinFile(inventoryService.getAllStorageBins(), path);
    }

    public void writeSectionStringToFile(Scanner sc) throws SQLException {
        WriteFile wf = new WriteFile();
        String path = fDBPath + "/section.csv";
        wf.writeSectionFile(inventoryService.getAllSections(), path);
    }

    public void itemsDataSplitted() throws SQLException {
        ReadFile rf = new ReadFile();
        String path = fDBPath + "/item.csv";
        List<Item> items = rf.readFileItemss(path);
        StorageBin sbin = null;
        for (Item item : items) {
            for (StorageBin sBin : inventoryService.getAllStorageBins()) {
                if (sBin.getItemId() == item.getId()) {
                    sbin = sBin;
                    break;
                }
            }
            if (sbin != null) {
                Section section = inventoryService.getSectionById2(sbin.getSectionId());
                Warehouse w = inventoryService.getWarehouseById(section.getWarehouseId());
                if (w != null) {
                    inventoryService.addItem(item, sbin.getQuantity(), section, w);
                }
            }
        }
    }

    public void sbinsDataSplitted() throws SQLException {
        ReadFile rf = new ReadFile();
        String path = fDBPath + "/sbin.csv";
        List<StorageBin> sbins = rf.readFileSbins(path);
        for (StorageBin s : sbins) {
            s.display();
            System.out.println("_________________________");
            Section section = inventoryService.getSectionById2(s.getSectionId());
            if (section != null) {
                Warehouse w = inventoryService.getWarehouseById(section.getWarehouseId());
                if (w != null) {
                    System.out.println("Adding Sbin to list...");
                    inventoryService.addStorageBin(s, section, w);
                }
            } else {
                System.out.println("Section NULL at this point.");
            }
        }
        System.out.println("Imported " + sbins.size() + " Sbin records from file.");
        Scanner sc = new Scanner(System.in);
        sc.nextLine();
    }

    public void sectionsDataSplitted(Scanner sc) {
        ReadFile rf = new ReadFile();
        String path = fDBPath + "/section.csv";
        List<Section> sections = rf.readFileSections(path);
        for (Section s : sections) {
            Warehouse w = inventoryService.getWarehouseById(s.getWarehouseId());
            inventoryService.addSection(s, w);
        }
        System.out.println("Imported " + sections.size() + " sections from file.");
        sc.nextLine();
        // new SectionRepository(sections);
        // SectionRepository.sections = sections;
    }

    public void writeWarehouseStringToFile(Scanner sc) throws SQLException {
        WriteFile wf = new WriteFile();
        String path = fDBPath + "/warehouse.csv";
        wf.writeWaRehouseFile(inventoryService.getAllWarehouses(), path);
    }

    public void warehousesDataSplitted(Scanner sc) {
        ReadFile rf = new ReadFile();
        String path = fDBPath + "/warehouse.csv";
        List<Warehouse> warehouses = rf.readFilWarehouses(path);
        WarehouseRepository.warehouses = warehouses;
    }

    public void printInventoryComponent(InventoryComponent ic) {
        ic.display();
    }

    public void updateSectionRecord(Scanner sc) {
        //
    }

    public void updateStorageBin(Scanner sc) {
        print("Update Storage Bin");
        print("Enter Warehouse ID: ");
        int warehosue_id = Integer.parseInt(sc.nextLine());
        Warehouse warehouse = inventoryService.getWarehouseById(warehosue_id);
        if (warehouse == null) {
            print("No such warehouse found, please enter again.");
            sc.nextLine();
            return;
        }

        print("Enter Section ID: ");
        int section_id = Integer.parseInt(sc.nextLine());
        Section section = inventoryService.getSectionById(section_id, warehouse);
        if (section == null) {
            print("No such section found in selected warehouse, please enter again.");
            sc.nextLine();
            return;
        }

        print("Enter Storage Bin ID: ");
        int sbinId = Integer.parseInt(sc.nextLine());
        StorageBin sbin = inventoryService.getStorageBinById(sbinId, warehouse);

        if (sbin == null) {
            print("No such Storage bin info found, please enter again.");
            sc.nextLine();
            return;
        }

        try {
            print("Bin ID: (" + sbin.getId() + "): ");
            sbin.setId(Integer.parseInt(sc.nextLine()));

            print("Shelf Number: (" + sbin.getShelfNumber() + "): ");
            sbin.setShelfNumber(Integer.parseInt(sc.nextLine()));

            print("Item ID: (" + sbin.getItemId() + "): ");
            sbin.setItemId(Integer.parseInt(sc.nextLine()));

            print("Quantity: (" + sbin.getQuantity() + "): ");
            sbin.setQuantity(Integer.parseInt(sc.nextLine()));

            print("Max Capacity: (" + sbin.getMaxCapacity() + "): ");
            sbin.setMaxCapacity(Integer.parseInt(sc.nextLine()));

            inventoryService.updateStorageBin(sbin, section, warehouse);
            print("Storage bin updated succeffully.");
            this.printInventoryComponent(sbin);
        } catch (Exception e) {
            print("Invalid input, please enter again.");
            e.printStackTrace();
            sc.nextLine();
            return;
        }
    }

    public void displayStorageBin(StorageBin sbin) {
        print("Section ID: " + sbin.getSectionId());
        print("Sbin ID: " + sbin.getId());
        print("Item ID: " + sbin.getItemId());
        print("Shelf Number: " + sbin.getShelfNumber());
        print("Quantity: " + sbin.getQuantity());
        print("Max Capacity: " + sbin.getMaxCapacity());
    }

    public void registerStorageBin(Scanner sc) {
        print("Register New Storage Bin");
        print("Enter Warehouse ID: ");
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
        // sbin.setSectionId(section_id);

        try {
            print("Storage Bin Id: ");
            int sbin_id = Integer.parseInt(sc.nextLine());
            // sbin.setItemId(sbin_id);

            print("Item Id: ");
            int item_id = Integer.parseInt(sc.nextLine());

            print("Quantity: ");
            int quantity = Integer.parseInt(sc.nextLine());
            // sbin.setQuantity(quantity);

            print("Max Capacity: ");
            int max_capacity = Integer.parseInt(sc.nextLine());

            print("Shelf Number: ");
            int shelf_number = Integer.parseInt(sc.nextLine());
            // sbin.setMaxCapacity(max_capacity);

            StorageBin sbin = new StorageBin(section_id, sbin_id, item_id, quantity, max_capacity, shelf_number);
            inventoryService.addStorageBin(sbin, section, warehouse);

            print("StorageBin registered successfully. press ENTER to continue");
            sc.nextLine();
            return;
        } catch (Exception e) {
            print("Invalid input, please enter again");
            e.printStackTrace();
            sc.nextLine();
            return;
        }
    }

    // private boolean

    public void registerItem() {
        Scanner sc = new Scanner(System.in);
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
                // print("Section Id: ");
                // section.setSectionId((Integer.parseInt(sc.nextLine())));
                print("Aisle Name: ");
                section.setAisleName(sc.nextLine());
                print("Max Capacity: ");
                section.setMaxCapacity(Integer.parseInt(sc.nextLine()));
                print("Current Occupancy");
                section.setCurrentCapacity(Integer.parseInt(sc.nextLine()));

                print("Shelf Number");
                section.setShelfNumber(Integer.parseInt(sc.nextLine()));

                
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

    public void updateWarehouseRecord(Scanner sc) {
        print("Update warehouse record:");
        print("Enter warehouse ID: ");
        int warehouse_id = Integer.parseInt(sc.nextLine());
        WarehouseRepository warehouseRepository = new WarehouseRepository();

        Warehouse whf = warehouseRepository.getWarehouseById(warehouse_id);
        Warehouse whn = new Warehouse();

        if (whf != null) {
            print("Warehouse ID: (" + whf.getWarehouseId() + ")");
            whn.setWarehouseId(Integer.parseInt(sc.nextLine()));

            print("Location: (" + whf.getLocation() + ")");
            whn.setLocation(sc.nextLine());

            print("Maximum Capacity: (" + whf.getMaxCapacity() + ")");
            whn.setMaxCapacity(Integer.parseInt(sc.nextLine()));

            print("Current Quantity: (" + whf.getCurrentQuantity() + ")");
            whn.setCurrentQuantity(Integer.parseInt(sc.nextLine()));

            print("Are you sure to save update? (Y/N)");
            String ch = sc.nextLine();
            if (ch.toUpperCase().equals("Y")) {
                warehouseRepository.updateWarehouse(whn);
                print("Ware house update Succesfull, Press ENTER to continue!");
                sc.nextLine();
                return;
            } else {
                print("Ware house update canceled, no change will be made to the warehouse record. press ENTER to continue!");
                sc.nextLine();
                return;
            }
        } else {
            print("Such warehouse record does not exist!");
            sc.nextLine();
            return;
        }

    }

    public void addWarehousesBulk(Scanner sc) {
        sc.nextLine();
        System.out.println("Enter Warehouses data in the following format separated by comma");
        System.out.println("warehouseId:Location:MaxCapacity:CurrentOccupancy");
        String warehousesData = sc.nextLine();
        String[] warehousesDataSplitted = warehousesData.split(",");

        for (String w : warehousesDataSplitted) {
            String[] warehouseString = w.split(":");
            Warehouse warehouse001 = new Warehouse();
            warehouse001.setWarehouseId(Integer.parseInt(warehouseString[0]));
            warehouse001.setLocation(warehouseString[1]);
            warehouse001.setMaxCapacity(Integer.parseInt(warehouseString[2]));
            warehouse001.setCurrentQuantity(Integer.parseInt(warehouseString[3]));
            inventoryService.addWarehouse(warehouse001);
        }

    }

    public void registerWareHouse() {
        // String fileName = "warehouses.ser";

        Scanner sc = new Scanner(System.in);
        try {
            print("\nRegister Warehouse Record:\n");
            sc.nextLine();
            Warehouse warehouse001 = new Warehouse();

            // System.out.println("Enter Warehouse ID : ");
            // warehouse001.setWarehouseId(sc.nextInt());
            // sc.nextLine();
            System.out.println("Enter Warehouse Location : ");
            warehouse001.setLocation(sc.nextLine());

            System.out.println("Enter Warehouse Max Capacity : ");
            warehouse001.setMaxCapacity(sc.nextInt());
            sc.nextLine();

            System.out.println("Enter Current Quantity : ");
            warehouse001.setCurrentQuantity(sc.nextInt());
            sc.nextLine();

            inventoryService.addWarehouse(warehouse001);
            print("\nWare house registered successfully\n");
        } catch (NumberFormatException e) {
            print("Invalid input detected, Please enter again");
        }
        sc.nextLine();
    }

    public void displayAllStorageBins() throws SQLException {
        if (!inventoryService.getAllStorageBins().isEmpty()) {
            print("______________________________________");
            for (StorageBin sbin : inventoryService.getAllStorageBins()) {
                displayStorageBin(sbin);
                print("______________________________________");
            }
        } else {
            System.out.println("You don't have any item");
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
        item.display();
    }

    public void showAllWareHouses() throws SQLException {
        List<Warehouse> warehouses = inventoryService.getAllWarehouses();
        if (!warehouses.isEmpty()) {
            // ic.displayMultiple((List<InventoryComponent>)warehouses);
            for (Warehouse warehouse : warehouses) {
                print("______________________________________");
                warehouse.display();
            }
            print("______________________________________");
        } else {
            System.out.println("You don't have any warehouses");
        }
    }

    public void showAllSectionsByWarehouse(Scanner sc) throws SQLException {
        int warehouse_id = Integer.parseInt(sc.nextLine());
        if (!inventoryService.getAllSectionsByWarehouse(warehouse_id).isEmpty()) {
            for (Section section : inventoryService.getAllSectionsByWarehouse(warehouse_id)) {
                print("______________________________________");
                section.display();
            }
            print("______________________________________");
        } else {
            System.out.println("You don't have any section");
        }
    }

    public void showAllSections() throws SQLException {
        if (!inventoryService.getAllSections().isEmpty()) {
            print("______________________________________");
            for (Section section : inventoryService.getAllSections()) {
                print("______________________________________");
                section.display();
            }
            print("______________________________________");
        } else {
            System.out.println("You don't have any section");
        }
    }

    public void displaySection(Section section) {
        section.display();
    }

    static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();

    }

    public static void print(String s) {
        System.out.println(s);
    }
}
