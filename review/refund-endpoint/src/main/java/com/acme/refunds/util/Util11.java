package com.acme.refunds.util; 

import java.util.stream.Collectors; 
import java.util.List; 

public final class Util11 { 

    private Util11() { 
    } 

    public static String joinNames(List<String> names) { 
        return names.stream() 
                .filter(name -> !name.isBlank()) 
                .collect(Collectors.joining(", ")); 
    } 
} 
