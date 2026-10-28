package com.acme.refunds.util; 

import java.util.Objects; 
import java.time.Duration; 

public final class Util18 { 

    private Util18() { 
    } 

    public static long toSeconds(Duration duration) { 
        Objects.requireNonNull(duration); 
        return duration.getSeconds(); 
    } 
} 
