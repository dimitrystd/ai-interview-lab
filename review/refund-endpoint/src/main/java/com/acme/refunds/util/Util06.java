package com.acme.refunds.util;

import java.util.Objects;
import java.util.Optional;

public final class Util06 {

    private Util06() {
    }

    public static Optional<String> firstNonBlank(String first, String second) {
        if (Objects.nonNull(first) && !first.isBlank()) {
            return Optional.of(first);
        }
        return Optional.ofNullable(second).filter(value -> !value.isBlank());
    }
}
