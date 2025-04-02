package com.test.abc.testcms.builder;

import com.test.abc.testcms.entity.ClientEntity;
import com.test.abc.testcms.model.Client;
import com.test.abc.testcms.model.ClientAgeStats;
import com.test.abc.testcms.model.ClientPage;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;

import java.util.List;

@RequiredArgsConstructor
public class ClientPageBuilderImpl implements ClientPageBuilder {

    private final ClientPage clientPage = new ClientPage();
    private final Page<ClientEntity> page;
    private final ClientAgeStats ageStats;

    @Override
    public void buildHeader() {
        clientPage.setAgeStats(ageStats);
        clientPage.setOffset(page.getPageable().getOffset());
        clientPage.setLimit((long) page.getPageable().getPageSize());
        clientPage.setCount(page.getTotalElements());
    }

    @Override
    public void buildItems() {
        List<Client> items = page.getContent().stream()
                .map(ClientEntityToModel::new)
                .map(ClientEntityToModel::build)
                .toList();
        clientPage.setItems(items);
    }

    @Override
    public ClientPage build() {
        return clientPage;
    }
}
