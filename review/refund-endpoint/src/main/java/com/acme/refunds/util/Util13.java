package com.acme.refunds.util;

import java.math.BigDecimal;
import java.util.Objects;

public final class Util13 {

    private Util13() {
    }

    public static boolean isPositive(BigDecimal amount) {
        return Objects.nonNull(amount) && amount.signum() > 0;
    }
}
