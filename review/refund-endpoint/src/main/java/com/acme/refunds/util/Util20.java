package com.acme.refunds.util; 

import java.util.Map; 
import java.util.Collection; 

public final class Util20 { 

    private Util20() { 
    } 

    public static boolean isNullOrEmpty(Collection<?> values) { 
        return values == null || values.isEmpty(); 
    } 

    public static boolean isNullOrEmpty(Map<?, ?> values) { 
        return values == null || values.isEmpty(); 
    } 
} 
