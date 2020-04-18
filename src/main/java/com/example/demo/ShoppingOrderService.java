package com.example.demo;

import com.example.demo.data.model.ShoppingOrder;
import com.example.demo.data.ShoppingOrderRepository;
import com.example.demo.data.model.Item;
import com.google.cloud.Timestamp;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

import java.util.*;

import static java.util.Calendar.JANUARY;

@ShellComponent
public class ShoppingOrderService {

    @Autowired
    private ShoppingOrderRepository shoppingOrderRepository;

    @ShellMethod("get order: get-order <id>")
    public String getOrder(long id) {
        Optional<ShoppingOrder> savedShoppingOrder = this.shoppingOrderRepository.findById(id);
        return savedShoppingOrder.get().toString();
    }

    @ShellMethod("get order: fetch-all-order")
    public String fetchAllOrder() {
        Iterable<ShoppingOrder> orders = this.shoppingOrderRepository.findAll();
        return Lists.newArrayList(orders).toString();
    }

    @ShellMethod("Save shopping order: save-order <id> <item> <item>")
    public String saveOrder(long id, String item1, String item2, String specialItem) {
        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
        calendar.set(1990, JANUARY, 1);
        Timestamp startDate = Timestamp.of(calendar.getTime());

        ShoppingOrder shoppingOrder = new ShoppingOrder();
        shoppingOrder.setId(id);
        List<Item> items = new ArrayList<>();
        shoppingOrder.setItems(items);

        Item firstItem = new Item();
        firstItem.setName(item1);
        firstItem.setTimeAddedToOrder(startDate);

        Item secondItem = new Item();
        secondItem.setName(item2);
        secondItem.setTimeAddedToOrder(startDate);

        Item splItem = new Item();
        splItem.setName(specialItem);
        splItem.setTimeAddedToOrder(startDate);
        shoppingOrder.setSpecialSingleItem(splItem);

        items.add(firstItem);
        items.add(secondItem);


        ShoppingOrder savedShoppingOrder = shoppingOrderRepository.save(shoppingOrder);
        return savedShoppingOrder.toString();
    }


}
