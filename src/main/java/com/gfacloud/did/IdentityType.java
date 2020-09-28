package com.gfacloud.did;

public enum IdentityType {
    Raw("Raw");

    private final String name;

    IdentityType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
