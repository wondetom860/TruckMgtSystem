/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.invmgtsys.services;

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
    private SectionRepository sectionRepo;
    private StorageBinRepository stobinRepo;

    public InventoryService(){
        itemRepo = new ItemRepository();
        warehouseRepo = new WarehouseRepository();
        // sectionRepo = new SectionRepository();
        // stobinRepo = new StorageBinRepository();
    }

    // Warehouse
    public void addWarehouse(Warehouse warehouse){
        warehouseRepo.addWarehouse(warehouse);
    }

    public Warehouse getWarehouseById(int warehouse_id){
        return warehouseRepo.getWarehouseById(warehouse_id);
    }

    public void updateWarehouse(Warehouse updatedWarehouse){
        warehouseRepo.updateWarehouse(updatedWarehouse);
    }

    public List<Warehouse> getAllWarehouses(){
        return warehouseRepo.getAllWarehouses();
    }

    // Section
    public void addSection(Section section, Warehouse warehouse){

        sectionRepo.addSection(section);
    }

    public Section getSectionById(int section_id){
        return sectionRepo.getSectionById(section_id);
    }

    public void updateSection(Section updatedSection){
        sectionRepo.updateSection(updatedSection);
    }

    public List<Section> getAllSections(){
        return sectionRepo.getAllSections();
    }

    // StorageBin
    public void addStorageBin(StorageBin StorageBin){
        stobinRepo.addStorageBin(StorageBin);
    }

    public StorageBin getStorageBinById(int StorageBin_id){
        return stobinRepo.getStorageBinById(StorageBin_id);
    }

    public void updateStorageBin(StorageBin updatedStorageBin){
        stobinRepo.updateStorageBin(updatedStorageBin);
    }

    public List<StorageBin> getAllStorageBins(){
        return stobinRepo.getAllStorageBins();
    }

    // Item
    public void addItem(Item Item){
        itemRepo.addItem(Item);
    }

    public Item getItemById(int Item_id){
        return itemRepo.getItemById(Item_id);
    }

    public void updateItem(Item updatedItem){
        itemRepo.updateItem(updatedItem);
    }

    public List<Item> getAllItems(){
        return itemRepo.getAllItems();
    }


}
