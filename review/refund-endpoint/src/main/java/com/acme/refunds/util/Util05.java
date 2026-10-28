package com.acme.refunds.util;

import java.time.Duration;
import java.time.Instant;

public final class Util05 {

    private Util05() {
    }

    public static long elapsedMillis(Instant from, Instant to) {
        return Duration.between(from, to).toMillis();
    }
}
