package com.example.demo;

import com.google.cloud.datastore.Datastore;

import com.google.cloud.datastore.DatastoreOptions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

	@Test
	public void contextLoads() {
	}

	@Test
	public void test1() throws IOException, InterruptedException {
		// keyFactory = datastore.newKeyFactory().setKind("TestEntity");
		//DatastoreOptions.getDefaultInstance().getService();
		Datastore ds = DatastoreOptions.newBuilder().setHost("http://localhost:8081").setProjectId("my-project-id").build().getService();
		com.google.cloud.datastore.Key key = ds.newKeyFactory().setKind("MyEntity").newKey("mykey");
		com.google.cloud.datastore.Entity entity = com.google.cloud.datastore.Entity.newBuilder(key).set("p1", "Hello World!").build();
		entity = ds.put(entity);
		entity = ds.get(key);
		System.out.println(entity);
	}
}
