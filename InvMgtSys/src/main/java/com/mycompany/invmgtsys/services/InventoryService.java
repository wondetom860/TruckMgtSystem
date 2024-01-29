/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.invmgtsys.services;

import java.sql.SQLException;
// import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import com.mycompany.invmgtsys.models.*;
import com.mycompany.invmgtsys.repository.*;

/**
 *
 * @author wonde
 */
public class InventoryService {
    private ItemRepository itemRepo;
    private WarehouseRepository warehouseRepo;
    private SectionRepository sectionR;
    private StorageBinRepository stobinRepo;

    public InventoryService() {
        itemRepo = new ItemRepository();
        warehouseRepo = new WarehouseRepository();
        // sectionRepo = new SectionRepository();
        // stobinRepo = new StorageBinRepository();
    }

    // Warehouse
    public void addWarehouse(Warehouse warehouse) {
        warehouseRepo.addWarehouse(warehouse);
    }

    public Warehouse getWarehouseById(int warehouse_id) {
        return warehouseRepo.getWarehouseById(warehouse_id);
    }

    public void updateWarehouse(Warehouse updatedWarehouse) {
        warehouseRepo.updateWarehouse(updatedWarehouse);
    }

    public List<Warehouse> getAllWarehouses() throws SQLException {
        return warehouseRepo.getAllWarehouses();
    }

    // Section
    public void addSection(Section section, Warehouse warehouse) {
        SectionRepository sr = new SectionRepository(warehouse.getSections());
        sr.addSection(section);
        warehouse.setSections(sr.getAllSections());
        this.updateWarehouse(warehouse);
    }

    public Section getSectionById2(int sectionId) throws SQLException {

        for (Section section : getAllSections()) {
            if (section.getId() == sectionId) {
                return section;
            }
        }

        return null;
    }

    public Section getSectionById(int sectionId, Warehouse warehouse) {
        SectionRepository sr = new SectionRepository(warehouse.getSections());
        return sr.getSectionById(sectionId);
    }

    public void updateSection(Section updatedSection, Warehouse warehouse) {
        SectionRepository sr = new SectionRepository(warehouse.getSections());
        sr.updateSection(updatedSection);
        warehouse.setSections(sr.getAllSections());
        this.updateWarehouse(warehouse);
    }

    public List<Section> getAllSectionsByWarehouse(int warehosue_id) throws SQLException {
        List<Section> allSections = new ArrayList<Section>();
        for (Warehouse w : this.getAllWarehouses()) {
            if (w.getWarehouseId() == warehosue_id) {
                allSections.addAll(w.getSections());
            }
        }
        return allSections;
    }

    public List<Section> getAllSections() throws SQLException {
        List<Section> allSections = new ArrayList<Section>();
        // allSections = SectionRepository.sections;
        for (Warehouse w : this.getAllWarehouses()) {
            allSections.addAll(w.getSections());
        }
        return allSections;
    }

    // StorageBin
    public void addStorageBin(StorageBin storageBin, Section section, Warehouse warehouse) {
        StorageBinRepository storageR = new StorageBinRepository(section.getStorageBins());
        SectionRepository sectionR = new SectionRepository(warehouse.getSections());
        storageR.addStorageBin(storageBin);
        section.setStorageBins(storageR.getAllStorageBins());

        sectionR.updateSection(section);
        warehouse.setSections(sectionR.getAllSections());
        this.updateWarehouse(warehouse);
    }

    public StorageBin getStorageBinById(int binId, Warehouse warehouse) {

        SectionRepository sectionR = new SectionRepository(warehouse.getSections());
        for (Section section : warehouse.getSections()) {
            StorageBinRepository storageR = new StorageBinRepository(section.getStorageBins());
            StorageBin sb = storageR.getStorageBinById(binId);
            if (sb != null) {
                return sb;
            }
        }
        return null;
    }

    public void updateStorageBin(StorageBin updatedStorageBin, Section section, Warehouse warehouse) {
        StorageBinRepository storageR = new StorageBinRepository(section.getStorageBins());
        SectionRepository sectionR = new SectionRepository(warehouse.getSections());
        storageR.updateStorageBin(updatedStorageBin);
        section.setStorageBins(storageR.getAllStorageBins());
        sectionR.updateSection(section);
        warehouse.setSections(sectionR.getAllSections());
        this.updateWarehouse(warehouse);

    }

    public List<StorageBin> getAllStorageBins() throws SQLException {
        List<StorageBin> allStorageBins = new ArrayList<StorageBin>();
        for (Warehouse w : this.getAllWarehouses()) {
            for (Section s : w.getSections()) {
                allStorageBins.addAll(s.getStorageBins());
            }
        }
        return allStorageBins;

    }

    // Item Operations

    public void addItem(Item item, int quantity, Section section, Warehouse warehouse) {
        if (this.itemRepo.getItemById(item.getId()) == null) {
            this.itemRepo.addItem(item);
        }
        StorageBinRepository storageR = new StorageBinRepository(section.getStorageBins());
        SectionRepository sectionR = new SectionRepository(warehouse.getSections());
        for (StorageBin sb : storageR.getAllStorageBins()) {
            if (sb.getId() == item.getId() && sb.getQuantity() + quantity <= sb.getMaxCapacity()) {
                sb.setQuantity(sb.getQuantity() + quantity);
                storageR.updateStorageBin(sb);
                section.setStorageBins(storageR.getAllStorageBins());
                sectionR.updateSection(section);
                warehouse.setSections(sectionR.getAllSections());
                this.updateWarehouse(warehouse);
            }
        }
    }

    // Item
    // public int[] getItemWarehouseIds(int item_id){
    // // int[] itemWarehouseIds = new Array();

    // return new Integer();
    // }
    public Item getItemById(int Item_id) {
        return itemRepo.getItemById(Item_id);
    }

    public void updateItem(Item updatedItem) {
        itemRepo.updateItem(updatedItem);
    }

    public List<Item> getAllItems() {
        return itemRepo.getAllItems();
    }

}
