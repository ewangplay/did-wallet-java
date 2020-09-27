package com.gfacloud.did;

public interface Identity {
    int getVersion();
    IdentityType getType();
    String getDid();
}