package com.mycompany.invmgtsys.repository;

import java.util.ArrayList;
// import java.util.List;

import com.mycompany.invmgtsys.models.Item;
import com.mycompany.invmgtsys.models.Warehouse;

public class Demo {
    public static void main(String[] args) {
        GenericRepo<Item> itemsRepo = new GenericRepo<>(new ArrayList<>());
        itemsRepo.add(new Item(1, "Item 2", "Item 2 Description"));
        for (Item item : itemsRepo.getAll()) {
            item.display();
        }

        GenericRepo<Warehouse> warehouseRepo = new GenericRepo<>(new ArrayList<>());
        warehouseRepo.add(new Warehouse(1, 2000, 120, 2000,"AA"));

        for (Warehouse warehouse : warehouseRepo.getAll()) {
            warehouse.display();
        }

        warehouseRepo.getById(1).display();
        itemsRepo.getById(1).display();
    }
}
