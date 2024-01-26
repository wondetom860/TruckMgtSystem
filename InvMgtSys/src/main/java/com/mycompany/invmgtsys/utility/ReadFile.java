package com.mycompany.invmgtsys.utility;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
// import java.util.Scanner;
import java.util.Scanner;

import com.mycompany.invmgtsys.models.*;

public class ReadFile {
    public static void main(String[] args) {
        //
    }

    // Storage Bin
    public List<Item> readFileItemss(String path) {
        List<Item> items = new ArrayList<Item>();
        try {
            FileReader fileReader = new FileReader(path);
            try (BufferedReader bfreader = new BufferedReader(fileReader)) {
                String texString = bfreader.readLine();
                while (texString != null) {
                    Item item = extractItem(texString);
                    items.add(item);
                    texString = bfreader.readLine();
                }
                Scanner sc = new Scanner(System.in);
                sc.nextLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return items;
    }

    public Item extractItem(String text) {
        String[] itemData = text.split(",");
        Item item = new Item();
        item.setId(Integer.parseInt(itemData[0]));
        item.setName(itemData[1]);
        item.setDescription(itemData[2]);
        return item;
    }

    // Storage Bin
    public List<StorageBin> readFileSbins(String path) {
        List<StorageBin> storageBins = new ArrayList<StorageBin>();
        try {
            FileReader fileReader = new FileReader(path);
            try (BufferedReader bfreader = new BufferedReader(fileReader)) {
                // System.out.println("Read file...");
                String texString = bfreader.readLine();
                while (texString != null) {
                    StorageBin storageBin = extractSbin(texString);
                    // storageBin.display();
                    // System.out.println("________________________________________");
                    storageBins.add(storageBin);
                    texString = bfreader.readLine();
                }
                Scanner sc = new Scanner(System.in);
                sc.nextLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return storageBins;
    }

    public StorageBin extractSbin(String text) {
        String[] sbinData = text.split(",");
        StorageBin sbin = new StorageBin();
        sbin.setId(Integer.parseInt(sbinData[0]));
        sbin.setSectionId(Integer.parseInt(sbinData[1]));
        sbin.setItemId(Integer.parseInt(sbinData[2]));
        sbin.setQuantity(Integer.parseInt(sbinData[3]));
        sbin.setMaxCapacity(Integer.parseInt(sbinData[4]));
        sbin.setShelfNumber(Integer.parseInt(sbinData[5]));

        return sbin;
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
                    texString = bfreader.readLine();
                }
                // Scanner sc = new Scanner(System.in);
                // sc.nextLine();
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
