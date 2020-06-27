package com.abc.accommodation.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint {
    private static final Logger logger = LoggerFactory.getLogger(JwtAuthenticationEntryPoint.class);
    @Override
    public void commence(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
        logger.error("Responding with unauthorized. Message: {}", e.getMessage());
        final String expired = (String) httpServletRequest.getAttribute("expired");
        if (expired!=null){
            httpServletResponse.setHeader("expired", "1");
            httpServletResponse.sendError(HttpServletResponse.SC_UNAUTHORIZED,expired);
        } else {
            httpServletResponse.setHeader("expired", "0");
            httpServletResponse.sendError(HttpServletResponse.SC_UNAUTHORIZED, e.getMessage());
        }
    }
    //send error payload if client attempt to access unauthorized api
}
