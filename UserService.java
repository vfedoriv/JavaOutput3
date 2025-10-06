package com.example.userservice;

import java.util.HashMap;
import java.util.Map;

public class UserService {
    private Map<String, String> userDatabase;

    public UserService() {
        userDatabase = new HashMap<>();
        userDatabase.put("user1", "password1");
        userDatabase.put("user2", "password2");
    }

    public boolean validateUser(String username, String password) {
        return userDatabase.containsKey(username) && userDatabase.get(username).equals(password);
    }

    public String getUserByUsername(String username) {
        return userDatabase.containsKey(username) ? username : null;
    }
}