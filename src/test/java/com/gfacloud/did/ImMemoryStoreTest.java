package com.gfacloud.did;

import org.junit.Test;

public class ImMemoryStoreTest {
    @Test
    public void inMemoryStoreTest() {
        InMemoryStore store = new InMemoryStore();
        StoreTest.storeTest(store);
    }
}
