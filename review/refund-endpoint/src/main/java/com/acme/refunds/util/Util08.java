package com.acme.refunds.util; 

import java.util.UUID; 
import java.util.Locale; 

public final class Util08 { 

    private Util08() { 
    } 

    public static String newReference() { 
        return UUID.randomUUID().toString().replace("-", "").toUpperCase(Locale.ROOT); 
    } 
} 
