package com.example.trainingcore.web.security;

import com.example.trainingcore.model.User;
import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;

@Data
public class SecurityUser implements UserDetails {

    private final ObjectId id;
    private final String username;
    private final String password;
    private final boolean active;
    private final Collection<SimpleGrantedAuthority> authorities;

    public SecurityUser(
            final User user
    ) {
        this(
                user.getId(),
                user.getUsername(),
                user.getPassword(),
                user.isActive()
        );
        this.authorities.add(
                mapToGrantedAuthorities(user.getRole().name())
        );
    }

    private static SimpleGrantedAuthority mapToGrantedAuthorities(
            final String role
    ) {
        return new SimpleGrantedAuthority(role);
    }

    private SecurityUser(
            final ObjectId id,
            final String username,
            final String password,
            final boolean active
    ) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.active = active;
        this.authorities = new ArrayList<>();
    }

    @Override
    public boolean isAccountNonExpired() {
        return this.active;
    }

    @Override
    public boolean isAccountNonLocked() {
        return this.active;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return this.active;
    }

    @Override
    public boolean isEnabled() {
        return this.active;
    }

}
