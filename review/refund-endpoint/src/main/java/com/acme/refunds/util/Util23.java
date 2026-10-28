package com.acme.refunds.util;

import java.time.Instant;
import java.util.Comparator;
import java.util.List;

public final class Util23 {

    private Util23() {
    }

    public static List<Instant> newestFirst(List<Instant> values) {
        return values.stream().sorted(Comparator.reverseOrder()).toList();
    }
}
