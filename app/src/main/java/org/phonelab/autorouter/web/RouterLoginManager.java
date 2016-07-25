package org.phonelab.autorouter.web;

import java.util.ArrayList;

/**
 * Responsible for providing the Autorouter a correct login.
 */
public class RouterLoginManager {
    private ArrayList<String> commonLogins;
    private ArrayList<String> commonPasswords;

    private int loginIndex;
    private int passwordIndex;

    public RouterLoginManager() {
        init();
    }

    public void init() {
        loginIndex = 0;
        passwordIndex = 0;

        commonLogins = new ArrayList<>();
        commonLogins.add("admin");
        commonLogins.add("root");

        commonPasswords = new ArrayList<>();
        commonPasswords.add("password");
        commonPasswords.add("");
    }

    public String getNextUsername() {
        if (passwordIndex >= commonPasswords.size()) {
            loginIndex++;
            passwordIndex = 0;
        }

        return commonLogins.get(loginIndex);
    }

    public String getNextPassword() {
        if (passwordIndex >= commonPasswords.size()) return null;

        String password = commonPasswords.get(passwordIndex);
        passwordIndex++;
        return password;
    }
}
