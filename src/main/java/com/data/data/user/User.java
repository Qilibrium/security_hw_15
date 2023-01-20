package com.data.data.user;

import lombok.Data;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Arrays;
import java.util.Collection;

@Data
@Entity
@Table(name = "\"user\"")
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String password;
    private String authorities;

    @Override
    public String getUsername() {
        return name;
    }
    @Override
    public String getPassword() {
        return password;
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Arrays
                .stream(authorities.split(","))
                .map(it -> (GrantedAuthority) () -> it)
                .toList();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
