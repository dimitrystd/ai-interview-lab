package com.acme.refunds.util; 

import java.time.Instant; 
import java.time.Duration; 

public final class Util05 { 

    private Util05() { 
    } 

    public static long elapsedMillis(Instant from, Instant to) { 
        return Duration.between(from, to).toMillis(); 
    } 
} 
