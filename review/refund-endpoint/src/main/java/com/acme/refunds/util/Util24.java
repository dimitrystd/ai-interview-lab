package com.acme.refunds.util; 

import java.util.stream.Stream; 
import java.util.Arrays; 

public final class Util24 { 

    private Util24() { 
    } 

    public static Stream<String> tokens(String value) { 
        return Arrays.stream(value.trim().split("\\s+")) 
                .filter(token -> !token.isEmpty()); 
    } 
} 
