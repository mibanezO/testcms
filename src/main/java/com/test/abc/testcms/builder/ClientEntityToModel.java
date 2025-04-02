package com.test.abc.testcms.builder;

import com.test.abc.testcms.entity.ClientEntity;
import com.test.abc.testcms.model.Client;

public record ClientEntityToModel(ClientEntity clientEntity) implements ClientModelBuilder {

    @Override
    public Client build() {
        Client client = new Client();
        client.setId(clientEntity.getId());
        client.setFirstName(clientEntity.getFirstName());
        client.setLastName(clientEntity.getLastName());
        client.setAge(clientEntity.getAge());
        client.setBirthDate(clientEntity.getBirthDate());
        return client;
    }
}
