/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.invmgtsys.models;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author wonde
 */
public class Warehouse {
    int warehouse_id, capacity, current_quantity, max_capacity;
    String location;
    List<Section> sections;

    public void addSection(Section section) {
        this.sections.add(section);
    }

    public void setSections(List<Section> sections){
        this.sections = sections;
    }

    public List<Integer> getSectionsIds(){
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
}
