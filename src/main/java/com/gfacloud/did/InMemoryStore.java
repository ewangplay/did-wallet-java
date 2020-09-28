package com.gfacloud.did;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class InMemoryStore implements Store {
    private Map<String, String> storage;

    public InMemoryStore() {
        storage = new HashMap<String, String>();
    }

    @Override
    public boolean put(String label, String content) {
        storage.put(label, content);
        return true;
    }

    @Override
    public String get(String label) {
        return storage.get(label);
    }

    @Override
    public ArrayList<String> list() {
        ArrayList<String> keys = new ArrayList<String>();
        Set<String> keySet = storage.keySet();
        for (String s : keySet) {
            keys.add(s);
        }
        Collections.sort(keys);
        return keys;
    }

    @Override
    public boolean exists(String label) {
        return storage.containsKey(label);
    }

    @Override
    public boolean remove(String label) {
        storage.remove(label);
        return true;
    }
}
