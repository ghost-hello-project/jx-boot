package com.laolang.jx.module.auth.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.laolang.jx.module.system.user.entity.SysUser;
import java.util.Collection;
import java.util.Collections;
import java.util.Set;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


@NoArgsConstructor
@Data
public class LoginUserDto implements UserDetails {

    private SysUser sysUser;
    private Long loginTime;
    private Long expireTime;
    private Set<String> perms;
    private Set<String> role;

    public LoginUserDto(SysUser sysUser) {
        this.sysUser = sysUser;
    }

    @JsonIgnore
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.emptyList();
    }

    @JsonIgnore
    @Override
    public String getPassword() {
        return sysUser.getPassword();
    }

    @JsonIgnore
    @Override
    public String getUsername() {
        return sysUser.getUsername();
    }

    @JsonIgnore
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @JsonIgnore
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @JsonIgnore
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @JsonIgnore
    @Override
    public boolean isEnabled() {
        return true;
    }
}
