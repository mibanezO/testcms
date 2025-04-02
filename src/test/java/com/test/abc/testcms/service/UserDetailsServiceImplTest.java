package com.test.abc.testcms.service;

import com.test.abc.testcms.entity.PrivilegeEntity;
import com.test.abc.testcms.entity.RoleEntity;
import com.test.abc.testcms.entity.UserEntity;
import com.test.abc.testcms.repository.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserDetailsServiceImplTest {

    private final UserRepository userRepository = mock(UserRepository.class);

    private UserDetailsServiceImpl userDetailsServiceImpl;

    @BeforeEach
    void setUp() {
        userDetailsServiceImpl = new UserDetailsServiceImpl(userRepository);
    }

    @Test
    void loadUserByUsername() {
        String username = "username";
        String password = "password";
        UserEntity userEntity = new UserEntity();
        userEntity.setUsername(username);
        userEntity.setPassword(password);
        RoleEntity roleEntity = new RoleEntity();
        roleEntity.setName("some_role");
        PrivilegeEntity privilegeEntity = new PrivilegeEntity();
        privilegeEntity.setName("some_privilege");
        roleEntity.setPrivileges(List.of(privilegeEntity));
        userEntity.setRoles(List.of(roleEntity));
        when(userRepository.findByUsername(eq(username))).thenReturn(Optional.of(userEntity));
        var response = userDetailsServiceImpl.loadUserByUsername(username);
        Assertions.assertNotNull(response);
        Assertions.assertEquals(username, response.getUsername());
    }

}