package io.github.vfedoriv.javaoutput3;

import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    private final LoginService loginService;

    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginRequest loginRequest) {
        try {
            loginService.authenticate(loginRequest);
            return ResponseEntity.ok("Login successful");
        } catch (Exception e) {
            return handleLoginError(e.getMessage());
        }
    }

    private ResponseEntity<String> handleLoginError(String errorMessage) {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(errorMessage);
    }
}