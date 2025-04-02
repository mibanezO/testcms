package com.test.abc.testcms.builder;

import com.test.abc.testcms.model.ClientAgeStats;
import com.test.abc.testcms.projection.ClientStatProjection;

public record AgeStatsProjectionToModel(ClientStatProjection projection) implements ClientAgeStatsBuilder {
    @Override
    public ClientAgeStats build() {
        ClientAgeStats ageStats = new ClientAgeStats();
        ageStats.setMax(projection.getMax());
        ageStats.setMin(projection.getMin());
        ageStats.setMean(projection.getMean());
        ageStats.setStd(projection.getStdDev());
        return ageStats;
    }
}
