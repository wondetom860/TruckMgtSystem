package com.mycompany.invmgtsys.utility;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import com.mycompany.invmgtsys.models.*;

public class WriteFile {

    // Item
    public void writeItemFile(List<Item> items,String path){
        String itemString = "";
        for (Item item : items) {
            itemString += item.implodeString() + "\n";
        }
        writeItemStringToFile(itemString, path);
    }

    private void writeItemStringToFile(String itemString, String path) {
        try (FileWriter fw = new FileWriter(path)) {
            fw.write(itemString);
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    // StorageBin
    public void writeStorageBinFile(List<StorageBin> sbins, String path) {
        String sbinString = "";
        for (StorageBin sbin : sbins) {
            sbinString += sbin.implodeString() + "\n";
        }
        writeStorageBinStringToFile(sbinString, path);
    }

    private void writeStorageBinStringToFile(String sbinString, String path) {
        try (FileWriter fw = new FileWriter(path)) {
            fw.write(sbinString);
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Section
    public void writeSectionFile(List<Section> sections, String path) {
        String wString = "";
        for (Section section : sections) {
            wString += section.implodeString() + "\n";
        }
        writeSectionStringToFile(wString, path);
    }

    private void writeSectionStringToFile(String sString, String path) {
        try (FileWriter fw = new FileWriter(path)) {
            fw.write(sString);
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Warehouse
    public void writeWaRehouseFile(List<Warehouse> warehouses, String path) {
        String wString = "";
        for (Warehouse warehouse : warehouses) {
            wString += warehouse.implodeString() + "\n";
        }
        writeWarehouseStringToFile(wString, path);
    }

    private void writeWarehouseStringToFile(String wString, String path) {
        try (FileWriter fw = new FileWriter(path)) {
            fw.write(wString);
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
