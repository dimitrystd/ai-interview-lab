package com.acme.refunds.util;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Locale;

public final class Util16 {

    private Util16() {
    }

    public static String formatMoney(BigDecimal amount) {
        return NumberFormat.getCurrencyInstance(Locale.US).format(amount);
    }
}
