package com.acme.refunds.util;

import java.util.Arrays;
import java.util.List;

public final class Util17 {

    private Util17() {
    }

    public static List<String> tail(String[] values) {
        if (values.length < 2) {
            return List.of();
        }
        return Arrays.asList(values).subList(1, values.length);
    }
}
