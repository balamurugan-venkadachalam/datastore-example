package com.example.demo.data;

import com.example.demo.data.model.ShoppingOrder;
import org.springframework.cloud.gcp.data.datastore.repository.DatastoreRepository;

public interface ShoppingOrderRepository extends DatastoreRepository<ShoppingOrder, Long> {
}
