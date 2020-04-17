package com.example.demo;

import com.google.cloud.Timestamp;
import com.google.cloud.datastore.*;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * A snippet for Google Cloud Datastore showing how to get an entity and update it if it exists.
 */
public class UpdateEntity {
    public static Datastore datastore = DatastoreOptions.getDefaultInstance().getService();
    public static KeyFactory keyFactory = datastore.newKeyFactory().setKind("Task");

    public static void main(String... args) throws Exception {

        ExecutorService executorService = Executors.newFixedThreadPool(5);
        for (int j = 0; j < 20; j++) {

            executorService.execute(() -> {
                System.out.println("Starting new Thread " + Thread.currentThread());
                for (int i = 0; i < 20; i++) {
                    Key key = keyFactory.newKey(5709113312935936l);
                    Entity entity = datastore.get(key);
                    System.out.print(Thread.currentThread() + " Updating Entity : " + i);
                    if (entity != null) {
                        System.out.println(" Updating access_time for " + entity.getString("description"));
                        entity = Entity.newBuilder(entity).set("access_time", Timestamp.now()).set("Counter", entity.getLong("Counter") + 1).build();
                        datastore.update(entity);
                    }
                    //TimeUnit.SECONDS.sleep(1);
                }


            });
        }

        executorService.shutdown();

        System.out.println("Completed");
    }

}