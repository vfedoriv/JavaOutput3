package io.github.vfedoriv.javaoutput3;

import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class LoginService {
    private static final Logger logger = LoggerFactory.getLogger(LoginService.class);

    public boolean authenticateUser(String username, String password) {
        if ("user".equals(username) && "pass".equals(password)) {
            initializeSession(username);
            return true;
        } else {
            logError("Failed login attempt for user: " + username);
            return false;
        }
    }

    private void logError(String message) {
        logger.error(message);
    }

    private void initializeSession(String username) {
        // Session initialization logic
        logger.info("Session initialized for user: " + username);
        // Additional session management logic can be added here
    }
}