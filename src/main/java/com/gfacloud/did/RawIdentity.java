package com.gfacloud.did;

public class RawIdentity extends Identity {
    static final private int version  = 1;

    private Key key;

    RawIdentity() {}

    public RawIdentity(String id, Key key) {
        super(version, IdentityType.Raw, id);
        this.key = key;
    }

    public Key getKey() {
        return key;
    }

    public void setKey(Key key) {
        this.key = key;
    }
}
