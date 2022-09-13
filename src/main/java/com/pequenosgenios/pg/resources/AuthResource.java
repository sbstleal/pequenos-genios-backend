package com.pequenosgenios.pg.resources;

import com.pequenosgenios.pg.dto.auth.LoginRequest;
import com.pequenosgenios.pg.dto.auth.LoginResponse;
import com.pequenosgenios.pg.dto.auth.RefreshRequest;
import com.pequenosgenios.pg.dto.auth.RefreshResponse;
import com.pequenosgenios.pg.services.impl.AuthenticationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/auth")
public class AuthResource {
    private final AuthenticationService tokenService;

    public AuthResource(AuthenticationService tokenService) {
        this.tokenService = tokenService;
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> authenticateUser(@RequestBody LoginRequest loginRequest) {
        return ResponseEntity.ok(tokenService.authenticateUser(loginRequest));
    }

    @PostMapping("/refresh")
    public ResponseEntity<RefreshResponse> refreshToken(@RequestBody RefreshRequest request) {
        return ResponseEntity.ok(tokenService.refreshTheToken(request.getRefreshToken()));
    }

}
