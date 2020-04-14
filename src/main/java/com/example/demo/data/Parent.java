package com.example.demo.data;

import org.springframework.cloud.gcp.data.datastore.core.mapping.Entity;
import org.springframework.data.annotation.Id;

@Entity(name = "parents")
public class Parent {
  @Id
  String name;

  Child child;
}

