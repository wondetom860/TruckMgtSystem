package com.mycompany.invmgtsys.app;

// import com.mycompany.invmgtsys.models.*;
// import com.mycompany.invmgtsys.models.Warehouse;

// import java.util.Scanner;
// import TruckMgtSystem.InvMgtSys.src.main.java.com.mycompany.invmgtsys.services.*;
// import TruckMgtSystem.InvMgtSys.src.main.java.com.mycompany.invmgtsys.models.*;
// import TruckMgtSystem.InvMgtSys.src.main.java.com.mycompany.invmgtsys.repository.*;

public class Main {
    public static void main(String[] args) {
        // Warehouse warehouse = new Warehouse();
        // warehouse.display();
        InventoryManager inventoryManager = new InventoryManager();
        inventoryManager.startManager();
    }
}
