/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.invmgtsys.models;

import java.util.ArrayList;
import java.util.List;
// import java.util.Objects;

/**
 *
 * @author wonde
 */
public class Warehouse extends InventoryComponent implements Cloneable {
    int warehouse_id, capacity, current_quantity, max_capacity;
    String location;
    List<Section> sections;

    public String format = "%-30s%s%n";

    public void addSection(Section section) {
        this.sections.add(section);
    }

    public String implodeString() {

        return this.getId() + "," + this.getLocation() + "," + this.getMaxCapacity() + "," + this.getCurrentQuantity();
    }

    @Override
    public int getId() {
        return this.getWarehouseId();
    }

    public static int getId(Warehouse wh) {
        return wh.getWarehouseId();
    }

    public Warehouse(int w_id, int capacity, int current_quantity, int max_capacity, String location) {
        this.warehouse_id = w_id;
        this.capacity = capacity;
        this.current_quantity = current_quantity;
        this.max_capacity = max_capacity;
        this.location = location;
    }

    public Warehouse(int capacity, int current_quantity, int max_capacity, String location) {
        // this.warehouse_id = w_id;
        this.capacity = capacity;
        this.current_quantity = current_quantity;
        this.max_capacity = max_capacity;
        this.location = location;
    }

    public Warehouse() {
    }

    public Warehouse clonWarehouse() {
        return this.clonWarehouse();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Warehouse other = (Warehouse) obj;
        if (this.warehouse_id != other.warehouse_id) {
            return false;
        }
        if (this.capacity != other.capacity) {
            return false;
        }
        if (this.current_quantity != other.current_quantity) {
            return false;
        }
        if (this.max_capacity != other.max_capacity) {
            return false;
        }

        if (!this.location.equals(other.location)) {
            return false;
        }
        return true;
    }

    public void setSections(List<Section> sections) {
        this.sections = sections;
    }

    public List<Integer> getSectionsIds() {
        List<Integer> sectionIds = new ArrayList<>();
        if (this.sections != null) {
            for (Section section : sections) {
                sectionIds.add(section.getSectionId());
            }
        }
        return sectionIds;
    }

    public List<Section> getSections() {
        return this.sections == null ? new ArrayList<Section>() : this.sections;
    }

    public int getWarehouseId() {
        return this.warehouse_id;
    }

    public void setWarehouseId(int id) {
        this.warehouse_id = id;
    }

    public String getLocation() {
        return this.location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getMaxCapacity() {
        return this.max_capacity;
    }

    public void setMaxCapacity(int max_capacity) {
        this.max_capacity = max_capacity;
    }

    public int getCapacity() {
        return this.capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public void setCurrentQuantity(int current_quantity) {
        this.current_quantity = current_quantity;
    }

    public int getCurrentQuantity() {
        return this.current_quantity;
    }

    private List<List<String>> formatAttributeValues(Warehouse ws, int size) {
        List<List<String>> rowsList = new ArrayList<>();

        List<String> row = new ArrayList<>();
        row.add(ws.getWarehouseId() + "");
        row.add(ws.getLocation());
        row.add(ws.getMaxCapacity() + "");
        row.add(ws.getCurrentQuantity() + "");
        rowsList.add(row);

        return rowsList;
    }

    @Override
    public List<String> getHeaders() {
        List<String> headersList = new ArrayList<>();
        headersList.add("ID");
        headersList.add("Location");
        headersList.add("Max. Capacity");
        headersList.add("Current Quantity");

        return headersList;
    }

    @Override
    public void displayAll(List<InventoryComponent> warehouses) {

    }

    @Override
    public void display() {
        // super.display();
        System.out.printf(format, "Warehouse ID ", this.getWarehouseId());
        System.out.printf(format, "Warehouse Location :", this.getLocation());
        System.out.printf(format, "Warehouse Maximum Capacity :",
                this.getMaxCapacity());
        System.out.printf(format, "Warehouse Current Quantity :",
                this.getCurrentQuantity());
        System.out.printf(format, "Warehouse has ", (this.getSections() != null ? this.getSections().size() : 0)
                + " Sections,[" + this.getSectionsIds().toString() + "]");

        // TableGenerator tableGenerator = new TableGenerator();
        // List<String> headersList = this.getHeaders();
        // System.out.println(
        // tableGenerator.generateTable(headersList, this.formatAttributeValues(this,
        // headersList.size())));
    }

    // @Override
    // public String readFile() {

    // }

    // @Override
    // public void writeFile(String file) {
    // // TODO Auto-generated method stub
    // throw new UnsupportedOperationException("Unimplemented method 'writeFile'");
    // }
}
