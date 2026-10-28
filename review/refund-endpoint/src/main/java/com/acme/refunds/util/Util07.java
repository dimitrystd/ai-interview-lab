package com.acme.refunds.util; 

import java.util.Map; 
import java.util.List; 
import java.util.HashMap; 

public final class Util07 { 

    private Util07() { 
    } 

    public static Map<String, Integer> frequencies(List<String> values) { 
        Map<String, Integer> counts = new HashMap<>(); 
        for (String value : values) { 
            counts.merge(value, 1, Integer::sum); 
        } 
        return counts; 
    } 
} 
