package com.gfacloud.did;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

public class StoreTest {
    public static void storeTest(Store store) {
        String label = "User1";
        String content = "User1 information";

        boolean ret = store.put(label, content);
        assertTrue(ret);
        assertTrue(store.exists(label));

        String result = store.get(label);
        assertNotNull(result);
        assertEquals(result, content);
        
        ArrayList<String> list = store.list();
        assertNotNull(list);
        assertEquals(list.size(), 1);
        
        ret = store.remove(label);
        assertTrue(ret);
        assertFalse(store.exists(label));
    } 
}
