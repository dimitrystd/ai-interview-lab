package com.acme.refunds.util;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public final class Util12 {

    private Util12() {
    }

    public static <T> List<T> distinct(List<T> values) {
        Set<T> seen = new LinkedHashSet<>(values);
        return List.copyOf(seen);
    }
}
