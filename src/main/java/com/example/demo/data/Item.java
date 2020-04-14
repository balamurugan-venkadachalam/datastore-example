package com.example.demo.data;
import com.google.cloud.Timestamp;
import com.google.cloud.datastore.Key;
import org.springframework.cloud.gcp.data.datastore.core.mapping.Descendants;
import org.springframework.cloud.gcp.data.datastore.core.mapping.Entity;
import org.springframework.data.annotation.Id;


@Entity(name = "purchased_item")
public class Item {
  @Id
  Key purchasedItemKey;

  String name;

  Timestamp timeAddedToOrder;
}