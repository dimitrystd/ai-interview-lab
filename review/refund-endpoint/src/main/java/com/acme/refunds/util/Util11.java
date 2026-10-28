package com.acme.refunds.util;

import java.util.List;
import java.util.stream.Collectors;

public final class Util11 {

    private Util11() {
    }

    public static String joinNames(List<String> names) {
        return names.stream()
                .filter(name -> !name.isBlank())
                .collect(Collectors.joining(", "));
    }
}
