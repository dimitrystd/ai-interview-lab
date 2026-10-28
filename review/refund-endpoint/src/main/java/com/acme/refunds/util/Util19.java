package com.acme.refunds.util;

import java.util.concurrent.atomic.AtomicLong;
import java.util.function.Supplier;

public final class Util19 {

    private Util19() {
    }

    public static Supplier<Long> sequence(long start) {
        AtomicLong next = new AtomicLong(start);
        return next::getAndIncrement;
    }
}
