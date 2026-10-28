package com.acme.refunds.util; 

import java.util.Objects; 
import java.util.Locale; 

public final class Util01 { 

    private Util01() { 
    } 

    public static String slug(String value) { 
        Objects.requireNonNull(value); 
        return value.trim().toLowerCase(Locale.ROOT).replace(' ', '-'); 
    } 
} 
