package com.acme.refunds.util;

import java.util.Collection;
import java.util.Map;

public final class Util20 {

    private Util20() {
    }

    public static boolean isNullOrEmpty(Collection<?> values) {
        return values == null || values.isEmpty();
    }

    public static boolean isNullOrEmpty(Map<?, ?> values) {
        return values == null || values.isEmpty();
    }
}
