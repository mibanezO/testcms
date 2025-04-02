package com.test.abc.testcms.builder;

import com.test.abc.testcms.entity.UserEntity;
import com.test.abc.testcms.model.User;

public record UserModelToEntity(User user) implements UserEntityBuilder {

    @Override
    public UserEntity build() {
        UserEntity userEntity = new UserEntity();
        userEntity.setFirstName(user.getFirstName());
        userEntity.setLastName(user.getLastName());
        userEntity.setEmail(user.getEmail());
        userEntity.setPhone(user.getPhone());
        userEntity.setUsername(user.getEmail().split("@")[0].trim());
        return userEntity;
    }
}
