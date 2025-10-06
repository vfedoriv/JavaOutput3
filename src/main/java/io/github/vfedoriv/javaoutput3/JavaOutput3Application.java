package io.github.vfedoriv.javaoutput3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import io.github.vfedoriv.javaoutput3.UserAuthenticationService;
import org.springframework.http.ResponseEntity;

@SpringBootApplication
@RestController
public class JavaOutput3Application
{
  @Autowired
  private UserAuthenticationService userAuthenticationService;

  public static void main(String[] args) {
    SpringApplication.run(JavaOutput3Application.class, args);
  }

  @PostMapping("/login")
  public ResponseEntity<String> login(@RequestBody LoginRequest loginRequest) {
    if (userAuthenticationService.validateUser(loginRequest)) {
      userAuthenticationService.manageSession(loginRequest);
      return ResponseEntity.ok("Login successful");
    } else {
      return ResponseEntity.status(401).body("Login failed");
    }
  }
}