package TruckMgtSystem.InvMgtSys.src.main.java.com.mycompany.invmgtsys.app;

import TruckMgtSystem.InvMgtSys.src.main.java.com.mycompany.invmgtsys.models.*;
import TruckMgtSystem.InvMgtSys.src.main.java.com.mycompany.invmgtsys.repository.WarehouseRepository;
import TruckMgtSystem.InvMgtSys.src.main.java.com.mycompany.invmgtsys.services.InventoryService;

public class InventoryManager {
    InventoryService INVS = new InventoryService();

    public void startManager() {
        if (INVS.getAllWarehouses().isEmpty()) {
            System.out.println("Warehouse list empty");
        } else {
            System.out.println("All Warehouses");
            for (Warehouse warehouse : INVS.getAllWarehouses()) {
                System.out.println("\nWarehouses:");
                System.out.println("\nWareHouse ID: " + warehouse.getWarehouseId());
                System.out.println("Capacity: " + warehouse.getCapacity());
                System.out.println("Location: " + warehouse.getLocation());
            }
        }

        Warehouse ws1 = new Warehouse();
        ws1.setWarehouseId(1);
        ws1.setCapacity(300);
        ws1.setCurrentCapacity(3);
        ws1.setLocation("Addis Abeba");
        // ws1.set

        WarehouseRepository wRepository = new WarehouseRepository();
        wRepository.addWarehouse(ws1);

        if (INVS.getAllWarehouses().isEmpty()) {
            System.out.println("Warehouse list empty");
        } else {
            System.out.println("All Warehouses");
            for (Warehouse warehouse : INVS.getAllWarehouses()) {
                System.out.println("\nWarehouses:");
                System.out.println("\nWareHouse ID: " + warehouse.getWarehouseId());
                System.out.println("Capacity: " + warehouse.getCapacity());
                System.out.println("Location: " + warehouse.getLocation());
            }
        }
    }
}
