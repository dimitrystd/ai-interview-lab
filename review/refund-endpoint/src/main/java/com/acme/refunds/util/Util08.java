package com.acme.refunds.util;

import java.util.Locale;
import java.util.UUID;

public final class Util08 {

    private Util08() {
    }

    public static String newReference() {
        return UUID.randomUUID().toString().replace("-", "").toUpperCase(Locale.ROOT);
    }
}
