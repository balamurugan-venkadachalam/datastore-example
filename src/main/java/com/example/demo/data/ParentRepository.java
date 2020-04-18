package com.example.demo.data;

import com.example.demo.data.model.Parent;
import org.springframework.cloud.gcp.data.datastore.repository.DatastoreRepository;

public interface ParentRepository extends DatastoreRepository<Parent, String> {
}
