package com.gfacloud.did;

import org.junit.Test;

public class FileSystemStoreTest {
   
    @Test
    public void fileSystemStoreTest() {
        FileSystemStore store = new FileSystemStore("./wallet");
        StoreTest.storeTest(store);
    }
}
