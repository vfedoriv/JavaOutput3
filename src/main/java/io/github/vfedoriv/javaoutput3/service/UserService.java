package io.github.vfedoriv.javaoutput3.service;

import java.util.HashMap;
import java.util.Map;

public class UserService {
    private Map<String, String> userDatabase = new HashMap<>();
    private String loggedInUser = null;

    public UserService() {
        // Sample user for demonstration
        userDatabase.put("user1", "password1");
    }

    public boolean authenticateUser(String username, String password) {
        if (userDatabase.containsKey(username)) {
            return validateUser(username, password);
        }
        return false;
    }

    public boolean validateUser(String username, String password) {
        return userDatabase.get(username).equals(password);
    }

    public void logout() {
        loggedInUser = null;
    }

    public boolean isLoggedIn() {
        return loggedInUser != null;
    }

    public void login(String username) {
        if (userDatabase.containsKey(username)) {
            loggedInUser = username;
        }
    }
}