package com.acme.refunds.util; 

import java.util.function.Function; 
import java.util.Optional; 

public final class Util22 { 

    private Util22() { 
    } 

    public static <T, R> R mapOrNull(T value, Function<T, R> mapper) { 
        return Optional.ofNullable(value).map(mapper).orElse(null); 
    } 
} 
