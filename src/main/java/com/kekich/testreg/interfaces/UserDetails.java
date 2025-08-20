package com.kekich.testreg.interfaces;

import org.springframework.security.core.GrantedAuthority;

import java.io.Serializable;
import java.util.Collection;

public interface UserDetails extends Serializable {

    Collection<? extends GrantedAuthority> getAuthorities();
    String getPassword();
    String getLogin();
    boolean isAccountNonLocked();
    boolean isEnabled();

}
