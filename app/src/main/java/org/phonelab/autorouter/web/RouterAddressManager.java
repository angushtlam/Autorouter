package org.phonelab.autorouter.web;

import java.util.ArrayList;

/**
 * Responsible for helping the autorouter find a router address.
 */
public class RouterAddressManager {
    private ArrayList<String> commonRouterAddresses;
    private int index;

    public RouterAddressManager() {
        index = 0;

        // Create an arraylist of common IP addresses.
        // http://www.techspot.com/guides/287-default-router-ip-addresses/
        commonRouterAddresses = new ArrayList<>();
        commonRouterAddresses.add("http://192.168.1.1");
    }

    public String getNextAddress() {
        // If there is no more common router addresses, return null.
        if (index >= commonRouterAddresses.size()) return null;

        // Try to get the address, then increment the index.
        String address = commonRouterAddresses.get(index);
        index++;
        return address;
    }
}
