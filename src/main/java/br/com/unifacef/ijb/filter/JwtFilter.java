package br.com.unifacef.ijb.filter;

import br.com.unifacef.ijb.exceptions.InvalidJwtTokenException;
import br.com.unifacef.ijb.securities.JwtProvider;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class JwtFilter extends OncePerRequestFilter {
    @Autowired
    private JwtProvider jwtProvider;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String token = jwtProvider.resolveToken(request);
        try {
            if(token != null && jwtProvider.validateToken(token)) {
                Authentication authentication = jwtProvider.getAuthentication(token);
                SecurityContextHolder.getContext().setAuthentication(authentication);
            }
        } catch (Exception ex) {
            throw new InvalidJwtTokenException("Invalid token");
        }

        filterChain.doFilter(request, response);
    }

    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) throws ServletException {
        return request.getRequestURI().equals("/api/ijb/register/volunteer") ||
                request.getRequestURI().equals("/api/ijb/login") ||
                request.getRequestURI().equals("/api/ijb/register/supporter") ||
                request.getRequestURI().equals("/api/ijb/register/beneficiary");
    }
}
