/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.BMS.Models;

import javax.persistence.Entity;
import javax.persistence.Id;
//import javax.persistence.ManyToOne;

/**
 *
 * @author HIMAJA PARACHURI
 */
@Entity
public class Store {
    @Id
    private int storeId;
    private String storeName;
    private String Address;

    public void setStoreId(int storeId) {
        this.storeId = storeId;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }


    public int getStoreId() {
        return storeId;
    }

    public String getStoreName() {
        return storeName;
    }

    public String getAddress() {
        return Address;
    }

    @Override
    public String toString() {
        return "Store Name=" + storeName + ", Address=" + Address;
    }

    }
    
