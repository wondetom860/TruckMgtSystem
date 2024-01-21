/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TruckMgtSystem.InvMgtSys.src.main.java.com.mycompany.invmgtsys.models;

import java.util.List;

/**
 *
 * @author wonde
 */
public class Warehouse {
    int warehouse_id, capacity, current_quantity;
    String location;
    List<Section> sections;

    public void addSection(Section section) {
        this.sections.add(section);
    }

    public void setSections(List<Section> sections){
        this.sections = sections;
    }

    public List<Section> getSections() {
        return this.sections;
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

    public int getCapacity() {
        return this.capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public void setCurrentCapacity(int current_quantity) {
        this.current_quantity = current_quantity;
    }

    public int getCurrentCapacity() {
        return this.current_quantity;
    }
}
