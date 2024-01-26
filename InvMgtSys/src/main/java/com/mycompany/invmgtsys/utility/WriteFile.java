package com.mycompany.invmgtsys.utility;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import com.mycompany.invmgtsys.models.*;

public class WriteFile {

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
