package com.gfacloud.did;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class KeyTest {

    @Test
    public void keyTest() {
        String keyID = "keys-1";
        String privateKeyHex = "a889f4da49ff8dd6b03d4334723fe3e5ff55ae6a2483de1627bec873b0b73e1e86eabd6abce2f96553251de61def0265784688ff712ce583621a5b181ef21639";
        String publicKeyHex = "86eabd6abce2f96553251de61def0265784688ff712ce583621a5b181ef21639";
        Key key = new Key(keyID, KeyType.Ed25519, privateKeyHex, publicKeyHex);

        assertEquals(keyID, key.getId());
        assertEquals(KeyType.Ed25519, key.getType());
        assertEquals(privateKeyHex, key.getPrivateKeyHex());
        assertEquals(publicKeyHex, key.getPublicKeyHex());
    }
}
