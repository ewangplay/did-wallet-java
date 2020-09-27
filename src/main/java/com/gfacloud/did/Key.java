package com.gfacloud.did;

import com.alibaba.fastjson.JSON;

public class Key {
    private String id;
    private KeyType type;
    private String privateKeyHex;
    private String publicKeyHex;

    public Key(){}

    public Key(String id, KeyType type, String privateKeyHex, String publicKeyHex) {
        this.id = id;
        this.type = type;
        this.privateKeyHex = privateKeyHex;
        this.publicKeyHex = publicKeyHex;
    }
    
    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setType(KeyType type) {
        this.type = type;
    }

    public KeyType getType() {
        return type;
    }

    public void setPrivateKeyHex(String privateKeyHex) {
        this.privateKeyHex = privateKeyHex;
    }

    public String getPrivateKeyHex() {
        return privateKeyHex;
    }

    public void setPublicKeyHex(String publicKeyHex) {
        this.publicKeyHex = publicKeyHex;
    }

    public String getPublicKeyHex() {
        return publicKeyHex;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
