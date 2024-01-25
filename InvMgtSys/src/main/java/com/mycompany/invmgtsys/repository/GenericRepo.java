package com.mycompany.invmgtsys.repository;

import java.util.List;

import com.mycompany.invmgtsys.models.InventoryComponent;
import com.mycompany.invmgtsys.models.Warehouse;

// import com.mycompany.invmgtsys.models.Item;

// import com.mycompany.invmgtsys.models.Item;

public class GenericRepo<T> {
    public List<T> generics;

    public GenericRepo(List<T> generics) {
        this.generics = generics;
    }

    public void add(T t) {
        generics.add(t);
    }

    public T getById(int id) {
        for (T t : generics) {
            if (((InventoryComponent)t).getId() == id) {
                return t;
            }
        }
        return null;
    }

    public List<T> getAll() {
        return generics;
    }

    // public void display() {
    // for (T t : generics) {
    // display();
    // }
    // }
}
