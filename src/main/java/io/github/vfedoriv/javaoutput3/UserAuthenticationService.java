package io.github.vfedoriv.javaoutput3;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import io.github.vfedoriv.javaoutput3.utils.LoggingUtils;
import java.util.HashMap;
import java.util.Map;

@Service
public class UserAuthenticationService {

    @Autowired
    private LoggingUtils loggingUtils;

    private Map<String, String> userDatabase = new HashMap<>();
    private Map<String, String> userSessions = new HashMap<>();

    public UserAuthenticationService() {
        userDatabase.put("admin", "password");
        userDatabase.put("user", "userpass");
    }

    public boolean validateUser(String username, String password) {
        boolean isValid = userDatabase.containsKey(username) && userDatabase.get(username).equals(password);
        loggingUtils.logValidationAttempt(username, isValid);
        return isValid;
    }

    public void manageSession(String username) {
        if (userSessions.containsKey(username)) {
            loggingUtils.logSessionManagement(username + " is already logged in.");
        } else {
            userSessions.put(username, "active");
            loggingUtils.logSessionManagement(username + " has logged in.");
        }
    }
}