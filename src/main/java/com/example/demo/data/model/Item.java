package com.example.demo.data.model;

import com.google.cloud.Timestamp;
import com.google.cloud.datastore.Key;
import org.springframework.cloud.gcp.data.datastore.core.mapping.Entity;
import org.springframework.data.annotation.Id;


@Entity(name = "purchased_item")
public class Item {
    @Id
    private Key purchasedItemKey;
    private String name;
    private Timestamp timeAddedToOrder;

    public Key getPurchasedItemKey() {
        return purchasedItemKey;
    }

    public void setPurchasedItemKey(Key purchasedItemKey) {
        this.purchasedItemKey = purchasedItemKey;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Timestamp getTimeAddedToOrder() {
        return timeAddedToOrder;
    }

    public void setTimeAddedToOrder(Timestamp timeAddedToOrder) {
        this.timeAddedToOrder = timeAddedToOrder;
    }

    @Override
    public String toString() {
        return "Item{" +
                "purchasedItemKey=" + purchasedItemKey +
                ", name='" + name + '\'' +
                ", timeAddedToOrder=" + timeAddedToOrder +
                '}';
    }
}