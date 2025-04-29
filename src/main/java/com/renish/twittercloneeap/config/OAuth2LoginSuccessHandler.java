package com.renish.twittercloneeap.config;

import com.renish.twittercloneeap.service.JWTService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.UUID;

@Component
public class OAuth2LoginSuccessHandler implements AuthenticationSuccessHandler {

    @Autowired
    JWTService jwtService;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                        Authentication authentication) throws IOException {
        OAuth2AuthenticationToken token = (OAuth2AuthenticationToken) authentication;
        String userName = token.getPrincipal().getAttribute("login");

//        String uuidToken = UUID.randomUUID().toString();  //  generate only UUID and pass into header
        String uuidToken = jwtService.generateToken(userName); // generate JWT token ans pass into header

        response.sendRedirect("/welcome?token=" + uuidToken); // Or save token somewhere
    }
}
