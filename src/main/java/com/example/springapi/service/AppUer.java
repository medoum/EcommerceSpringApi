package com.example.springapi.service;

import com.example.springapi.models.User;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;


@EqualsAndHashCode
public class AppUer implements UserDetails {
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        User user = new User();
        SimpleGrantedAuthority authority = new SimpleGrantedAuthority(user.getAppUserRole().name());
        return Collections.singletonList(authority);

    }

    @Override
    public String getPassword() {
        return getPassword();
    }

    @Override
    public String getUsername() {
        return getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        User user = new User();
        return !user.getLocked();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        User user = new User();
        return user.getEnabled();
    }
}
