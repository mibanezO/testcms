package com.test.abc.testcms.service;

import com.test.abc.testcms.api.ClientsApiDelegate;
import com.test.abc.testcms.builder.AgeStatsProjectionToModel;
import com.test.abc.testcms.builder.ClientEntityToModel;
import com.test.abc.testcms.builder.ClientModelToEntity;
import com.test.abc.testcms.builder.ClientPageBuilderImpl;
import com.test.abc.testcms.entity.ClientEntity;
import com.test.abc.testcms.model.Client;
import com.test.abc.testcms.model.ClientAgeStats;
import com.test.abc.testcms.model.ClientPage;
import com.test.abc.testcms.projection.ClientStatProjection;
import com.test.abc.testcms.repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClientService implements ClientsApiDelegate {

    private final ClientRepository clientRepository;

    @Override
    public ResponseEntity<Client> addClient(Client client) {
        ClientModelToEntity builder = new ClientModelToEntity(client);
        ClientEntity clientEntity = clientRepository.save(ClientEntity.from(builder));
        Client newClient = clientFromEntity(clientEntity);
        return ResponseEntity.ok(newClient);
    }

    @Override
    public ResponseEntity<ClientPage> listClients(Long offset, Long limit, String firstName, String lastName) {
        int _offset = Optional.ofNullable(offset).map(Long::intValue).orElse(0);
        int _limit = Optional.ofNullable(limit).map(Long::intValue).orElse(0);
        Pageable pageable = PageRequest.of(_offset, _limit);
        Page<ClientEntity> page = clientRepository.filter(firstName, lastName, pageable);
        ClientStatProjection projection = clientRepository.getAgeStats(firstName, lastName);
        AgeStatsProjectionToModel ageStatsProjectionToModel = new AgeStatsProjectionToModel(projection);
        ClientAgeStats ageStats = ageStatsProjectionToModel.build();
        ClientPage clientPage = clientPageFromEntities(page, ageStats);
        return ResponseEntity.ok(clientPage);
    }

    @Override
    public ResponseEntity<Client> updateClientWithForm(Long clientId, String firstName, String lastName, Integer age, LocalDate birthDate) {
        ClientEntity clientEntity = clientRepository.findById(clientId)
                .orElse(null);
        if (clientEntity == null) {
            return ResponseEntity.notFound().build();
        }
        if (firstName != null) {
            clientEntity.setFirstName(firstName);
        }
        if (lastName != null) {
            clientEntity.setLastName(lastName);
        }
        if (age != null) {
            clientEntity.setAge(age);
        }
        if (birthDate != null) {
            clientEntity.setBirthDate(birthDate);
        }
        Client newClient = clientFromEntity(clientRepository.save(clientEntity));
        return ResponseEntity.ok(newClient);
    }

    @Override
    public ResponseEntity<Client> updateClient(Long clientId, Client client) {
        ClientEntity clientEntity = clientRepository.findById(clientId)
                .orElse(null);
        if (clientEntity == null) {
            return ResponseEntity.notFound().build();
        }
        ClientModelToEntity builder = new ClientModelToEntity(client);
        ClientEntity putObject = builder.build();
        putObject.setId(clientId);
        Client newClient = clientFromEntity(clientRepository.save(putObject));
        return ResponseEntity.ok(newClient);
    }

    @Override
    public ResponseEntity<Client> getClientById(Long clientId) {
        ClientEntity clientEntity = clientRepository.findById(clientId)
                .orElse(null);
        if (clientEntity == null) {
            return ResponseEntity.notFound().build();
        }
        Client newClient = clientFromEntity(clientEntity);
        return ResponseEntity.ok(newClient);
    }

    @Override
    public ResponseEntity<Void> deleteClient(Long clientId) {
        if (!clientRepository.existsById(clientId)) {
            return ResponseEntity.notFound().build();
        }
        clientRepository.deleteById(clientId);
        return ResponseEntity.noContent().build();
    }

    private ClientPage clientPageFromEntities(Page<ClientEntity> page, ClientAgeStats ageStats) {
        ClientPageBuilderImpl builder = new ClientPageBuilderImpl(page, ageStats);
        builder.buildHeader();
        builder.buildItems();
        return builder.build();
    }

    private Client clientFromEntity(ClientEntity entity) {
        ClientEntityToModel builder = new ClientEntityToModel(entity);
        return builder.build();
    }
}
