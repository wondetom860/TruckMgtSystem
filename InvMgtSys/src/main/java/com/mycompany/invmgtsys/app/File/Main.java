package com.mycompany.invmgtsys.app.File;

public class Main {
    public static void main(String[] args) {
        String path = "warehouse.csv";
        FileRead rf = new FileRead();

        String[] whStrings = rf.readFilWarehouses(path);
        for (String whString : whStrings) {
            // warehouseData[3] = whString.split(',');
        }
    }
}
