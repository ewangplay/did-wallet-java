package com.gfacloud.did;

import com.alibaba.fastjson.JSON;

public class RawIdentity implements Identity {
    private int version;
    private IdentityType type;
    private String did;
    private Key key;

    RawIdentity() {}

    RawIdentity(String did, Key key) {
        this.version = 1;
        this.type = IdentityType.Raw;
        this.did = did;
        this.key = key;
    }

    @Override
    public int getVersion() {
        return version;
    }

    @Override
    public IdentityType getType() {
        return type;
    }

    @Override
    public String getDid() {
        return did;
    }

    public Key getKey() {
        return key;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
