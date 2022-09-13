package com.pequenosgenios.pg.services.impl;

import com.pequenosgenios.pg.config.UserDetailsImpl;
import com.pequenosgenios.pg.dto.auth.LoginRequest;
import com.pequenosgenios.pg.dto.auth.LoginResponse;
import com.pequenosgenios.pg.dto.auth.RefreshResponse;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
    private final TokenService tokenService;
    private final AuthenticationManager authenticationManager;

    public AuthenticationService(TokenService jwtUtils, AuthenticationManager authenticationManager) {
        this.tokenService = jwtUtils;
        this.authenticationManager = authenticationManager;
    }

    public LoginResponse authenticateUser(LoginRequest loginRequest) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                loginRequest.getUsername(),
                loginRequest.getPassword()
        ));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        UserDetails userDetails = (UserDetailsImpl) authentication.getPrincipal();
        String accessToken = tokenService.generateAccessToken(userDetails);
        String refreshToken = this.tokenService.generateRefreshTokenFromUsername(userDetails.getUsername());

        return LoginResponse.builder()
                .accessToken(accessToken)
                .refreshToken(refreshToken)
                .username(userDetails.getUsername())
                .build();
    }

    public RefreshResponse refreshTheToken(String requestRefreshToken) {
        try {
            if(this.tokenService.validateJwtToken(requestRefreshToken)) {
                String username = this.tokenService.getUserNameFromJwtToken(requestRefreshToken);
                String newAccessToken = this.tokenService.generateAccessToken(username);
                String newRefreshToken = this.tokenService.generateRefreshTokenFromUsername(username);
                return RefreshResponse.builder()
                        .accessToken(newAccessToken)
                        .refreshToken(newRefreshToken)
                        .build();
            } else {
                throw new BadCredentialsException("Token expirado");
            }
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

}