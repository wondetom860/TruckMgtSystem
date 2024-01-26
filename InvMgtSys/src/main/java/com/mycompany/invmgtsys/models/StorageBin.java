/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.invmgtsys.models;

import java.util.ArrayList;

/**
 *
 * @author wonde
 */
public class StorageBin extends InventoryComponent {
    private int bin_id, section_id, item_id, quantity, max_capacity, shelf_number;
    @Override
    public String implodeString() {
        return this.getId()+","+this.getSectionId()+","+this.getItemId()+","+this.getQuantity()+","+this.getMaxCapacity()+","+this.getShelfNumber();
    }
    public String format = "%-40s%s%n";
    // public void display(StorageBin bin) {
    // System.out.println("");
    // System.out.println("Section ID:\t" + bin.section_id);// this should display
    // section description =>
    // // bin.getSection()
    // System.out.println("Bin ID:\t" + bin.bin_id);
    // System.out.println("Item ID:\t" + bin.item_id);
    // System.out.println("Quantity:\t" + bin.quantity);
    // System.out.println("Max Capacity:\t" + bin.max_capacity);
    // System.out.println("");
    // }

    public int getShelfNumber() {
        return shelf_number;
    }

    public void setShelfNumber(int shelf_number) {
        this.shelf_number = shelf_number;
    }

    public StorageBin() {
    }

    // StorageBin(section_id, sbin_id,item_id, quantity, max_capacity,shelf_number)
    public StorageBin(int section_id, int sbin_id, int item_id, int quantity, int max_capacity, int shelf_number) {
        this.section_id = section_id;
        this.item_id = item_id;
        this.bin_id = sbin_id;
        this.quantity = quantity;
        this.max_capacity = max_capacity;
        this.shelf_number = shelf_number;
    }

    // private Section getSection(){
    // Section sectionObject = new Section();
    // sectionObject = sectionObject.getSectionById(this.section_id);

    // }

    public void displayAll(ArrayList<StorageBin> bins) {
        for (StorageBin bin : bins) {
            bin.display();
        }
    }

    public void setId(int id) {
        this.bin_id = id;
    }

    @Override
    public int getId() {
        return this.bin_id;
    }

    public int getSectionId() {
        return this.section_id;
    }

    public void setSectionId(int section_id) {
        this.section_id = section_id;
    }

    public int getItemId() {
        return this.item_id;
    }

    public void setItemId(int item_id) {
        this.item_id = item_id;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setMaxCapacity(int max_capacity) {
        this.max_capacity = max_capacity;
    }

    public int getMaxCapacity() {
        return this.max_capacity;
    }

    @Override
    public void display() {
        System.out.printf(format, "Section ID: ", this.getSectionId());
        System.out.printf(format, "Sbin ID: ", this.getId());
        System.out.printf(format, "Item ID: ", this.getItemId());
        System.out.printf(format, "Shelf Number: ", this.getShelfNumber());
        System.out.printf(format, "Quantity: ", this.getQuantity());
        System.out.printf(format, "Max Capacity: ", this.getMaxCapacity());
    }
}
