package br.com.itss.SysParkingManagement.controller;

import br.com.itss.SysParkingManagement.model.AuthRequest;
import br.com.itss.SysParkingManagement.model.AuthResponse;
import br.com.itss.SysParkingManagement.services.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class AuthController {


    private AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/auth")
    public ResponseEntity<?> createAuthToken(@RequestBody AuthRequest authRequest) throws Exception {

        final String jwt = authService.authenticate(authRequest);
        return ResponseEntity.ok(new AuthResponse(jwt));
    }

}
