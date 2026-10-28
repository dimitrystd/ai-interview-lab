package com.acme.refunds.util;

import java.time.Duration;
import java.util.Objects;

public final class Util18 {

    private Util18() {
    }

    public static long toSeconds(Duration duration) {
        Objects.requireNonNull(duration);
        return duration.getSeconds();
    }
}
