package com.example.demo.data;

import com.google.cloud.Timestamp;
import com.google.cloud.datastore.Key;
import org.springframework.cloud.gcp.data.datastore.core.mapping.Descendants;
import org.springframework.cloud.gcp.data.datastore.core.mapping.Entity;
import org.springframework.data.annotation.Id;

import java.util.List;

@Entity(name = "orders")
public class ShoppingOrder {
  @Id
  long id;

  @Descendants
  List<Item> items;
}
