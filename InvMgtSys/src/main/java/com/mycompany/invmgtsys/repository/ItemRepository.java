/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TruckMgtSystem.InvMgtSys.src.main.java.com.mycompany.invmgtsys.repository;

import java.util.ArrayList;
import java.util.List;
import TruckMgtSystem.InvMgtSys.src.main.java.com.mycompany.invmgtsys.models.Item;

/**
 *
 * @author wonde
 */
public class ItemRepository {
    private static List<Item> items = new ArrayList<>();

    public void addItem(Item item){
        items.add(item);
    }

    public Item getItemById(int itemId){
        for (Item item : items) {
            if (item.getId() == itemId) {
                return item;
            }
        }

        return null;
    }

    public void updateItem(Item updatedItem){
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getId() == updatedItem.getId()) {
                items.set(i, updatedItem);
                break;
            }
        }
    }

    public  void deleteItem(int itemId){
        for (Item item : items) {
            if(item.getId() == itemId){
                items.remove(item);
                break;
            }
        }

        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getId() == itemId) {
                items.remove(i);
                return;
            }
        }
    }

    public List<Item> getAllItems(){
        return items;
    }
}
