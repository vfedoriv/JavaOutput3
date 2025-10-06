package io.github.vfedoriv.javaoutput3.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoginAttemptLogger {
    private static final Logger logger = LoggerFactory.getLogger(LoginAttemptLogger.class);

    public void logLoginAttempt(String username, boolean success) {
        if (success) {
            logger.info("Login attempt successful for user: {}", username);
        } else {
            logger.warn("Login attempt failed for user: {}", username);
        }
    }
}