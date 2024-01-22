/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.invmgtsys.repository;

import java.util.ArrayList;
import java.util.List;

import com.mycompany.invmgtsys.models.StorageBin;

/**
 *
 * @author wonde
 */
public class StorageBinRepository {
    private List<StorageBin> storageBins = new ArrayList<>();
    public StorageBinRepository(List<StorageBin> storageBins) {
        this.storageBins = storageBins;
    }
    public void addStorageBin(StorageBin storageBin) {
        storageBins.add(storageBin);
    }

    public StorageBin getStorageBinById(int sbinId) {
        for (StorageBin storageBin : storageBins) {
            if (storageBin.getId() == sbinId) {
                return storageBin;
            }
        }
        return null;
    }

    public void updateStorageBin(StorageBin updatedStorageBin) {
        // StorageBin sbin = this.findStorageBinById(updatedStorageBin.getId());

        // if(sbin != null){
        // storageBins.set(updatedStorageBin.getId(), updatedStorageBin);
        // }

        for (int i = 0; i < storageBins.size(); i++) {
            if (storageBins.get(i).getId() == updatedStorageBin.getId()) {
                storageBins.set(i, updatedStorageBin);
            }
        }
    }

    public void deleteStorageBin(int sbinId) {
        for (StorageBin storageBin : storageBins) {
            if (storageBin.getId() == sbinId) {
                storageBins.remove(storageBin);
                break;
            }
        }

        // if deletion by object fails, go for removeById
        for (int i = 0; i < storageBins.size(); i++) {
            if (storageBins.get(i).getId() == sbinId) {
                storageBins.remove(i);
                return;
            }
        }
    }

    public List<StorageBin> getAllStorageBins() {
        return storageBins;
    }
}
