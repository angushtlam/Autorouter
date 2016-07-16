package org.phonelab.autorouter.web;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by anguslam on 7/15/16.
 */
public class AutorouterManager {
    private ArrayList<String> commonRouterAddresses;
    private HashMap<String, String> commonRouterLogins;

    public void init() {
        // Create an arraylist of common IP addresses.
        // http://www.techspot.com/guides/287-default-router-ip-addresses/
        commonRouterAddresses = new ArrayList<>();
        commonRouterAddresses.add("192.168.1.1");
        commonRouterAddresses.add("192.168.0.1");
        commonRouterAddresses.add("10.0.1.1");
        commonRouterAddresses.add("10.1.1.1");
        commonRouterAddresses.add("10.0.0.2");
        commonRouterAddresses.add("192.168.0.254");

        commonRouterLogins = new HashMap<>();
        commonRouterLogins.put("admin", "password");
        commonRouterLogins.put("admin", "admin");
        commonRouterLogins.put("admin", "");
        commonRouterLogins.put("root", "");
    }
}
