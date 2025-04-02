package com.test.abc.testcms.builder;

import com.test.abc.testcms.entity.PrivilegeEntity;
import com.test.abc.testcms.entity.RoleEntity;
import com.test.abc.testcms.entity.UserEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public record UserEntityToUserDetails(UserEntity userEntity) implements UserDetailBuilder {
    @Override
    public User build() {
        return new User(
                userEntity.getUsername(), userEntity.getPassword(),
                getGrantedAuthorities(getPrivileges(userEntity.getRoles()))
        );
    }


    private List<String> getPrivileges(Collection<RoleEntity> roles) {

        List<String> privileges = new ArrayList<>();
        List<PrivilegeEntity> collection = new ArrayList<>();
        for (RoleEntity role : roles) {
            privileges.add(role.getName());
            collection.addAll(role.getPrivileges());
        }
        for (PrivilegeEntity item : collection) {
            privileges.add(item.getName());
        }
        return privileges;
    }

    private List<GrantedAuthority> getGrantedAuthorities(List<String> privileges) {
        List<GrantedAuthority> authorities = new ArrayList<>();
        for (String privilege : privileges) {
            authorities.add(new SimpleGrantedAuthority(privilege));
        }
        return authorities;
    }

}
