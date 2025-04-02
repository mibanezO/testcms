package com.test.abc.testcms.service;

import com.test.abc.testcms.entity.ClientEntity;
import com.test.abc.testcms.model.Client;
import com.test.abc.testcms.projection.ClientStatProjection;
import com.test.abc.testcms.repository.ClientRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatusCode;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ClientServiceTest {

    private final ClientRepository clientRepository = mock(ClientRepository.class);
    private ClientService clientService;

    @BeforeEach
    void setUp() {
        clientService = new ClientService(clientRepository);
    }

    @Test
    void addClient() {
        Client client = getClient();
        when(clientRepository.save(any(ClientEntity.class))).thenAnswer(args -> {
            ClientEntity clientEntity = args.getArgument(0);
            clientEntity.setId(1L);
            return clientEntity;
        });
        Client saved = clientService.addClient(client).getBody();
        Assertions.assertNotNull(saved);
        Assertions.assertNotNull(saved.getId());
    }

    @Test
    void updateClient() {
        Long id = 1L;
        Client client = getClient();
        ClientEntity clientEntity = new ClientEntity();
        clientEntity.setId(id);
        when(clientRepository.findById(eq(id)))
                .thenReturn(Optional.of(clientEntity));
        when(clientRepository.save(any(ClientEntity.class)))
                .thenAnswer(args -> args.getArgument(0));
        Client updated = clientService.updateClient(id, client).getBody();
        Assertions.assertNotNull(updated);
        Assertions.assertNotNull(updated.getId());
    }

    @Test
    void updateClientNotFound() {
        Long id = 1L;
        Client client = getClient();
        ClientEntity clientEntity = new ClientEntity();
        clientEntity.setId(id);
        when(clientRepository.findById(eq(id)))
                .thenReturn(Optional.empty());
        HttpStatusCode httpStatusCode = clientService.updateClient(id, client).getStatusCode();
        Assertions.assertNotNull(httpStatusCode);
        Assertions.assertEquals(404, httpStatusCode.value());
    }

    @Test
    void patchClient() {
        Long id = 1L;
        ClientEntity clientEntity = new ClientEntity();
        clientEntity.setId(id);
        clientEntity.setFirstName("Client With First Name");
        when(clientRepository.findById(eq(id))).thenReturn(Optional.of(clientEntity));
        when(clientRepository.save(any(ClientEntity.class)))
                .thenAnswer(args -> args.getArgument(0));
        Client updated = clientService.updateClientWithForm(
                id, "New Last Name", null, null, null).getBody();
        Assertions.assertNotNull(updated);
        Assertions.assertEquals("New Last Name", updated.getFirstName());
    }

    @Test
    void patchClientNotFound() {
        Long id = 1L;
        ClientEntity clientEntity = new ClientEntity();
        clientEntity.setId(id);
        clientEntity.setFirstName("Client With First Name");
        when(clientRepository.findById(eq(id))).thenReturn(Optional.empty());
        HttpStatusCode httpStatusCode = clientService.updateClientWithForm(
                id, "New Last Name", null, null, null).getStatusCode();
        Assertions.assertNotNull(httpStatusCode);
        Assertions.assertEquals(404, httpStatusCode.value());
    }

    @Test
    void listClients() {
        Pageable pageable = PageRequest.of(0, 10);
        Page<ClientEntity> values = new PageImpl<>(List.of(new ClientEntity()), pageable, 10);
        when(clientRepository.filter(any(), any(), any())).thenReturn(values);
        when(clientRepository.getAgeStats(any(), any())).thenReturn(new ClientStatProjection() {
            @Override
            public BigDecimal getMean() {
                return BigDecimal.TEN;
            }

            @Override
            public BigDecimal getMin() {
                return BigDecimal.TEN;
            }

            @Override
            public BigDecimal getMax() {
                return BigDecimal.TEN;
            }

            @Override
            public BigDecimal getStdDev() {
                return BigDecimal.TEN;
            }
        });
        var response = clientService.listClients(0L, 10L, null, null).getBody();
        Assertions.assertNotNull(response);
        Assertions.assertNotNull(response.getAgeStats());
        Assertions.assertNotNull(response.getItems());
        Assertions.assertFalse(response.getItems().isEmpty());
    }

    private Client getClient() {
        Client client = new Client();
        client.setFirstName("Client");
        client.setLastName("Test");
        client.setAge(24);
        client.setBirthDate(LocalDate.now());
        return client;
    }

}