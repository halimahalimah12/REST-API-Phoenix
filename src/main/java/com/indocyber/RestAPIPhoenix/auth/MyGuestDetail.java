package com.indocyber.RestAPIPhoenix.auth;

import com.indocyber.RestAPIPhoenix.models.Guest;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@AllArgsConstructor
@Builder
@Getter
public class MyGuestDetail implements UserDetails {
    private Guest guest;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        var granteAuth = new SimpleGrantedAuthority("Guest");
        return List.of(granteAuth);
    }

    public String getPassword() {
        return this.guest.getPassword();
    }

    @Override
    public String getUsername() {
        return this.guest.getUsername();
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
