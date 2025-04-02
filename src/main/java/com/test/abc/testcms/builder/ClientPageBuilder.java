package com.test.abc.testcms.builder;

import com.test.abc.testcms.model.ClientPage;

public interface ClientPageBuilder {
    void buildHeader();
    void buildItems();
    ClientPage build();
}
