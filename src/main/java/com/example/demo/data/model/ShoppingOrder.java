package com.example.demo.data.model;

import com.example.demo.data.model.Item;
import org.springframework.cloud.gcp.data.datastore.core.mapping.Descendants;
import org.springframework.cloud.gcp.data.datastore.core.mapping.Entity;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Reference;

import java.util.List;

@Entity(name = "orders")
public class ShoppingOrder {
    @Id
    private long id;

    @Descendants
    private List<Item> items;

/*
    @Reference
    Item specialSingleItem;

    public Item getSpecialSingleItem() {
        return specialSingleItem;
    }

    public void setSpecialSingleItem(Item specialSingleItem) {
        this.specialSingleItem = specialSingleItem;
    }
*/


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "ShoppingOrder{" +
                "id=" + id +
                ", items=" + items +/*
                ", specialSingleItem=" + specialSingleItem +*/
                '}';
    }
}
