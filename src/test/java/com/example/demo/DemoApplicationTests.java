package com.example.demo;

import com.example.demo.data.model.Item;
import com.example.demo.data.model.ShoppingOrder;
import com.example.demo.data.ShoppingOrderRepository;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

	@Autowired
	private ShoppingOrderRepository repository;

	@Test
	public void contextLoads() {
	}

	@Test
	public void testEmbaddedObject() throws IOException, InterruptedException {
		ShoppingOrder shoppingOrder = new ShoppingOrder();
		shoppingOrder.setId(1212121l);
		List<Item> items = new ArrayList<>();
		shoppingOrder.setItems(items);
		ShoppingOrder savedShoppingOrder = repository.save(shoppingOrder);
		Assert.assertNotNull(savedShoppingOrder);
	}
}
