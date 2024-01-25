package com.mycompany.invmgtsys.app.File;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileRead {
    public String[] readFilWarehouses(String path) {
        // String path = "warehouse.csv";
        int numberofLine = 3;
        String textData[] = new String[3];
        try {
            FileReader fileReader = new FileReader(path);
            try (BufferedReader bfreader = new BufferedReader(fileReader)) {
                for (int i = 0; i < numberofLine; i++) {
                    textData[i] = bfreader.readLine();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return textData;
    }
}
