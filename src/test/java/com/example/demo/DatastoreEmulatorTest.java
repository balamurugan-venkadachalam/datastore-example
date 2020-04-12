package com.example.demo;

import com.google.cloud.datastore.Datastore;
import com.google.cloud.datastore.DatastoreOptions;
import com.google.cloud.datastore.Entity;
import com.google.cloud.datastore.KeyFactory;
import com.google.cloud.datastore.testing.LocalDatastoreHelper;


import org.junit.*;
import static org.junit.Assert.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class DatastoreEmulatorTest {

    protected static LocalDatastoreHelper localDatastoreHelper;

    protected Datastore datastore;

    protected KeyFactory keyFactory;

    @BeforeClass
    public static void setUpClass() throws InterruptedException, IOException {
        // create and start a local datastore emulator on a random free port
        // this also means that you probably can run tests like this concurrently.
        System.out.println("[Datastore-Emulator] start");
        localDatastoreHelper = LocalDatastoreHelper.create();
        localDatastoreHelper.start();
        System.out.println("[Datastore-Emulator] listening on port: " + localDatastoreHelper.getPort());

        // set the system property to tell the gcloud lib to use the datastore emulator
        System.setProperty("DATASTORE_EMULATOR_HOST","localhost:" + localDatastoreHelper.getPort());
    }

    @Before
    public void setUp() {
        // create the datastore instance
        // because of the system property set it in setUpClass() this
        // datastore will be connected with the datastore emulator.
        datastore = DatastoreOptions.getDefaultInstance().getService();
        keyFactory = datastore.newKeyFactory().setKind("TestEntity");
    }

    @After
    public void tearDown() throws IOException {
        System.out.println("[Datastore-Emulator] reset");
        // this resets the datastore after every test
        localDatastoreHelper.reset();
    }

    @AfterClass
    public static void tearDownClass() throws InterruptedException, IOException, TimeoutException {
        System.out.println("[Datastore-Emulator] stop");
        // this stops the datastore emulator after all tests are done
        localDatastoreHelper.stop();
    }

    @Test
    public void test1() {
        // stores an entity in the datastore and retrieves it later

        // create an Entity "TestEntity"
        Entity.Builder builder = Entity.newBuilder(keyFactory.newKey(42));
        builder.set("name", "Test1");

        // store it in datastore
        datastore.put(builder.build());

        // retrieve entity by key
        Entity entity = datastore.get(keyFactory.newKey(42));
        assertNotNull(entity);
        assertEquals("Test1", entity.getString("name"));
    }

    @Test
    public void test2() {
        // try to access the entity created in test1, shouldn't work because
        // of calling reset in tearDown() after each test.

        // try to retrieve entity by key
        Entity entity = datastore.get(keyFactory.newKey(42));
        assertNull(entity);
    }
}