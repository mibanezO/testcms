package com.test.abc.testcms.projection;

import java.math.BigDecimal;

public interface ClientStatProjection {
    BigDecimal getMean();
    BigDecimal getMin();
    BigDecimal getMax();
    BigDecimal getStdDev();
}
