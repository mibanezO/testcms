package com.test.abc.testcms.builder;

import com.test.abc.testcms.entity.ClientEntity;
import com.test.abc.testcms.model.Client;

public record ClientModelToEntity(Client client) implements ClientEntityBuilder {

    @Override
    public ClientEntity build() {
        ClientEntity clientEntity = new ClientEntity();
        clientEntity.setFirstName(client.getFirstName());
        clientEntity.setLastName(client.getLastName());
        clientEntity.setAge(client.getAge());
        clientEntity.setBirthDate(client.getBirthDate());
        return clientEntity;
    }
}
