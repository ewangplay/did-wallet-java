package com.gfacloud.did;

import java.util.ArrayList;

public interface Store {
    boolean put(String label, String content);
    String get(String label);
    ArrayList<String> list();
    boolean exists(String label);
    boolean remove(String label);
}
