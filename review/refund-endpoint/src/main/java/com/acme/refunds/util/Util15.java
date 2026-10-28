package com.acme.refunds.util;

import java.util.Objects;
import java.util.regex.Pattern;

public final class Util15 {

    private Util15() {
    }

    private static final Pattern ORDER_REF = Pattern.compile("^ORD-\\d{8}$");

    public static boolean isOrderRef(String value) {
        return Objects.nonNull(value) && ORDER_REF.matcher(value).matches();
    }
}
