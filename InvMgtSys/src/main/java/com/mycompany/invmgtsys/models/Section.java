/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.invmgtsys.models;

import java.util.ArrayList;
import java.util.List;

import com.mycompany.invmgtsys.repository.WarehouseRepository;

/**
 *
 * @author wonde
 */
public class Section extends InventoryComponent {
    private int section_id, max_capacity, current_occupancy, warehouse_id, shelf_number;
    private String aisle_name;
    private List<StorageBin> storage_bins;

    @Override
    public String implodeString() {
        return  this.getId()+","+
                this.getAisleName()+","+
                this.getMaxCapacity()+","+
                this.getCurrentCapacity()+","+
                this.getWarehouseId()+","+
                this.getShelfNumber();
    }
    public String format = "%-40s%s%n";

    @Override
    public void display() {
        System.out.printf(format, "Warehouse ID :", this.getWarehouseId());
        System.out.printf(format, "Section ID :", this.getSectionId());
        System.out.printf(format, "Aisle Name :", this.getAisleName());
        System.out.printf(format, "Max. Capacity : ", this.getMaxCapacity());
        System.out.printf(format, "Current Capacity : ", this.getCurrentCapacity());
        System.out.printf(format, "Storage Bins Count : ",
                (this.getStorageBins() != null ? this.getStorageBins().size() : 0));
    }

    public void displayAll(ArrayList<Section> sections) {
        for (Section section : sections) {
            System.out.println("_______________________________________");
            section.display();
        }
        System.out.println("_______________________________________");
    }

    public int getShelfNumber() {
        return this.shelf_number;
    }

    public void setShelfNumber(int sh_no) {
        this.shelf_number = sh_no;
    }

    public int getSectionId() {
        return this.section_id;
    }

    public void setSectionId(int id) {
        this.section_id = id;
    }

    @Override
    public int getId() {
        return this.getSectionId();
    }

    public void setMaxCapacity(int max_capacity) {
        this.max_capacity = max_capacity;
    }

    public int getMaxCapacity() {
        return this.max_capacity;
    }

    public void setCurrentCapacity(int current_occupancy) {
        this.current_occupancy = current_occupancy;
    }

    public int getCurrentCapacity() {
        return this.current_occupancy;
    }

    // public Section getSectionById(int section_id){
    // return this.findById(section_id);
    // }

    // private Section findById(int section_id){

    // }

    public int getWarehouseId(int section_id) {
        WarehouseRepository whr = new WarehouseRepository();
        for (Warehouse warehouse : whr.getAllWarehouses()) {
            for (Section section : warehouse.getSections()) {
                if (section.getSectionId() == section_id) {
                    return warehouse.getWarehouseId();
                }
            }
        }

        return 0;
    }

    public int getWarehouseId() {
        return this.warehouse_id;
    }

    public void setWarehouseId(int id) {
        this.warehouse_id = id;
    }

    public String getAisleName() {
        return this.aisle_name;
    }

    public void setAisleName(String name) {
        this.aisle_name = name;
    }

    public void setStorageBins(List<StorageBin> storageBins) {
        this.storage_bins = storageBins;
    }

    public void addStorageBin(StorageBin stbn) {
        storage_bins.add(stbn);
    }

    public List<StorageBin> getStorageBins() {
        return this.storage_bins == null ? new ArrayList<StorageBin>() : this.storage_bins;
    }
}
