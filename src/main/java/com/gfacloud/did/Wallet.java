package com.gfacloud.did;

import java.util.ArrayList;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

public class Wallet {
    private Store store;

    public Wallet() {
        this.store = new InMemoryStore();
    }

    public Wallet(Store store) {
        this.store = store;
    }

    public void put(String label, Identity id) {
        String content = id.toString();
        store.put(label, content);
    }

    public Identity get(String label) {
        String content = store.get(label);

        JSONObject obj = JSON.parseObject(content);

        String type = obj.getString("type");

        Identity id = null;
        switch (IdentityType.valueOf(type)) {
            case Raw:
                RawIdentity r = obj.toJavaObject(RawIdentity.class);
                id = r;
                break;
        
            default:
                System.out.println("unsupported identity type: " + type);
                break;
        }

        return id;
    }

    public void remove(String label) {
        store.remove(label);
    }

    public boolean exists(String label) {
        return store.exists(label);
    }

    public ArrayList<String> list() {
        return store.list();
    }
}