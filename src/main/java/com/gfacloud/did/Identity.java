package com.gfacloud.did;

import com.alibaba.fastjson.JSON;

public abstract class Identity {
    private int version;
    private IdentityType type;
    private String id;

    Identity() {}

    Identity(int version, IdentityType type, String id) {
        this.version = version;
        this.type = type;
        this.id = id;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public IdentityType getType() {
        return type;
    }

    public void setType(IdentityType type) {
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}