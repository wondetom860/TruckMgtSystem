/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.invmgtsys.models;

import java.util.ArrayList;

/**
 *
 * @author wonde
 */
public class Item extends InventoryComponent{
    private int item_id;
    private String name, description;
    public String format = "%-40s%s%n";

    public int getItem_id() {
        return item_id;
    }

    public void setItem_id(int item_id) {
        this.item_id = item_id;
    }

    public String getName(){
        return this.name;
    }
    public void setName(String name){
        this.name = name;
    }

    public void setId(int id){
        this.item_id = id;
    }

    public int getId(){
        return this.item_id;
    }

    public void setDescription(String desc){
        this.description = desc;
    }

    public String getDescription(){
        return this.description;
    }

    @Override
    public void display(){
        super.display();
        System.out.printf(format,"Item Name:",this.name);
        System.out.printf(format,"Item ID:",this.item_id);
        System.out.printf(format,"Description:",this.description);
    }

    public void displayAll(ArrayList<Item> items){
        for (Item item : items) {
            System.out.println("_________________________________");
            item.display();
        }
        System.out.println("_________________________________");
    }
}
