package com.example.demo.data;

import org.springframework.cloud.gcp.data.datastore.repository.DatastoreRepository;

public interface ShoppingOrderRepository extends DatastoreRepository<ShoppingOrder, Long> {
}
