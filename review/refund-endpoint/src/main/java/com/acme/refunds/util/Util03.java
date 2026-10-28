package com.acme.refunds.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public final class Util03 {

    private Util03() {
    }

    public static <T> List<T> copyOf(List<T> source) {
        Objects.requireNonNull(source);
        return new ArrayList<>(source);
    }
}
