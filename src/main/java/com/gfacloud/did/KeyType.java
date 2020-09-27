package com.gfacloud.did;

public enum KeyType {
    Ed25519("Ed25519");

    private final String name;
    KeyType(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    } 
}
