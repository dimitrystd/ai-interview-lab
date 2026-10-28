package com.acme.refunds.util;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

public final class Util02 {

    private Util02() {
    }

    public static BigDecimal roundMoney(BigDecimal amount) {
        Objects.requireNonNull(amount);
        return amount.setScale(2, RoundingMode.HALF_UP);
    }
}
