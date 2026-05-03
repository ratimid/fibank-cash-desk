package com.ratimid.fibank_cash_desk.config.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.filter.OncePerRequestFilter;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

public class ApiKeyFilter  extends OncePerRequestFilter {

    private final ApiKeyRepository repository;
    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public ApiKeyFilter(ApiKeyRepository repository) {
        this.repository = repository;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        String rawKey = request.getHeader("FIB-X-AUTH");
        String client = request.getHeader("FIB-X-CLIENT");

        if (rawKey != null) {
            ApiKey apiKey = repository.findApiKeyByClient(client).orElse(null);

            if (apiKey != null && passwordEncoder.matches(rawKey, apiKey.getHashedKey())) {
                List<SimpleGrantedAuthority> authorities = Collections.singletonList(new SimpleGrantedAuthority("ROLE_FIB_CASH_DESK_API_USER"));
                ApiKeyAuthentication auth = new ApiKeyAuthentication(rawKey, authorities);
                SecurityContextHolder.getContext().setAuthentication(auth);
                filterChain.doFilter(request, response);
                return;
            }
        }

        filterChain.doFilter(request, response);
    }
}
