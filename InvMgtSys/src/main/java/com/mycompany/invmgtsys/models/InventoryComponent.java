package com.mycompany.invmgtsys.models;

import java.util.ArrayList;
import java.util.List;

// import java.util.ArrayList;
// import java.util.List;

public abstract class InventoryComponent {
    protected String type = this.getClass().getSimpleName();

    public String getType() {
        return this.type;
    }

    public int getId() {
        return 0;
    }

    public abstract void display();

    public void displayAll(List<InventoryComponent> ics) {
        System.out.println("This will return list attributes of the model");
    }

    public void displayMultiple(List<InventoryComponent> components) {
        if (components.size() > 0) {
            for (int i = 0; i < components.size(); i++) {
                components.get(i).display();
            }
        }
    }

    public List<String> getHeaders() {
        System.out.println("This will return list attributes of the model");
        return new ArrayList<String>();
    }
}
