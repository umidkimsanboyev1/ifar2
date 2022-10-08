package uz.master.spring;


import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import uz.master.DTOs.AuthUser;

import java.util.Collection;

@Getter
public class UserDetails implements org.springframework.security.core.userdetails.UserDetails {

    private String username;
    private Long id;
    private String password;
    private boolean deleted;

    public UserDetails(AuthUser user) {
        this.id = user.getId();
        this.username = user.getUsername();
        this.password = user.getPassword();
        this.deleted = user.isDeleted();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.username;
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
        return !this.deleted;
    }
}
