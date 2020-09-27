package com.gfacloud.did;

import java.util.ArrayList;

public interface Store {
    void put(String label, String content);
    String get(String label);
    ArrayList<String> list();
    boolean exists(String label);
    void remove(String label);
}
