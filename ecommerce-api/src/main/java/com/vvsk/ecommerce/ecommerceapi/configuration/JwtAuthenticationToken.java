package com.vvsk.ecommerce.ecommerceapi.configuration;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import java.util.Collection;

public class JwtAuthenticationToken implements Authentication {

    private static final long serialVersionUID = 1L;
	private final String principal;
    private final Collection<? extends GrantedAuthority> authorities;
    private boolean authenticated = false;

    public JwtAuthenticationToken(String principal, Collection<? extends GrantedAuthority> authorities) {
        this.principal = principal;
        this.authorities = authorities;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public Object getCredentials() {
        return null; // JWT does not require credentials to be stored
    }

    @Override
    public Object getDetails() {
        return null;
    }

    @Override
    public Object getPrincipal() {
        return principal;
    }

    @Override
    public boolean isAuthenticated() {
        return authenticated;
    }

    @Override
    public void setAuthenticated(boolean isAuthenticated) throws IllegalArgumentException {
        this.authenticated = isAuthenticated;
    }

    @Override
    public String getName() {
        return principal; // Typically returns the username or similar identifier
    }
}

