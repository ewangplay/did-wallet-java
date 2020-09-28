package com.gfacloud.did;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Test;

public class WalletTest {

    @Test
    public void inMemoryWalletTest() {
        Wallet w = new Wallet();
        walletTest(w);
    }

    @Test
    public void fileSystemWalletTest() {
        Wallet w = new Wallet(new FileSystemStore("./wallet"));
        walletTest(w);
    }

    public static void walletTest(Wallet wallet) {

        String keyID = "keys-1";
        String privateKeyHex = "a889f4da49ff8dd6b03d4334723fe3e5ff55ae6a2483de1627bec873b0b73e1e86eabd6abce2f96553251de61def0265784688ff712ce583621a5b181ef21639";
        String publicKeyHex = "86eabd6abce2f96553251de61def0265784688ff712ce583621a5b181ef21639";
        Key key = new Key(keyID, KeyType.Ed25519, privateKeyHex, publicKeyHex);

        String did = "did:example:3dda540891d14a1baec2c7485c273c00";
        RawIdentity rawIdentity = new RawIdentity(did, key);

        String label = "User1";
        wallet.put(label, rawIdentity);
        assertTrue(wallet.exists(label));

        Identity identity = wallet.get(label);
        assertNotNull(identity);
        assertTrue(identity instanceof RawIdentity);
        RawIdentity rid = (RawIdentity)identity;
        assertEquals(1, rid.getVersion());
        assertEquals(did, rid.getId());
        assertEquals(IdentityType.Raw, rid.getType());
        Key k = rid.getKey();
        assertNotNull(k);
        assertEquals(key.getId(), k.getId());
        assertEquals(key.getType(), k.getType());
        assertEquals(key.getPrivateKeyHex(), k.getPrivateKeyHex());
        assertEquals(key.getPublicKeyHex(), k.getPublicKeyHex());
        
        ArrayList<String> list = wallet.list();
        assertNotNull(list);
        assertEquals(list.size(), 1);
        
        wallet.remove(label);
        assertFalse(wallet.exists(label));
    }
}
