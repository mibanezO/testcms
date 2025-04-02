package com.test.abc.testcms.service;

import com.test.abc.testcms.entity.PrivilegeEntity;
import com.test.abc.testcms.entity.RoleEntity;
import com.test.abc.testcms.entity.UserEntity;
import com.test.abc.testcms.model.TokenResponse;
import com.test.abc.testcms.model.User;
import com.test.abc.testcms.repository.RoleRepository;
import com.test.abc.testcms.repository.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    private final UserRepository userRepository = mock(UserRepository.class);
    private final RoleRepository roleRepository = mock(RoleRepository.class);
    private final PasswordEncoder passwordEncoder = mock(PasswordEncoder.class);
    private final JWTService jwtService = mock(JWTService.class);
    private UserService userService;

    @BeforeEach
    void setUp() {
        userService = new UserService(userRepository, roleRepository, passwordEncoder, jwtService);
    }

    @Test
    void signInUser() {
        User user = new User();
        user.setEmail("username@test.com");
        user.setPassword("password");
        user.setRole(User.RoleEnum.USER);

        when(roleRepository.findByName(eq("ROLE_USER"))).thenReturn(new RoleEntity());
        when(passwordEncoder.encode(eq(user.getPassword()))).thenReturn("password");
        when(userRepository.save(any(UserEntity.class))).thenAnswer(args -> args.getArgument(0));

        User registered = userService.signInUser(user).getBody();
        Assertions.assertNotNull(registered);
        Assertions.assertEquals("username", registered.getUsername());
    }

    @Test
    void loginUser() {
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
        when(userRepository.findByUsername(username)).thenReturn(Optional.of(userEntity));
        when(passwordEncoder.matches(eq(password), eq(password))).thenReturn(true);
        when(jwtService.generateToken(any())).thenReturn("token");
        TokenResponse tokenResponse = userService.loginUser(username, password).getBody();
        Assertions.assertNotNull(tokenResponse);
        Assertions.assertNotNull(tokenResponse.getAuthToken());
    }

}