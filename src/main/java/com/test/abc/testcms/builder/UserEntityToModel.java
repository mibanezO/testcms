package com.test.abc.testcms.builder;

import com.test.abc.testcms.entity.UserEntity;
import com.test.abc.testcms.model.User;

public record UserEntityToModel(UserEntity userEntity) implements UserModelBuilder {

    @Override
    public User build() {
        User user = new User();
        user.setId(userEntity.getId());
        user.setFirstName(userEntity.getFirstName());
        user.setLastName(userEntity.getLastName());
        user.setEmail(userEntity.getEmail());
        user.setPhone(userEntity.getPhone());
        user.setUsername(userEntity.getUsername());
        user.setUserStatus(userEntity.getStatus());
        return user;
    }
}
