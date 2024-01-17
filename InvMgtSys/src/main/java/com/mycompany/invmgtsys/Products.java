package com.mycompany.invmgtsys;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
// import ;

public class Products {
    public static void main(String[] args) {
        // List<String> products = new ArrayList<String>();
        // List<String> products2 = new ArrayList<String>();
        // new Integer(5)

        System.out.println("Hello from Products class");
        List<Warehouse> warehouses = new ArrayList<Warehouse>();
        Warehouse wh = new Warehouse(1, 2, 2, new String("Addis Abeba"));
        wh.displayMenu(new Scanner(System.in), warehouses);
    }
}
