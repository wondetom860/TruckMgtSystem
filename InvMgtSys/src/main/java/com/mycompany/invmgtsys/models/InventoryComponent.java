package com.mycompany.invmgtsys.models;

import java.util.List;

// import java.util.ArrayList;
// import java.util.List;

public class InventoryComponent {
    protected String type = this.getClass().getSimpleName();

    public String getType() {
        return this.type;
    }

    public void display() {
        System.out.println("This is from [ " + type + " ]");
    }
   
    public void displayMultiple( List<InventoryComponent> components){
        if (components.size() > 0) {
            for (int i = 0; i < components.size(); i++) {
                components.get(i).display();
            }
        }
    }
}
