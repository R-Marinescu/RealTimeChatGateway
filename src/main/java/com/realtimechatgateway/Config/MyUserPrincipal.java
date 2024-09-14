package com.realtimechatgateway.Config;

import com.realtimechatgateway.POJO.GatewayUser;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

public class MyUserPrincipal implements UserDetails {
    private final GatewayUser user;

    private final Collection<GrantedAuthority> authorities;

    public MyUserPrincipal(GatewayUser user) {
        this.user = user;
        this.authorities = Collections.singletonList(
                new SimpleGrantedAuthority(user.getRole())
        );
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUsername();
    }
}
