package com.ratimid.fibank_cash_desk.config.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.HandlerExceptionResolver;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

public class ApiKeyFilter  extends OncePerRequestFilter {

    private final ApiKeyRepository repository;
    private final HandlerExceptionResolver resolver;
    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public ApiKeyFilter(ApiKeyRepository repository, HandlerExceptionResolver resolver) {
        this.repository = repository;
        this.resolver = resolver;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        String rawKey = request.getHeader("FIB-X-AUTH");
        String client = request.getHeader("FIB-X-CLIENT");

        if (rawKey != null && client != null) {
            ApiKey apiKey = repository.findApiKeyByClient(client).orElse(null);

            if (apiKey != null && passwordEncoder.matches(rawKey, apiKey.getHashedKey())) {
                List<SimpleGrantedAuthority> authorities = Collections.singletonList(new SimpleGrantedAuthority("ROLE_FIB_CASH_DESK_API_USER"));
                ApiKeyAuthentication auth = new ApiKeyAuthentication(rawKey, authorities);
                SecurityContextHolder.getContext().setAuthentication(auth);
                filterChain.doFilter(request, response);
                return;
            }
            else {
                resolver.resolveException(request, response, null, new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Invalid API Key for client: " + client));
                return;
            }
        }

        filterChain.doFilter(request, response);
    }
}
