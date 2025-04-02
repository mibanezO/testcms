package com.test.abc.testcms.service;

import com.test.abc.testcms.api.UserApiDelegate;
import com.test.abc.testcms.builder.UserEntityToModel;
import com.test.abc.testcms.builder.UserEntityToUserDetails;
import com.test.abc.testcms.builder.UserModelToEntity;
import com.test.abc.testcms.entity.RoleEntity;
import com.test.abc.testcms.entity.UserEntity;
import com.test.abc.testcms.model.TokenResponse;
import com.test.abc.testcms.model.User;
import com.test.abc.testcms.repository.RoleRepository;
import com.test.abc.testcms.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService implements UserApiDelegate {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;
    private final JWTService jwtService;


    @Override
    public ResponseEntity<TokenResponse> loginUser(String username, String password) {
        UserEntity userEntity = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException(String.format("User %s not found", username)));
        boolean matches = passwordEncoder.matches(password, userEntity.getPassword());
        if (!matches) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        UserEntityToUserDetails builder = new UserEntityToUserDetails(userEntity);
        String token = jwtService.generateToken(builder.build());
        TokenResponse tokenResponse = new TokenResponse();
        tokenResponse.authToken(token);
        return ResponseEntity.ok(tokenResponse);
    }

    @Override
    public ResponseEntity<User> signInUser(User user) {
        UserModelToEntity builder = new UserModelToEntity(user);
        UserEntity userEntity = builder.build();
        userEntity.setPassword(passwordEncoder.encode(user.getPassword()));
        RoleEntity roleEntity = roleRepository.findByName(user.getRole().getValue());
        userEntity.setRoles(List.of(roleEntity));
        userRepository.save(userEntity);
        UserEntityToModel newUser = new UserEntityToModel(userEntity);
        return ResponseEntity.ok(newUser.build());
    }

}
